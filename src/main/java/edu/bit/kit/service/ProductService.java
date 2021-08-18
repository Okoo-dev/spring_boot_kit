package edu.bit.kit.service;

import java.util.List;

import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.page.Criteria;


public interface ProductService {
	// 상품리스트
	List<ProductVO> getList();
	// 페이징
	int getTotal(Criteria cri);
	List<ProductVO> getList(Criteria criteria);
	// 장바구니 담기
	void plusCart(CartVO cart);
	// 장바구니 리스트
	List<CartVO> listCart(String userId);
	/*
	 * // 장바구니 총 금액 int cartTotalMoney(String userId);
	 */
	// 장바구니 삭제
	int remove(int cartId);
	// 장바구니 동일 상품 카운트
	int countCart(int cartProductNumber, String userId);
	// 장바구니 업데이트
	void updateCart(CartVO cart);
	// 장바구니 총 금액
	int sumCartMoney(String userId);
	
	// 메뉴 디테일 불러오기
	ProductVO getMenu(int product_NUMBER);
	
}
