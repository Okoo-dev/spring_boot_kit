package edu.bit.kit.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.kit.security.SecurityService;
import edu.bit.kit.service.BoardService;
import edu.bit.kit.vo.AuthVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyMainBoardController {

    @Autowired
    private BoardService boardService;


    @Autowired
    SecurityService service;
    
    
    
    
    // 'ROLE_MEMBER' 또는 'ROLE_ADMIN' 인 권한 가진 상태에서만 접속 가능.  아닌 경우 login페이지로 리다이렉트.
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
        
        model.addAttribute("user",boardService.getUser(userId ));   // 아이디로 접속 중인 유저 식별
        model.addAttribute("couponCount",boardService.getCouponCount(userId )); //아이디로 가진 쿠폰 개수 식별
        model.addAttribute("expCouponCount",boardService.getExpCouponCount(userId )); // 아이디로 가진 쿠폰 중 소멸예정(14일 이내) 쿠폰 개수 식별
        model.addAttribute("couponList",boardService.getCoupon(userId ));  // 아이디로 가지고 있는 쿠폰 전체 읽어내기
        
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
    

    
    
    
    @GetMapping("/signup")
    public String signUp(Model model) {
        
        log.info("signup()..");
        
        
        return "thymeleaf/signupS";
    }
    
    
    

    
    
    @Transactional(rollbackFor = Exception.class)   //트랜잭션 추가
    @RequestMapping(value = "/signUpInsert", method = RequestMethod.POST)
    public String signUpInsert(UserVO signUpUserVO, RedirectAttributes rttr) throws Exception {
        
        log.info("signUpInsert()..");
        
        
        String result = boardService.idChk(signUpUserVO);
        
        log.info(result);
        
        /*
         * String phoneNumber = new String(phone1+ "-" + phone2+ "-" + phone3);
         * signUpUserVO.setUserPhone(phoneNumber);
         */
        
        try {
            if(result.equals("exist")) {
                return "/signup";
            }else if(result.equals("usable")) {
                log.info(signUpUserVO.getUserName() + " 가입 ");
                boardService.signUpInsert(signUpUserVO);
                log.info(signUpUserVO.getUserName() + " 권한부여 ");
                boardService.signUpAuth(signUpUserVO);
                log.info(signUpUserVO.getUserName() + " 가입포인트 부여 ");
                boardService.signUpPoint(signUpUserVO);
            }
            // 입력된 아이디가 존재한다면 -> 다시 회원가입 페이지로 돌아가기 
            // 존재하지 않는다면 -> signUpInsert
        } catch (Exception e) {
            throw new RuntimeException();
        }
              
       
        
        
        rttr.addFlashAttribute("result", "registerOK");  // 성공시 리다리렉트 된 페이지(myMain.jsp)에서 alert 띄우도록
        
        
        return "redirect:/mymain";
        }
    
         
 // 아이디 중복 체크
    @ResponseBody
    @PostMapping("/idChk")
    public String idChk(UserVO vo) throws Exception {
        log.info("idChk()..");
        
        String result = boardService.idChk(vo);
        
        log.info(result);
        
        return result;
    }



    
    
    
    
}
