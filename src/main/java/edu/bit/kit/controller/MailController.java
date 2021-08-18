package edu.bit.kit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.kit.service.MailService;
import edu.bit.kit.vo.MailVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MailController {
    
    @Autowired
    private MailService mailService;
    
    @GetMapping("/admin/mail")
    public String dispMail() {
        
        log.info(mailService.toString());
        
        return "admin/mail_view";
    }
    
    
    @PostMapping("/admin/mail")
    public void execMail(MailVO mailVO) {
        log.info("execMail" + mailVO);
        mailService.mailSend(mailVO);
    }
    
}
