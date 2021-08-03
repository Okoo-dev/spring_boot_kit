package edu.bit.kit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.kit.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyMainBoardController {

    @Autowired
    private BoardService boardService;

    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/mymain")
    public String myMain(Principal principal, Model model) {

        log.info("myMain()..");

          String userId = principal.getName();
        
          model.addAttribute("user",boardService.getUser(userId ));
          model.addAttribute("point",boardService.getPoint(userId ));
          model.addAttribute("couponCount",boardService.getCouponCount(userId ));
          
         

        return "myMain";
    }
    
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/myorder")
    public String myOrder(Principal principal, Model model) {
        
        log.info("myOrder()..");
        String userId = principal.getName();
        
        model.addAttribute("deliveryList",boardService.getDeliveryList(userId));

        
        return "thymeleaf/myOrder";
    }
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/myaddress")
    public String myAddress(Principal principal, Model model) {
        
        log.info("myAddress()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId ));
        
        
        return "thymeleaf/myAddress";
    }
    
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/myaccount")
    public String myAccount(Principal principal, Model model) {
        
        log.info("myAccount()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId ));
        
        
        return "thymeleaf/myAccount";
    }
    
    
    
    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    public String updateAccount(String bankName, String accountNumber, String accountHolder, Principal principal, RedirectAttributes rttr) {
        
        log.info("updateAccount()..");
        
        String userId = principal.getName();
        
        String userAccount = new String(bankName+ " " + accountNumber+ " " + accountHolder);
        
        log.info(userId + " "+ userAccount);
        
        boardService.updateAccount(userId, userAccount);
        
        rttr.addFlashAttribute("result", "registerOK");
        
        
       
        
        
        return "redirect:/mymain";
    }
    
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/mycoupon")
    public String myCoupon(Principal principal, Model model) {
        
        log.info("myCoupon()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId ));
        model.addAttribute("couponCount",boardService.getCouponCount(userId ));
        model.addAttribute("expCouponCount",boardService.getExpCouponCount(userId ));
        model.addAttribute("couponList",boardService.getCoupon(userId ));
        
        return "thymeleaf/myCoupon";
    }
    
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/mypoint")
    public String myPoint(Principal principal, Model model) {
        
        log.info("myPoint()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId));
        model.addAttribute("point",boardService.getPoint(userId ));

        
        
        return "thymeleaf/myPoint";
    }
    

    
    
    
    
    
    
}
