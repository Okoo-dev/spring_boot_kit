package edu.bit.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.bit.kit.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyMainBoardController {

    @Autowired
    private BoardService boardService;
    
    
    @GetMapping("/board/myMain")
    public String myMain(Model model) {
        
        
        log.info("myMain()..");
        
        model.addAttribute("user",boardService.getUser());
        model.addAttribute("point",boardService.getPoint());
        model.addAttribute("couponCount",boardService.getCouponCount());
        
        
        return "myMain";
    }
    
	
}
