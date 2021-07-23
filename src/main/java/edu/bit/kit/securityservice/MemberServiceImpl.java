package edu.bit.kit.securityservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.kit.securitymapper.MemberMapper;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        // loginId에 해당하는 정보를 데이터베이스에서 읽어 CustomUser객체에 저장한다.
        UserVO userVO = memberMapper.getUser(userId);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if (userVO != null) {
            authorities.add(new SimpleGrantedAuthority(userVO.getAuthName()));
            userVO.setAuthority(authorities);
            log.info("userVO: " + userVO);
        }
        return userVO;

    }
    @Override
    @Transactional
    public UserVO joinUser(UserVO userVO) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setUserPassword(passwordEncoder.encode(userVO.getPassword()));
        log.info("userVO: " + userVO);
        return memberMapper.joinUser(userVO);
    }
}