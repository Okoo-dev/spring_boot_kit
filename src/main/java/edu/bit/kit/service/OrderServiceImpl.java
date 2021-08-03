package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.OrderMapper;
import edu.bit.kit.mapper.ProductMapper;
import edu.bit.kit.page.Criteria;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.ProductVO;
import lombok.extern.log4j.Log4j;


@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderMapper orderMapper;


	@Override
	public List<CouponVO> couponList(String userId) {
		
		return orderMapper.getListCoupon(userId);
	}





	
	

}
