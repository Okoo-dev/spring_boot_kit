package edu.bit.kit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.OrderDetailVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.UserVO;

@Mapper
public interface AdminMapper {
    
    // 유저 리스트
    List<UserVO> getList();
    
    // 유저 상세 정보
    UserVO getUser(String userId);

    // 유저 정보 수정
    void update(UserVO userVO);
 
    // 유저 정보 삭제
    void delete(String userId);
    
    // 주문 리스트
    List<OrderVO> getOrderList();
    
    // 주문 상세 정보
    OrderDetailVO getOrder(int ordNumber);
    
    // 상품 리스트
    List<ProductVO> getProdList();
    
    // 상품 상세 정보
    ProductVO getProd(String prodNumber);
    
    // 상품 등록
    void insertProd(ProductVO productVO);
    
    // 상품 수정
    void prodUpdate(ProductVO productVO);
    
    // 상품 삭제
    void prodDelete(String prodNumber);
    
    // 공지 사항
    List<BoardVO> getNoticeList();
    
    // 1:1 문의
    List<BoardVO> getQuestionList();
    
    // 이벤트
    List<BoardVO> getEventList();
    
    // 리뷰
    List<BoardVO> getReviewList();
    
    // 조회수 증가
    void updateHit(int brdId);
     
    // 공지 사항 등록
    void insertNotice(BoardVO boardVO);
    
    // 이벤트 등록
    void insertEvent(BoardVO boardVO);

    
}
