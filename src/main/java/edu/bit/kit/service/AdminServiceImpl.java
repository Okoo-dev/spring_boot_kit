package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.AdminMapper;
import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.OrderDetailVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.ReplyVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    // interface getUserList의 구현체
    // 해당 유저목록을 객체채로 넘겨 받아옴
    @Override
    public List<UserVO> getUserList() {
        log.info("getUserList()..");
        log.info("갯수:" + adminMapper.getList());
        return adminMapper.getList();
    }

    // 유저 정보를 객체의 Id값이랑 비교해서 맵퍼로 보내고 받아오는 메서드
    @Override
    public UserVO getUser(String userId) {
        log.info("getUser..");

        return adminMapper.getUser(userId);
    }
    
    // 유저 정보 수정
    @Override
    public void modify(UserVO userVO) {
        log.info("modify..");
        adminMapper.update(userVO);
    }
    
    // 유저 정보 삭제
    @Override
    public void remove(String userId) {
        log.info("remove..");
        adminMapper.delete(userId);
    }
    
    // 주문 리스트
    @Override
    public List<OrderVO> getOrderList() {
        return adminMapper.getOrderList();
    }
    
    // 주문 상세
    @Override
    public OrderDetailVO getOrder(int ordNumber) {
        log.info("getOrder...");
        return adminMapper.getOrder(ordNumber);
    }
    
    // 상품 리스트
    @Override
    public List<ProductVO> getProdList() {
        return adminMapper.getProdList();
    }
    
    // 상품 상세 정보
    @Override
    public ProductVO getProd(String prodNumber) {
       
        return adminMapper.getProd(prodNumber);
    }
    
    // 상품 등록
    @Override
    public void prodUpload(ProductVO productVO) {
        log.info("prodUpload");
        adminMapper.insertProd(productVO);
    }
    
    
    // 상품 수정
    @Override
    public void prodModify(ProductVO productVO) {
        
        
        adminMapper.prodUpdate(productVO);
    }
    
    // 상품 삭제
    @Override
    public void prodRemove(String prodNumber) {
        adminMapper.prodDelete(prodNumber);
    }
    
    // 공지 사항
    @Override
    public List<BoardVO> getNoticeList() {
        return adminMapper.getNoticeList();
    }
    
    // 1:1문의
    @Override
    public List<BoardVO> getQuestionList() {
        return adminMapper.getQuestionList();
    }
    
    // 이벤트
    @Override
    public List<BoardVO> getEventList() {
        return adminMapper.getEventList();
    }
    
    // 리뷰
    @Override
    public List<BoardVO> getReviewList() {
        return adminMapper.getReviewList();
    }
    
    // 조회수
    @Override
    public void upHit(int brdId) {
        adminMapper.updateHit(brdId);
    }
    
    // 공지 사항 등록
    @Override
    public void noticeUpload(BoardVO boardVO) {
        log.info("prodUpload");
        adminMapper.insertNotice(boardVO);
    }
    // 게시판 수정
    @Override
    public void boardModify(BoardVO boardVO) {
        adminMapper.boardUpdate(boardVO);
    }
    
    // 게시판 삭제
    @Override
    public void boardRemove(int brdId) {
        adminMapper.boardDelete(brdId);
    }
    
    // 이벤트 등록
    @Override
    public void eventUpload(BoardVO boardVO) {
        log.info("prodUpload");
        adminMapper.insertEvent(boardVO);
    }
    
    // 게시판 글 확인
    @Override
    public BoardVO getBoard(int brdId) {
        upHit(brdId);
        return adminMapper.getBoard(brdId);
    }
    
    
    // 게층형 답글을 구현하기위한 메서드
    // 먼저 updateShape를 통해 db의 group값과 해당 글의 group값이 같고 
    // db의 step값이 해당 데이터의 step값보다 크면 db의 있는 데이터의 step값을 1증가하여 리턴해주고
    // replyUpload는 글작성 메소드와 비슷하나 group의 value값을 현재값 즉 currval로
    // 넣어주는게아니라 해당 group값을 원본의 글인 댓글이기 때문에 id값으로 해당글의 bgroup값을 넣어주는것이고
    // 계층형구조를 위해 step과 indent를 + 1씩 해준다.
    @Override
    public void replyUpload(ReplyVO replyVO) {
        adminMapper.updateShape(replyVO);
        adminMapper.replyUpload(replyVO);
        
    }


   

   
}
