package edu.bit.kit.mapper;

import java.util.List;

import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.UserVO;

public interface OrderMapper {

	List<CouponVO> getListCoupon(String userId);

	List<CouponVO> selectCoupon(String couponChoice);

	PointVO pointList(String userId);

	UserVO userInfo(String userId);
		
}
