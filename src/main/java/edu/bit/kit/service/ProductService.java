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
	
}
