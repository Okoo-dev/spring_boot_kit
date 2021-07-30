package edu.bit.kit.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.bit.kit.vo.AuthVO;
import edu.bit.kit.vo.UserVO;


public class UserPrincipalVO implements UserDetails{
	
	private ArrayList<UserVO> userVO;

	private ArrayList<AuthVO> authVO;

	public UserPrincipalVO(ArrayList<UserVO> userVO, ArrayList<AuthVO> authVO) {
		super();
		this.userVO = userVO;
		this.authVO = authVO;
	}
	
	/*
	 * public UserPrincipalVO(ArrayList<UserVO> userAuthes) { this.userVO =
	 * userAuthes; }
	 */
	
	public UserPrincipalVO(ArrayList<UserVO> userAuthes) {
		// TODO Auto-generated constructor stub
		userVO = userAuthes;
	} 




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //유저가 갖고 있는 권한 목록

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(int x=0; x<authVO.size(); x++) {
			authorities.add(new SimpleGrantedAuthority(authVO.get(x).getAuthAuthority()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() { //유저 비밀번호

		return userVO.get(0).getUserpassword();
	}

	@Override
	public String getUsername() {// 유저 이름 혹은 아이디

		return userVO.get(0).getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {// 유저 아이디가 만료 되었는지

		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 유저 아이디가 Lock 걸렸는지

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //비밀번호가 만료 되었는지

		return true;
	}

	@Override
	public boolean isEnabled() { // 계정이 활성화 되었는지

		return true;
	}

	
}