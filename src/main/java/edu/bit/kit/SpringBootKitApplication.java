package edu.bit.kit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

// @WebListener 스캔을 가능하도록 어노테이션 설정
@ServletComponentScan
// 앞서 multipartResolver를 등록했기 때문에 첨부파일 관련 자동구성을 사용하지않도록 설정
@SpringBootApplication(exclude={MultipartAutoConfiguration.class})
public class SpringBootKitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKitApplication.class, args);
	}

}
