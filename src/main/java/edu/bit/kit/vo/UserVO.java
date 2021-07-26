package edu.bit.kit.vo;
import java.util.Collection;
/*
유저아이디(PK)	user_id(PK)	N/A	VARCHAR2(100)	NOT NULL
유저번호	co_number	N/A	NUMBER(38)	NULL
유저비밀번호	co_password	N/A	VARCHAR2(100)	NULL
유저이름	co_name	N/A	VARCHAR2(100)	NULL
유저휴대폰번호	co_phone	N/A	VARCHAR2(100)	NULL
유저이메일	co_email	N/A	VARCHAR2(100)	NULL
유저생년월일	co_birth	N/A	DATE	NULL
유저성별	co_gender	N/A	VARCHAR2(100)	NULL
휴면상태	co_enabled	N/A	NUMBER	NULL
회원가입날짜	co_joindate	N/A	DATE	NULL
최종로그인시간	co_logintime	N/A	DATE	NULL
배송지	co_address	N/A	VARCHAR2(100)	NULL
환불계좌	co_account	N/A	VARCHAR2(100)	NULL

*/
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class UserVO{

    
    private String userId;
	private int userNumber;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userBirth;
	private String userGender;
	private int userEnabled;
	private Date userJoinDate;
	private Date userLoginTime;
	private String userAddress;
	private String userAccount;
	private String authName;

}
