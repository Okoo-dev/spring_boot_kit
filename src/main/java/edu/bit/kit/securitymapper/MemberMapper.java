package edu.bit.kit.securitymapper;


import org.apache.ibatis.annotations.Mapper;

import edu.bit.kit.vo.UserVO;

@Mapper
public interface MemberMapper {
    
    // 로그인 정보
    UserVO getUser(String userId);
    
    // 회원가입
    UserVO joinUser(UserVO userVO);
    
}
