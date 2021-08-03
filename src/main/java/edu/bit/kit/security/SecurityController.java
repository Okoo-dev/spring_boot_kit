package edu.bit.kit.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.kit.service.OrderService;
import edu.bit.kit.service.ProductService;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecurityController {

	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;

//장바구니 담기
	@ResponseBody
	@RequestMapping(value = "/menu/cart", method = RequestMethod.POST)
	public String addCart(Principal principal, CartVO cart, HttpSession session) throws Exception {
		/*
		 * UserVO member = (UserVO)session.getAttribute("member");
		 * cart.setCartUserid(member.getUserId());
		 * String id = "jinwoo"; int pn = 2; int amount = 3; cart.setCartUserid(id);
		 * cart.setCartAmount(amount); cart.setCartProductNumber(pn);
		 */
		String userId = principal.getName();
		log.info("사용자 ID" + userId);
		cart.setCartUserid(userId);
		log.info("CartVO:" + cart);
		// 기존 장바구니 상품 조회
		int count = productService.countCart(cart.getCartProductNumber(), userId);
		
		if(count == 0) {
		// 기존 상품 0이면 신규 추가
		productService.plusCart(cart);
		} else {
		// 기존 상품 있으면 수량 추가	
		productService.updateCart(cart);	
		}
		return "SUCCESS";
	}

// 장바구니 리스트
	/*
	 * @RequestMapping(value = "/menu/cartlist", method = RequestMethod.GET) public
	 * ModelAndView list(Principal principal, ModelAndView mav) {
	 * 
	 * String userId = principal.getName(); Map<String, Object> map = new
	 * HashMap<String, Object>(); 
	 * List<Map<String, Object>> listMap = new
	 * ArrayList<Map<String, Object>>(); // 장바구니 정보 List<CartVO> list =
	 * productService.listCart(userId); 
	 * // 장바구니 금액 총합 
	 * int cartTotalMoney =
	 * productService.cartTotalMoney(userId); map.put("list", list); // 장바구니 정보 map
	 * 저장 map.put("count", list.size()); // 장바구니 유무 map.put("carTotalMoney",
	 * cartTotalMoney); // 장바구니 총액 mav.setViewName("cartList"); // view(jsp)의 이름 저장
	 * mav.addObject("listMap", listMap); // map 변수 저장
	 * 
	 * listMap.add(map);
	 * 
	 * return mav; }
	 */

	// 장바구니 리스트
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCartList(Principal principal, Model model) throws Exception {
		log.info("get cart list");

		String userId = principal.getName();

		List<CartVO> cartList = productService.listCart(userId);
		log.info("List<CartVO> cartList :::::::" + cartList);
		//log.info("List<CartVO> cartList :::::::" + cartList.get(4));
		model.addAttribute("cartList", cartList);
		
		// 장바구니 총 금액
		int sumMoney = productService.sumCartMoney(userId);						
		model.addAttribute("sumMoney", sumMoney);
		return "thymeleaf/cartList";
	}

	// 장바구니 삭제
	@RequestMapping(value = "/cartDelete", method = RequestMethod.GET)
	@ResponseBody
	public String cartDelete(CartVO cartVO) {
		log.info("cartDelete()..");

		productService.remove(cartVO.getCartId());

		return "SUCESS";
	}
	
	// 장바구니 수정
	//@RequestMapping(value = "/cartModify", method = RequestMethod.POST)
	
	// 주문페이지 주문 상품 리스트
	@RequestMapping(value="/order", method = RequestMethod.GET)
	public String orderCartList(Principal principal, Model model) throws Exception {
		log.info("get orderCartList");
		String userId = principal.getName();
		
		List<CartVO> orderCartList = productService.listCart(userId);
		log.info("List<CartVO> cartList :::::::" + orderCartList);
		
		model.addAttribute("orderCartList", orderCartList);
		
		// 장바구니 총 금액
				int sumMoney = productService.sumCartMoney(userId);						
				model.addAttribute("sumMoney", sumMoney);
		// 주문페이지 쿠폰 조회		
				List<CouponVO> orderCouponList = orderService.couponList(userId);
				log.info("List<CouponVO> orderCouponList::::::" + orderCouponList);				
				model.addAttribute("orderCouponList", orderCouponList);
				
		
		return "thymeleaf/OrderPage";
	}
	
	// 주문페이지 쿠폰 조회
	@RequestMapping(value="/order/coupon", method = RequestMethod.GET)
	public String orderCouponList(Principal principal, Model model) throws Exception {
		log.info("get orderCouponList");
		String userId = principal.getName();
		
		List<CouponVO> orderCouponList = orderService.couponList(userId);
		log.info("List<CouponVO> orderCouponList::::::" + orderCouponList);
		
		model.addAttribute("orderCouponList", orderCouponList);
		
		
		return "thymeleaf/OrderPage";
	}
	
}
/*
 * 
 * @GetMapping("/") public String loadExceptionPage(ModelMap model) throws
 * Exception{
 * 
 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 * UserPrincipalVO userPrincipalVO = (UserPrincipalVO) auth.getPrincipal();
 * 
 * model.addAttribute("name",userPrincipalVO.getUsername());
 * model.addAttribute("auth",userPrincipalVO.getAuthorities());
 * 
 * return "thymeleaf/menu"; }
 * 
 * @GetMapping("/access-denied") public String loadAccessdeniedPage() throws
 * Exception{ return "thymeleaf/menu"; }
 */
