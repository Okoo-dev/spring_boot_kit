package edu.bit.kit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.bit.kit.vo.UserVO;

@Mapper
public interface MemberMapper {
    
    
    // 유저정보
    ArrayList<UserVO> findByUserId(@Param("userid")String userId);
    
    
    // 유저저장
    int userSave(UserVO userVO);
    
    // 유저권한저장
    int userRoleSave(@Param("userNumber") int userNumber,@Param("authId") int authId);
    
    // 
    
}
