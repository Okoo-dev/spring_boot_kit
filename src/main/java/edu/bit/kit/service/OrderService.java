package edu.bit.kit.service;

import java.util.List;

import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.page.Criteria;


public interface OrderService {
	
	
	// 주문페이지 쿠폰 조회
	List<CouponVO> couponList(String userId);
	
}
