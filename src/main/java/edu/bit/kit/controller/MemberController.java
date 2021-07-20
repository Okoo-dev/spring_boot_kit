package edu.bit.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.kit.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    
    // 메인 페이지 
    @GetMapping("/")
    public String main() {
        return "index";
    }
    
    // 로그인 페이지 
    @GetMapping("/user/login")
    public String login() {
        return "login/login";
    }
    
    // 로그인 에러 페이지
    @GetMapping("/login_error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        
        return "login/login";
    }
    
    // 회원가입 페이지
    @PostMapping("/user/signup")
    public String joinup() {
        
        return "login/joinup";
        
    }
    
    /*
     * // 회원가입 처리
     * 
     * @PostMapping("/user/signup") public String signup(MemberVO memberVO) {
     * memberService.joinUser(memberVO);
     * 
     * return "redirect:/user/login"; }
     */
    // 접근 거부 페이지
    @GetMapping("/denied")
    public String doDenied() {
        
        // 폴더명은 정해지는대로 바꿔야함
        return "member/denied";
    }
    
    // 로그인 유저 페이지
    @GetMapping("/info")
    public String Myinfo() {
        
        return "member/info";
    }
    
    
  
    
}
