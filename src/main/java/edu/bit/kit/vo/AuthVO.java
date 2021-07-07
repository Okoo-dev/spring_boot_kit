package edu.bit.kit.vo;

import java.sql.Timestamp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthVO {

	private int authId;
	private String authAuthority;
	private String authEabled;
	private String userId;

}
