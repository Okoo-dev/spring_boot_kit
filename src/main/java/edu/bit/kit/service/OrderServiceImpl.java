package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.OrderMapper;
import edu.bit.kit.mapper.ProductMapper;
import edu.bit.kit.page.Criteria;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.log4j.Log4j;


@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderMapper orderMapper;

	// 쿠폰 리스트 조회
	@Override
	public List<CouponVO> couponList(String userId) {
		
		return orderMapper.getListCoupon(userId);
	}
	// 선택한 쿠폰 조회
	@Override
	public List<CouponVO> selectCoupon(String couponChoice) {
		
		return orderMapper.selectCoupon(couponChoice);
	}
	// 포인트 조회
	@Override
	public PointVO PointList(String userId) {
		
		return orderMapper.pointList(userId);
	}
	// 주문 유저 정보
	@Override
	public UserVO userInfo(String userId) {
		
		return orderMapper.userInfo(userId);
	}
	
	// 주문 성공 전달
	@Override
	public void orderSuccess(OrderVO orderVO) {
		orderMapper.orderSuccess(orderVO);
		
	}
	// 주문 성공 시 장바구니 비우기
	@Override
	public void cartDelete(String userId) {
		
		orderMapper.cartDelete(userId);
	}
	// 주문 적용 쿠폰 삭제
	@Override
	public void couponDelete(int cpnId) {
		 orderMapper.couponDelete(cpnId);
		
	}
	// 주문 적용 적립금 차감
	@Override
	public void pointDeducted(int pointDiscount, String userId) {
		orderMapper.pointDeducted(pointDiscount, userId);
		
	}
	// 오더 디테일 삽입
	@Override
	public void orderDetail(int ordNumber, String userId) {
		orderMapper.orderDetail(ordNumber, userId);
		
	}
	// 페이 정보 삽입
	@Override
	public void payInfo(int ordNumber, String payChoice) {
		orderMapper.payInfo(ordNumber, payChoice);
		
	}
	
	





	
	

}
