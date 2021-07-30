package edu.bit.kit.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.kit.mapper.ProductMapper;
import edu.bit.kit.vo.AuthVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private ProductMapper securityMapper;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		// DB로부터 회원 정보를 가져온다.
		// Custom한 Userdetails 클래스를 리턴 해주면 된다.

		ArrayList<UserVO> userAuthes = securityMapper.findByUserId(userId);
		

		UserVO user = userAuthes.get(0);
		log.info(user.toString());
				
		if (userAuthes.size() == 0) {
			throw new UsernameNotFoundException("User " + userId + " Not Found!");
		}

		/*
		 * AuthVO auth = new AuthVO(); auth.setAuthAuthority("ROLE_MEMBER");
		 * auth.setUserId("1111"); auth.setAuthEabled("1");
		 * 
		 * ArrayList<AuthVO> authVO = new ArrayList<AuthVO>(); authVO.add(auth);
		 */

		
		
		return new UserPrincipalVO(userAuthes , userAuthes.get(0).getAuthList()); // UserDetails 클래스를 상속받은 UserPrincipalVO 리턴한다.
	}

	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	/*
	 * public String insertUser(UserVO userVO, AuthVO authVO) {
	 * 
	 * userVO.setUserpassword(bCryptPasswordEncoder.encode(userVO.getUserpassword())
	 * ); int flag = securityMapper.userSave(userVO);
	 * 
	 * if (flag > 0) {
	 * 
	 * 
	 * String userId = securityMapper.findUserNo(userVO.getUserId()); int
	 * authAuthority = securityMapper.findRoleNo(authVO.getAuthId());
	 * 
	 * securityMapper.userRoleSave(userId, authAuthority);
	 * 
	 * 
	 * return "success"; }
	 * 
	 * return "fail"; }
	 */
	
	public String addUser(UserVO userVO) {

		userVO.setUserPassword(bCryptPasswordEncoder.encode(userVO.getUserPassword()));
		int flag = securityMapper.userSave(userVO);

		if (flag > 0) {
			
			List<AuthVO> authList = userVO.getAuthList();
			
			for (AuthVO auth : authList) {
				securityMapper.userRoleSave(auth);
			}			
			return "success";
		}
		
		return "fail";
	}

}
