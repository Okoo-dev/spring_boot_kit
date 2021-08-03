package edu.bit.kit.vo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO {

	private String userId;
	private int userNumber;
	private String userpassword;
	private String userName;
	private String userPhone;
	private String userEmail;
	private Date userBirth;
	private String userGender;
	private int userEnabled;
	private Date userJoinDate;
	private Date userLoginTime;
	private String userAddress;
	private String userAccount;


	private String roleName;


	private ArrayList<AuthVO> authList;
}
