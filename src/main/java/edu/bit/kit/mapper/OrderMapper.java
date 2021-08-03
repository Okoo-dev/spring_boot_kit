package edu.bit.kit.mapper;

import java.util.List;

import edu.bit.kit.vo.CouponVO;

public interface OrderMapper {

	List<CouponVO> getListCoupon(String userId);
		
}
