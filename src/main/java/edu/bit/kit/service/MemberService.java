package edu.bit.kit.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.kit.mapper.MemberMapper;
import edu.bit.kit.vo.UserPrincipalVO;
import edu.bit.kit.vo.UserVO;

@Service
public class MemberService implements UserDetailsService{
    
    @Autowired
    MemberMapper memberMapper;
    
    
    
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        
        // 회원 정보를 가져오는 로직
        ArrayList<UserVO> userAuthes = memberMapper.findByUserId(userId);
        
        if(userAuthes.size() == 0) {
            throw new UsernameNotFoundException("USER" +userId+"Not Found!");
        }
        return new UserPrincipalVO(userAuthes); // UserDetails 클래스를 상속받은 UserPrincipalVO
    }
    
}
