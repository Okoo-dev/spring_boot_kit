package edu.bit.kit.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.kit.service.BoardService;
import edu.bit.kit.service.OrderService;
import edu.bit.kit.service.ProductService;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.UserVO;
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
	@PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCartList(Principal principal, Model model) throws Exception {
		log.info("get cart list");

		String userId = principal.getName();

		List<CartVO> cartList = productService.listCart(userId);
		log.info("List<CartVO> cartList :::::::" + cartList);
		//log.info("List<CartVO> cartList :::::::" + cartList.get(4));
		model.addAttribute("cartList", cartList);
		
		
		//장바구니 뱃지 위한 카운트 
		model.addAttribute("cartCount",productService.getCartCount(userId));
		

		
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
	public String orderCartList(Principal principal, Model model, CouponVO couponVO) throws Exception {
		log.info("get orderCartList");
		
		log.info("couponVO" + couponVO);
		
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
				// 쿠폰 적용 시 할인 금액 & 쿠폰명 노출
				if(couponVO.getCpn() != 0) {
				// 적용 쿠폰 할인 금액 노출		
						model.addAttribute("couponDiscount", couponVO.getCpn());
						log.info("couponDiscount::::::" + couponVO.getCpn());				
				// 적용 쿠폰 노출			
						String selectCpnId = String.valueOf(couponVO.getCpnId());
						List<CouponVO> selectCoupon = orderService.selectCoupon(selectCpnId);							
						model.addAttribute("selectCoupon", selectCoupon);
						log.info("selectCoupon::::::" + selectCoupon);
				}else {
					model.addAttribute("couponDiscount", 0);
					model.addAttribute("selectCoupon", null);
					
				}
				
		// 가용 적립금
				PointVO savePoint = orderService.PointList(userId);
				int point = savePoint.getPoint();
				model.addAttribute("point", point);
				
		// 로그인 시, 유저 정보 받아오기
				UserVO userInfo = orderService.userInfo(userId);
				model.addAttribute("userInfo", userInfo);
				log.info("userInfo::::::" + userInfo);
		/*
		 * List<CouponVO> selectCoupon = orderService.selectCoupon(selectId);
		 * log.info("selectCoupon::::::" + selectCoupon);
		 */
				// 쿠폰네임으로 쿠폰선택 파라미터로 받을때
				//model.addAttribute("selectCoupon", couponVO.getCpnName());
				//log.info("couponVO.getCpnId()::::::" + couponVO.getCpnName(), "UTF-8");
				
		//장바구니 뱃지 위한 카운트 
		model.addAttribute("cartCount",productService.getCartCount(userId));		
				
				
				
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
		
		//장바구니 뱃지 위한 카운트 
        model.addAttribute("cartCount",productService.getCartCount(userId));
		
		
		return "thymeleaf/OrderPage";
	}
	
	// 쿠폰 선택
	@RequestMapping(value="/coupon/choice", method = RequestMethod.POST)
	public String couponChoice(Principal principal, Model model, String couponChoice) throws Exception {
					
		log.info("cpn아이디 확인" + couponChoice);
		List<CouponVO> selectCoupon = orderService.selectCoupon(couponChoice);		
		log.info("선택 쿠폰 확인" + selectCoupon);
		
		String userId = principal.getName();		
		// 장바구니 총 금액
		int sumMoney = productService.sumCartMoney(userId);	
		
		// 적용 쿠폰 할인
		int coupon;		
		if(selectCoupon.get(0).getCpn() <= 100) {					
			coupon = (int)(sumMoney*((float)selectCoupon.get(0).getCpn()/100));
			log.info("퍼센트일경우" + coupon);		
		}else {						
			coupon = selectCoupon.get(0).getCpn();
			log.info("할인액일경우" + coupon);
		}
		
		// 적용 쿠폰 번호
				int selectId = selectCoupon.get(0).getCpnId();
		// 적용 쿠폰 이름
				String selectName = selectCoupon.get(0).getCpnName();
				log.info("이름확인" + selectName);
		return "redirect:/order?cpn=" + String.valueOf(coupon)+"&"+ "cpnId="+ String.valueOf(selectId);
			
	}
	
	// 최종결제 정보 받아오기
	
		@RequestMapping(value="/orderInfo", method=RequestMethod.POST)
		@ResponseBody
		public String orderComplete(Principal principal,@RequestBody OrderVO orderVO) throws Exception{
						
			log.info("주문건 넘어오는거 확인" + orderVO);
					
			String userId = principal.getName();
			orderVO.setUserId(userId);
			// 주문 정보
			orderService.orderSuccess(orderVO);
			// 주문상품 장바구니 비우기
			orderService.cartDelete(orderVO.getUserId());
			// 주문 적용 쿠폰 삭제
			if(orderVO.getCpnId() != 0) {
				orderService.couponDelete(orderVO.getCpnId());
			}else {
				log.info("쿠폰 미적용 시");
			}
			// 주문 적용 포인트 차감
			if(orderVO.getPointDiscount() != 0) {
				orderService.pointDeducted(orderVO.getPointDiscount(), orderVO.getUserId());
			}else {
				log.info("포인트 미적용 시");
			}
			// 주문 상세
			orderService.orderDetail(orderVO.getOrdNumber(), orderVO.getUserId());
			// 페이 정보
			orderService.payInfo(orderVO.getOrdNumber(), orderVO.getPayChoice());
			

			return "SUCCESS";
		}
		@RequestMapping(value="/orderComplete", method=RequestMethod.GET)

		public String orderCompletea(Principal principal) throws Exception{
					log.info("ajax 넘어가냐~~~~~~");

			return "thymeleaf/orderComplete";
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
