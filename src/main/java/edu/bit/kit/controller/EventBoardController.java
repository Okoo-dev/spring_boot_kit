package edu.bit.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.bit.kit.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EventBoardController {

    @Autowired
    private BoardService boardService;
    
    
    @GetMapping("/board/event")
    public String eventList(Model model) {
        
        
        log.info("event()..");
        model.addAttribute("eventList",boardService.getEventList());
        
        
        return "eventPage";
    }
    
	
}
