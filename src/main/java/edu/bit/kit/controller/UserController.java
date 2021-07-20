package edu.bit.kit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.kit.page.Criteria;
import edu.bit.kit.page.PageVO;
import edu.bit.kit.service.ProductService;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/*
유저아이디(PK)	user_id(PK)	N/A	VARCHAR2(100)	NOT NULL
유저번호	co_number	N/A	NUMBER(38)	NULL
유저비밀번호	co_password	N/A	VARCHAR2(100)	NULL
유저이름	co_name	N/A	VARCHAR2(100)	NULL
유저휴대폰번호	co_phone	N/A	VARCHAR2(100)	NULL
유저이메일	co_email	N/A	VARCHAR2(100)	NULL
유저생년월일	co_birth	N/A	DATE	NULL
유저성별	co_gender	N/A	VARCHAR2(100)	NULL
휴면상태	co_enabled	N/A	NUMBER	NULL
회원가입날짜	co_joindate	N/A	DATE	NULL
최종로그인시간	co_logintime	N/A	DATE	NULL
배송지	co_address	N/A	VARCHAR2(100)	NULL
환불계좌	co_account	N/A	VARCHAR2(100)	NULL

*/




@Slf4j
@Controller
public class UserController{
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/test")
	public String getUser(Model model) {
		UserVO user = new UserVO("jinwoo9875",1, "9875","송진우", "2134@naver.com", null, null, null, 0, null, null, null, null);
		model.addAttribute("user", user);
		return "test";
				
	}
	
	@GetMapping("/menu")
	public String menu(Criteria cri, Model model) {
		model.addAttribute("list", productService.getList(cri));
		int total = productService.getTotal(cri);
		
		model.addAttribute("pageMaker", new PageVO(cri,total));
		
		return "Menu";
	}
	
	@GetMapping("/order")
	public String order(Model model) {
		model.addAttribute("list", productService.getList());
		log.info("/order");
		return "OrderPage";
	}
	
	// 장바구니
	@ResponseBody
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public void addCart(CartVO cart, HttpSession session) throws Exception {
		/*
		 * UserVO member = (UserVO)session.getAttribute("member");
		 * cart.setCartUserid(member.getUserId());
		 */		
		/*
		 * String id = "jinwoo"; int pn = 2; int amount = 3; cart.setCartUserid(id);
		 * cart.setCartAmount(amount); cart.setCartProductNumber(pn);
		 */
		log.info("CartVO:" + cart);
		
		
		productService.plusCart(cart);
		
	}
	
	
}
