package edu.bit.kit.service;

import java.util.List;

import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.UserVO;
import edu.bit.kit.page.Criteria;


public interface OrderService {
	
	
	// 주문페이지 쿠폰 조회
	List<CouponVO> couponList(String userId);
	// 선택 쿠폰 적용
	List<CouponVO> selectCoupon(String couponChoice);
	// 포인트 조회
	PointVO PointList(String userId);
	// 주문 시 로그인 유저정보 조회
	UserVO userInfo(String userId);
	// 주문 정보 전달
	void orderSuccess(OrderVO orderVO);
	// 장바구니 비우기
	void cartDelete(String userId);
	// 사용 쿠폰 삭제
	void couponDelete(int cpnId);
	// 사용 적립금 차감	
	void pointDeducted(int pointDiscount, String userId);
	// 오더 디테일 삽입
	void orderDetail(int ordNumber, String userId);
	// 페이 정보 삽입
	void payInfo(int ordNumber, String payChoice);
	
	
	
}
