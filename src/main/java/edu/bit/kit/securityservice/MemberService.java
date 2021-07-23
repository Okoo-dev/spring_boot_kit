package edu.bit.kit.securityservice;

import org.springframework.security.core.userdetails.UserDetailsService;

import edu.bit.kit.vo.UserVO;

public interface MemberService extends UserDetailsService{
    public UserVO joinUser(UserVO userVO);
}
