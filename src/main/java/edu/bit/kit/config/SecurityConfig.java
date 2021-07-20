package edu.bit.kit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.bit.kit.service.MemberService;

// 시큐리티 설정클래스라고 등록
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private MemberService memberService;
    
    
    /*
     * // 비밀번호 암호화를 위한 Bean
     * 
     * @Bean public PasswordEncoder passwordEncoder() { return new
     * BCryptPasswordEncoder(); }
     */
    

    // web FiterChainProxy 생성 필터
    @Override
    public void configure(WebSecurity web) throws Exception{
        // 이미지,자바스크립트,css 등등 디렉토리 보안
        web.ignoring().antMatchers("/css/**","/img/**","/js/**","/lib.**","/vendor/**");
    }
    
    
    // http 관련 보안 설정*****
    // url 별 권한 설정, 로그인, 세션 등등 HTTP 보안 관련 설정을 하는 메서드
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
            // 페이지 권한 설정
            .antMatchers("/").hasRole("MEMBER") // MEMBER,ADMIN 만 접근 허용
            .antMatchers("/admin").hasRole("ADMIN") // ADMIN 만 접근 허용
            .antMatchers("/**").permitAll() // 그외 모든 경로에 대해서는 권한없이 접근 허용
            // .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
            
            .and() // 로그인 설정
            .formLogin()
            .loginPage("/login") // Custom 로그인 페이지 사용
            .failureUrl("/login_error") // 로그인 실패 시 이동
            .defaultSuccessUrl("/") // 로그인 성공시 redirect 이동
            
            .and() // 로그아웃 설정
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃시 페이지 재정의
            .logoutSuccessUrl("/") // 로그아웃 성공 시 redirect 이동
            .invalidateHttpSession(true) // HTTP Session 초기화
            .deleteCookies("JSESSIONID") // 특정 쿠키 제거
            
            .and()
            // 403 Forbidden은 서버가 허용하지 않는 웹 페이지나 미디어를 
            // 사용자가 요청할 때 웹 서버가 반환 하는 HTTP 상태 코드이다.
            // 클라이언트가 서버에 도달할 수 있어도 서버가 페이지 접근 허용을 거부했다는 것을 뜻함
            .exceptionHandling().accessDeniedPage("/denied");
            
    }
    
    
    // 인증을 진행할 provider
    // DB로부터 아이디 비번이 맞는지 해당 유저가 어떤 권한을 가지는지 체크하는 메서드
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
        
        
    }
}
