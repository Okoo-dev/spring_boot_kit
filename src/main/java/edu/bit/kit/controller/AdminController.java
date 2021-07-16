package edu.bit.kit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.kit.service.AdminService;
import edu.bit.kit.vo.OrderDetailVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    // admin 페이지 호출 메서드
    @GetMapping("/")
    public String adminMain() {

        log.info("adminMain..");

        return "admin/admin_main";
    }

    // 회원 관리 페이지 호출 메서드
    @GetMapping("/admin/userlist")
    public String userList(Model model) {

        log.info("usertable..");
        model.addAttribute("usertable", adminService.getUserList());

        return "admin/user_list";
    }

    // 회원 상세 뷰 호출 메서드
    @GetMapping("/admin/userview")
    public String userView(UserVO userVO, Model model) {
        log.info("user_view..");
        log.info("userVO" + userVO);
        model.addAttribute("user_view", adminService.getUser(userVO.getUserId()));

        return "admin/user_view";
    }

    // 회원 정보 수정 메서드
    @PostMapping("/admin/modify")
    public String modify(UserVO userVO) {
        log.info("modify()..");
        log.info("userVO" + userVO);
        adminService.modify(userVO);

        return "redirect:userlist";
    }

    // 회원 정보 삭제 메서드
    @GetMapping("/admin/delete")
    public String delete(UserVO userVO) {
        log.info("delete()..");
        log.info("userVO" + userVO);

        adminService.remove(userVO.getUserId());

        return "redirect:userlist";
    }

    // 주문 리스트 메서드
    @GetMapping("/admin/orderlist")
    public String orderList(Model model) {

        log.info("orderview..");
        model.addAttribute("orderview", adminService.getOrderList());

        return "admin/order_list";
    }

    // 주문 상세 메서드
    @GetMapping("/admin/orderview")
    public String orderView(OrderDetailVO orderDetailVO, Model model) {
        log.info("orderDtailView..");
        log.info("orderDetailVO" + orderDetailVO);
        model.addAttribute("orderDetailView", adminService.getOrder(orderDetailVO.getOrdNumber()));

        return "admin/order_view";
    }

    // 상품 목록 화면 메서드
    @GetMapping("/admin/prodList")
    public String prodList(Model model) {
        log.info("prod_list");
        model.addAttribute("prod_list", adminService.getProdList());
        return "admin/prod_list";
    }
    
    // 상품 상세 수정 삭제 뷰
    @GetMapping("/admin/prodView")
    public String prodView(ProductVO productVO, Model model) {
        log.info("prod_view..");
        log.info("productVO" + productVO);
        model.addAttribute("prod_view", adminService.getProd(productVO.getProdNumber()));

        return "admin/prod_view";
    }

    // 상품 등록 화면 메서드
    @GetMapping("/admin/prodAdd")
    public String prodAdd() {
        return "admin/prod_add";
    }

    // 상품 등록 메서드
    @PostMapping("/admin/prodUpload")
    public String prodUpload(ProductVO productVO) {
        System.out.println("write()..");
        adminService.prodUpload(productVO);

        return "redirect:prodList";
    }

    // 상품 정보 수정 메서드

    @PostMapping("/admin/prodModify")
    public String prodModify(ProductVO productVO) {
        log.info("prodmodify()..");
        log.info("productVO" + productVO);
        
        adminService.prodModify(productVO);

        return "redirect:prodList";
    }

    // 상품 정보 삭제 메서드

    @GetMapping("/admin/prodDelete")
    public String prodDelete(ProductVO productVO) {
        log.info("proddelete()..");
        log.info("productVO" + productVO);

        adminService.prodRemove(productVO.getProdNumber());

        return "redirect:prodList";
    }

    // 상품 선택 삭제 메서드 
    // 선택 삭제를 위해서 String으로 바꿨음
    @PostMapping("/admin/prodDelete")
    public String ajaxDelete(HttpServletRequest request) {
        
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i=0; i<size; i++) {
            adminService.prodRemove(ajaxMsg[i]);
        }
        
        return "redirect:prodList";
    }

    // @PostMapping(value="")

}
