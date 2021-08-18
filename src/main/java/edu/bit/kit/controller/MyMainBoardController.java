package edu.bit.kit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.kit.security.SecurityService;
import edu.bit.kit.security.UserPrincipalVO;
import edu.bit.kit.service.BoardService;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyMainBoardController {

    @Autowired
    private BoardService boardService;


    @Autowired
    SecurityService service;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    @GetMapping("/index")
    public String main() {
        
        log.info("main()..");
        
        
        return "thymeleaf/main";
    }
    
    
    
    @GetMapping("/signin")
    public String logIn() {
        
        log.info("logIn()..");
        
        return "thymeleaf/signIn";
    }
    
    
    
    @GetMapping("/event")
    public String eventList(Model model) {
        
        
        log.info("event()..");
        
               
        model.addAttribute("eventList",boardService.getEventList());
       
        
        return "eventPage";
    }
    
    
    
    // 'ROLE_MEMBER' 또는 'ROLE_ADMIN' 인 권한 가진 상태에서만 접속 가능.  아닌 경우 login페이지로 리다이렉트.
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/mymain")
    public String myMain(Principal principal, Model model) {

        log.info("myMain()..");

          String userId = principal.getName();
        
          model.addAttribute("user",boardService.getUser(userId ));
          model.addAttribute("point",boardService.getPoint(userId ));
          model.addAttribute("couponCount",boardService.getCouponCount(userId ));
          model.addAttribute("cartCount",boardService.getCartCount(userId));
          
         

        return "myMain";
    }
    
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/myorder")
    public String myOrder(Principal principal, Model model) {
        
        log.info("myOrder()..");
        String userId = principal.getName();
        
        model.addAttribute("orderList",boardService.getOrderList(userId));
        model.addAttribute("cartCount",boardService.getCartCount(userId));
        
        
        log.info(boardService.getOrderList(userId).get(0).getUserId());
        
        return "thymeleaf/myOrder";
    }
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/myaddress")
    public String myAddress(Principal principal, Model model) {
        
        log.info("myAddress()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId ));
        model.addAttribute("cartCount",boardService.getCartCount(userId));
        
        return "thymeleaf/myAddress";
    }
    
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/myaccount")
    public String myAccount(Principal principal, Model model) {
        
        log.info("myAccount()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId ));
        model.addAttribute("cartCount",boardService.getCartCount(userId));
        
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
        model.addAttribute("cartCount",boardService.getCartCount(userId)); //아이디로 카트에 담긴 개수 읽어내기
        
        
        return "thymeleaf/myCoupon";
    }
    
    
    
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/mypoint")
    public String myPoint(Principal principal, Model model) {
        
        log.info("myPoint()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId));
        model.addAttribute("point",boardService.getPoint(userId ));
        model.addAttribute("cartCount",boardService.getCartCount(userId));
        
        
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
              
       
        
        
        rttr.addFlashAttribute("result", "registerOK");  // 성공시 리다리렉트 된 페이지에서 alert 띄우도록
        
        
        return "redirect:/index";
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


    
    // 수정 전 비밀번호 확인 페이지
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/tomodify")
    public String toModify(Principal principal, Model model) {
        
        log.info("toModify()..");
        String userId = principal.getName();
        model.addAttribute("cartCount",boardService.getCartCount(userId));
        
        return "thymeleaf/toModify";
    }
    
    
    // 수정 페이지 접속 위해 비밀번호 체크 
    @PostMapping("/passwordChk")
    public String passwordChk(String password, @AuthenticationPrincipal UserPrincipalVO userVO, RedirectAttributes rttr) {
       
        log.info("passwordChk().." + password + "======"+ userVO.getUserVO().get(0).getUserPassword());
        UserVO user = userVO.getUserVO().get(0);
        
        log.info("user().." + user);
               
        if(bCryptPasswordEncoder.matches(password, user.getUserPassword())) {
            log.info("비밀번호 일치");
            
            return "redirect:/modifyuser";
            }
        else {
            log.info("비밀번호 불일치");
            rttr.addFlashAttribute("result", "notEqual");  
           
            return "redirect:/tomodify"; 
               
        }
        
    }
    
    
    

    //수정 페이지
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/modifyuser")
    public String modifyUser(Principal principal, Model model) {
        
        log.info("modifyUser()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId ));
        model.addAttribute("cartCount",boardService.getCartCount(userId));
        
        return "thymeleaf/modifyUser";
    }
    
    
    // 수정 메소드 
    @Transactional(rollbackFor = Exception.class)   //트랜잭션 추가
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(UserVO signUpUserVO, RedirectAttributes rttr) throws Exception {
        
        log.info("updateUser()..");
        
        boardService.updateUser(signUpUserVO);
       
        rttr.addFlashAttribute("result", "registerOK");  // 성공시 리다리렉트 된 페이지(myMain.jsp)에서 alert 띄우도록
        
        
        return "redirect:/mymain";
        }
    
    
    
    
    
    
    // 탈퇴 전 비밀번호 확인 페이지
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/toresign")
    public String toResign(Principal principal, Model model) {
        
        log.info("toResign()..");
        
        String userId = principal.getName();
        model.addAttribute("cartCount",boardService.getCartCount(userId));
        
        return "thymeleaf/toResign";
    }
    
    
 // 탈퇴 페이지 접속 위해 비밀번호 체크 
    @PostMapping("/passwordChk1")
    public String passwordChk1(String password, @AuthenticationPrincipal UserPrincipalVO userVO, RedirectAttributes rttr) {
       
        log.info("passwordChk1().." + password + "======"+ userVO.getUserVO().get(0).getUserPassword());
        UserVO user = userVO.getUserVO().get(0);
        
        log.info("user().." + user);
               
        if(bCryptPasswordEncoder.matches(password, user.getUserPassword())) {
            log.info("비밀번호 일치");
            
            return "redirect:/resign";
            }
        else {
            log.info("비밀번호 불일치");
            rttr.addFlashAttribute("result", "notEqual");  
           
            return "redirect:/toresign"; 
               
        }
        
    }
    
    
    //탈퇴 페이지
    @PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/resign")
    public String resign(Principal principal, Model model) {
        
        log.info("resign()..");
        String userId = principal.getName();
        
        model.addAttribute("user",boardService.getUser(userId ));
        model.addAttribute("cartCount",boardService.getCartCount(userId));

        
        return "thymeleaf/resign";
    }
    
    
    // 탈퇴 메소드 
    @Transactional(rollbackFor = Exception.class)   //트랜잭션 추가
    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    public String deleteUser(@AuthenticationPrincipal UserPrincipalVO userVO) throws Exception {
        
        log.info("deleteUser()..");
        
        log.info(userVO.getUserVO().get(0).getUserId());
        UserVO user = userVO.getUserVO().get(0);
        
        log.info("user().." + user);
        
        boardService.deleteUser(user);
       
        
        return "redirect:/logout";
        }
    
    
    
}
