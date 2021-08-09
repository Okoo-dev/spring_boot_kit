package edu.bit.kit.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.OrderDetailVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.ReplyVO;
import edu.bit.kit.vo.UserVO;

public interface AdminService {

    // 유저 목록을 넘겨 받기위한 메서드
    public List<UserVO> getUserList();

    // 유저 상세보기 위한 메서드
    public UserVO getUser(String userId);

    // 유저 정보 수정 메서드
    public void modify(UserVO userVO);

    // 유저 정보 삭제 메서드
    public void remove(String userId);

    // 주문 목록
    public List<OrderVO> getOrderList();

    // 주문 상세
    public OrderDetailVO getOrder(int ordNumber);

    // 상품 목록
    public List<ProductVO> getProdList();

    // 상품 상세 정보
    public ProductVO getProd(String prodNumber);

    // 상품 등록 메서드
    public void prodUpload(ProductVO productVO, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

    // 상품 수정 메서드
    public void prodModify(ProductVO productVO);

    // 상품 삭제 메서드
    public void prodRemove(String prodNumber);

    // 공지 사항
    public List<BoardVO> getNoticeList();

    // 공지 사항 등록
    public void noticeUpload(BoardVO boardVO,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

    // 게시판 수정
    public void boardModify(BoardVO boardVO);

    // 게시판 삭제
    public void boardRemove(String brdId);

    // 1:1 문의
    public List<BoardVO> getQuestionList();

    // 이벤트
    public List<BoardVO> getEventList();

    // 이벤트 등록
    public void eventUpload(BoardVO boardVO);

    // 리뷰
    public List<BoardVO> getReviewList();

    // 조회수
    void upHit(String brdId);

    // 게시판 글확인 메서드
    public BoardVO getBoard(String brdId);

    // 1:1문의 답글
    public void replyUpload(ReplyVO replyVO);

}
