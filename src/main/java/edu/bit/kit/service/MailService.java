package edu.bit.kit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import edu.bit.kit.vo.MailVO;

@Service
public class MailService {
    
    @Autowired
    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "znwkdizl2@gmail.com";
    
    public void mailSend(MailVO mailVO) {
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailVO.getAddress());
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(mailVO.getTitle());
        message.setText(mailVO.getMessage());
        
        mailSender.send(message);
    }
}
