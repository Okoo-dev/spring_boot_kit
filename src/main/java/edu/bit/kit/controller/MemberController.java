package edu.bit.kit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.bit.kit.securityservice.MemberService;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping(path = "/members")
public class MemberController {
    // 스프링 컨테이너가 생성자를 통해 자동으로 주입한다.
    @Autowired
    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/loginform")
    public String loginform(){
        return "members/loginform";
    }

    @RequestMapping("/loginerror")
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }
    
    
    @GetMapping("/joinform")
    public String joinform(){
        return "members/joinform";
    }

    // 사용자가 입력한 name, email, password가 member에 저장된다.
    @PostMapping("/join")
    public String join(UserVO userVO){
        memberService.joinUser(userVO);
        log.info("userVO: " + userVO);
        return "redirect:/loginform";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "members/welcome";
    }
}