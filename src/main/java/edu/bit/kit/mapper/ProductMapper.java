package edu.bit.kit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.kit.page.Criteria;
import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.CartVO;
import edu.bit.kit.vo.ProductVO;

@Mapper
public interface ProductMapper {
	// 상품리스트
	List<ProductVO> getList();
	// 페이징
	 int getTotalCount(Criteria cri);
	 List<ProductVO> getListWithPaging(Criteria criteria);
	// 장바구니 담기
	 void addCart(CartVO cart);
	
	
}
