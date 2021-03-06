package edu.bit.kit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.OrderDetailVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.ReplyVO;
import edu.bit.kit.vo.ResourceFileVO;
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
    
    // 상품 정보에 포함되는 파일 정보 
    List<ResourceFileVO> getFileList(String prodNumber);
    
    // 게시판에 포함되어있는 파일 정보
    List<ResourceFileVO> getFileList02(String brdId);
    
    // 상품 등록
    void insertProd(ProductVO productVO);
    
    // 상품 수정
    void prodUpdate(ProductVO productVO);
    
    // 상품 삭제
    void prodDelete(String prodNumber);
    
    // 파일 첨부 메서드
    void insertFileList(List<ResourceFileVO> list);
    
    // 파일 첨부 메서드
    void insertFileList02(List<ResourceFileVO> list);
    
    // 공지 사항
    List<BoardVO> getNoticeList();
    
    // 1:1 문의
    List<BoardVO> getQuestionList();
    
    // 이벤트
    List<BoardVO> getEventList();
    
    // 리뷰
    List<BoardVO> getReviewList();
    
    // 조회수 증가
    void updateHit(String brdId);
     
    // 공지 사항 등록
    void insertNotice(BoardVO boardVO);
    
    // 이벤트 등록
    void insertEvent(BoardVO boardVO);
    
    // 게시판 글 확인 메서드 
    BoardVO getBoard(String brdId);
    
    
    // 1:1 문의 답글 
    // 보류
    /*
     * void updateShape(ReplyVO replyVO); void replyUpload(ReplyVO replyVO);
     */
     
    
    // 1:1 문의 내용
    BoardVO getQuestion(String brdId);
    
    // 게시판 수정 메서드
    void boardUpdate(BoardVO boardVO);
    
    // 게시판 삭제 메서드
    void boardDelete(String brdId);
    
    // 댓글 개수
    public int replyCount() throws Exception;
 
    // 댓글 목록
    public List<ReplyVO> getReply(String brdId) throws Exception;
 
    // 댓글 작성
    public int replyInsert(ReplyVO replyVO) throws Exception;
    
    // 댓글 수정
    public int replyUpdate(ReplyVO replyVO) throws Exception;
 
    // 댓글 삭제
    public int replyDelete(int replyId) throws Exception;



    
}
