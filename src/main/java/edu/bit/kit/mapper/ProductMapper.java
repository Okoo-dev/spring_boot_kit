package edu.bit.kit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import edu.bit.kit.page.Criteria;
import edu.bit.kit.vo.AuthVO;
import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.UserVO;

@Repository
@Mapper
public interface ProductMapper {
	// 상품리스트
	List<ProductVO> getList();
	// 페이징
	 int getTotalCount(Criteria cri);
	 List<ProductVO> getListWithPaging(Criteria criteria);
	 
	// 장바구니 담기
	 void addCart(CartVO cart);
	// 장바구니 리스트 불러오기
	List<CartVO> getListCart(String userId);					
	// 장바구니 총합
	//int getCartTotalMoney(String userId);	
	// 장바구니 삭제
	int deleteCart(int cartId);
	// 장바구니 기존 상품 조회
	int countCart(int cartProductNumber, String userId);
	// 장바구니 업데이트
	void updateCart(CartVO cart);
	// 장바구니 총합
	int sumCartMoney(String userId);
	
	
	// 장바구니 뱃지 위한 cart 카운트
	int getCartCount(String userId);
	
	
	
	// 시큐리티
		
			//유저 정보
			ArrayList<UserVO> findByUserId(@Param("userId") String userId);

			//유저 저장
			int userSave(UserVO userVO);

			//유저 권한 저장
			//int userRoleSave(@Param("userId") String userId,@Param("authId") int authId);
			int userRoleSave(@Param("authVO") AuthVO authVO);

			//유저 FK번호 알아내기
			String findUserNo(@Param("userId") String userId);

			//권한 FK번호 알아내기
			int findRoleNo(@Param("authId") int authId);
			
			
			
		
			
			
			
	
}
