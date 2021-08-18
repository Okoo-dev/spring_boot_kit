package edu.bit.kit.webconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor());
    }
    
    @Value("${spring.webservice.intro}")
    private String introPage;
     
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 루트 (/) 로 접근 시 introPage로 이동하는 매핑 추가
        registry.addRedirectViewController("/", introPage);
    }
     
    
    // add start
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);
        
        return commonsMultipartResolver;
    }
    // commonsMultipartResolver.setDefaultEncoding("UTF-8") : 파일 인코딩을 UTF-8로 설정
    // commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024) : 업로드되는 파일 
    // 크기를 제한 합니다. 바이트 단위 설정이므로 여기서는 5MB 제한을 의미
    
}
