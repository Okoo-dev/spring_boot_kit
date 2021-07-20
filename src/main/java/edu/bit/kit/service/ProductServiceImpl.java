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





	
	

}
