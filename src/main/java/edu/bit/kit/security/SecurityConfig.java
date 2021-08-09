package edu.bit.kit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@Autowired
    // private PasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	private SecurityService securityService;
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider(SecurityService securityService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(securityService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authenticationProvider;
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		  auth.authenticationProvider(authenticationProvider(securityService));
		  auth.eraseCredentials(false);
		//실제 인증을 진행할 Provider 
	}


	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * //이미지,자바스크립트,css 디렉토리 보안 설정 }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//HTTP 관련 보안 설정 **가장 중요 
		http
		.authorizeRequests()
		.antMatchers("/**").permitAll()
				/* .antMatchers().hasAnyAuthority() */
		.anyRequest().authenticated()
				
	.and()
		.csrf().ignoringAntMatchers("/user/save", "/menu/cart","/**")
	.and()
		.formLogin()
		.defaultSuccessUrl("/menu")
	.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.deleteCookies("JSESSIONID")
		.logoutSuccessUrl("/")
	.and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied");
		
		// 로그인 유지 기능 추가
		 http.rememberMe().key("securitykey")
         .userDetailsService(securityService)
         .tokenValiditySeconds(60 * 60 * 24); //24시간
	}

	
	/*
	 * permitAll() : 모두 접속 허락 하겠다.
	 * 
	 * hasAnyAuthority() : 해당 권한을 가진 유저만 접속 가능하다.
	 * 
	 * anyRequest().authenticated() : 나머지 URL은 인증을 걸쳐야 한다.
	 * 
	 * .csrf().ignoringAntMatchers("/user/save") : CSRF 토큰 없이 실행 하겠다.
	 * 
	 * defaultSuccessUrl("/") : 로그인이 성공 되면 해당 URL로 이동하겠다.
	 * 
	 * logoutRequestMatcher(new AntPathRequestMatcher("/logout")) : 해당 /logout 를 받으면
	 * 로그아웃. .deleteCookies("JSESSIONID") : JSESSIONID를 지우겠다.
	 * 
	 * accessDeniedPage("/access-denied") : 권한이 없는 URL에 접속하려고 하면 해당 URL로 리다이렉션.
	 */
}
