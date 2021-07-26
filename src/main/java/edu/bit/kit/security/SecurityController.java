package edu.bit.kit.security;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;



/*
 * @Controller public class SecurityController {
 * 
 * @GetMapping("/") public String loadExceptionPage(ModelMap model) throws
 * Exception{
 * 
 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 * UserPrincipalVO userPrincipalVO = (UserPrincipalVO) auth.getPrincipal();
 * 
 * model.addAttribute("name",userPrincipalVO.getUsername());
 * model.addAttribute("auth",userPrincipalVO.getAuthorities());
 * 
 * return "thymeleaf/menu"; }
 * 
 * @GetMapping("/access-denied") public String loadAccessdeniedPage() throws
 * Exception{ return "thymeleaf/menu"; }
 * 
 * }
 */
