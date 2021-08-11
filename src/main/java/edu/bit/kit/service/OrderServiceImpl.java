package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.OrderMapper;
import edu.bit.kit.mapper.ProductMapper;
import edu.bit.kit.page.Criteria;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.CouponVO;
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





	
	

}
