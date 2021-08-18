package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.ProductMapper;
import edu.bit.kit.page.Criteria;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.ProductVO;
import lombok.extern.log4j.Log4j;


@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductMapper productMapper;

	
	// 상품리스트
	@Override
	public List<ProductVO> getList() {		
		return productMapper.getList();
	}
	
	// 페이징
	@Override
	public int getTotal(Criteria cri) {		
		return productMapper.getTotalCount(cri) ;
	}
	@Override
	public List<ProductVO> getList(Criteria criteria) {		
		 return productMapper.getListWithPaging(criteria);
	}

	// 장바구니
	@Override
	public void plusCart(CartVO cart) {
		productMapper.addCart(cart);	
	}

	@Override
	public List<CartVO> listCart(String userId) {
		
		
 		
		return productMapper.getListCart(userId);
	}

	/*
	 * @Override public int cartTotalMoney(String userId) {
	 * 
	 * return productMapper.getCartTotalMoney(userId); }
	 */

	@Override
	public int remove(int cartId) {
		
		return productMapper.deleteCart(cartId);
	}

	@Override
	public int countCart(int cartProductNumber, String userId) {
		
		return productMapper.countCart(cartProductNumber, userId);
	}

	@Override
	public void updateCart(CartVO cart) {
		productMapper.updateCart(cart);
		
	}

	@Override
	public int sumCartMoney(String userId) {
		
		return productMapper.sumCartMoney(userId);
	}

	@Override
	public ProductVO getMenu(int product_NUMBER) {
		return productMapper.getMenu(product_NUMBER);
	}





	
	

}
