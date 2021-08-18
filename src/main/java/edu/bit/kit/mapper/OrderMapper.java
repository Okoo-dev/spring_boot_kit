package edu.bit.kit.mapper;

import java.util.List;

import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.UserVO;

public interface OrderMapper {

	List<CouponVO> getListCoupon(String userId);

	List<CouponVO> selectCoupon(String couponChoice);

	PointVO pointList(String userId);

	UserVO userInfo(String userId);
	// 주문 삽입
	void orderSuccess(OrderVO orderVO);
	// 주문 시 장바구니 비우기
	void cartDelete(String userId);
	// 주문 쿠폰 적용시 쿠폰 삭제
	void couponDelete(int cpnId);
	// 주문 적립금 적용시 적립금 차감
	void pointDeducted(int pointDiscount, String userId);
	// 주문 디테일 삽입
	void orderDetail(int ordNumber, String userId);
	// 페이 인포 삽입
	void payInfo(int ordNumber, String payChoice);
		
}
