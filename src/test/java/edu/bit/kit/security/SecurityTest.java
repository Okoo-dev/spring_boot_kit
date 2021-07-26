package edu.bit.kit.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.kit.security.SecurityService;
import edu.bit.kit.vo.AuthVO;
import edu.bit.kit.vo.UserVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityTest {
	
	@Autowired
	SecurityService service;
	
	@Test
	public void addUser() {
		
		UserVO user = new UserVO();
		user.setUserId("1111");
		user.setUserpassword("1111");
		user.setUserName("1111");
		
		AuthVO auth = new AuthVO();
		auth.setAuthAuthority("ROLE_MEMBER");
		auth.setUserId("1111");
		auth.setAuthEabled("1");
		
		//service.InsertUser(user, auth);	
		
		
	}
	
	
}
