package edu.bit.kit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.kit.vo.AuthVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserRestController{
	
	@Autowired
	private SecurityService securiyService;
	
	/*
	 * @PostMapping("/user/save") public String saveUserInfo(@RequestBody UserVO
	 * userVO, AuthVO authVO) { return securiyService.insertUser(userVO, authVO); }
	 */
	
	
	
	
}
