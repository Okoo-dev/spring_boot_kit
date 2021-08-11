package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.bit.kit.common.FileUtils;
import edu.bit.kit.mapper.AdminMapper;
import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.OrderDetailVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.ReplyVO;
import edu.bit.kit.vo.ResourceFileVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    
    
    // fileutils 클래스를 사용할 수 있도록, 먼저 fileUtils 클래스를 주입
    @Autowired
    FileUtils fileUtils;
    
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
        ProductVO productVO = adminMapper.getProd(prodNumber);
        List<ResourceFileVO> fileList = adminMapper.getFileList(prodNumber);
        productVO.setFileList(fileList);
        return productVO;
    }
    
    // 상품 등록
    // 상품 등록에서 파일 첨부 시 사용하는 파일 태그가 files(name)라는 이름으로 서버에 전송되고
    // 하나의 파일 태그로 여러 파일을 전송할 수 있습니다.
    // 하지만 화면 구성에 따라 파일 태그가 여러 개 있을 수도 있고, 화면에서 사용되는 파일태그 이름을
    // 알 수 없을 수도 있습니다.
    // 또한, 파일 태그의 이름을 알더라도 해당 이름을 코드에 직접 사용하면 추후 파일 태그명이 변경되면
    // 기존에 작성한 코드를 변경해야 하는 불편함이 있습니다.
    // 이런 문제를 해결하기 위해 MultipartHttpServletRequest는 getFileNames라는 메소드를
    // 제공합니다.
    // 이 메소드를 사용하면, 서버로 한번에 전송되는 한 개 이상의 파일 태그 이름을 iterator형식 으로
    // 가져올 수 있습니다.
    
    @Override
    public void prodUpload(ProductVO productVO, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
       adminMapper.insertProd(productVO);
        
       List<ResourceFileVO> list = fileUtils.parseFileInfo(productVO.getPRODUCT_NUMBER(), multipartHttpServletRequest);
       if(CollectionUtils.isEmpty(list) == false) {
           log.info("list"+list);
           adminMapper.insertFileList(list);
       }else {
           log.info("업로드 실패");
       }
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
    public void upHit(String brdId) {
        adminMapper.updateHit(brdId);
    }
    
    // 공지 사항 등록
    @Override
    public void noticeUpload(BoardVO boardVO, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
       
        adminMapper.insertNotice(boardVO);
        
        List<ResourceFileVO> list = fileUtils.parseFileInfo(boardVO.getBrdId(), multipartHttpServletRequest);
        if(CollectionUtils.isEmpty(list) == false) {
            log.info("list"+list);
            adminMapper.insertFileList02(list);
        }else {
            log.info("업로드 실패");
        }
    }
    
    // 게시판 수정
    @Override
    public void boardModify(BoardVO boardVO) {
        adminMapper.boardUpdate(boardVO);
    }
    
    // 게시판 삭제
    @Override
    public void boardRemove(String brdId) {
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
    public BoardVO getBoard(String brdId) {
        upHit(brdId);
        
        BoardVO boardVO = adminMapper.getBoard(brdId);
        List<ResourceFileVO> fileList = adminMapper.getFileList02(brdId);
        boardVO.setFileList(fileList);
        return boardVO;
    }

    @Override
    public List<ReplyVO> replyList(String brdId) throws Exception {
        return adminMapper.getReply(brdId);
    }

    @Override
    public int replyInsert(ReplyVO replyVO)throws Exception {
        log.info("replyVO: " + replyVO);
        return adminMapper.replyInsert(replyVO);
    }

    @Override
    public int replyUpdate(ReplyVO replyVO)throws Exception {
        return adminMapper.replyUpdate(replyVO);
    }

    @Override
    public int replyDelete(int replyId) throws Exception{
        return adminMapper.replyDelete(replyId);
    }
    
    
    
     // 게층형 답글을 구현하기위한 메서드 
     // 먼저 updateShape를 통해 db의 group값과 해당 글의 group값이 같고 
     // db의 step값이 해당 데이터의 step값보다 크면 db의 있는 데이터의 step값을 1증가하여 리턴해주고 
     // replyUpload는 글작성 메소드와 비슷하나 group의 value값을 현재값 즉 currval로 
     // 넣어주는게아니라 해당 group값을 원본의 글인 댓글이기 때문에 id값으로 해당글의 bgroup값을 넣어주는것이고 
     // 계층형구조를 위해 step과 indent를 + 1씩 해준다.
     // 보류
     /*
      * @Override public void replyUpload(ReplyVO replyVO) {
      * adminMapper.updateShape(replyVO); log.info("replyVO: " + replyVO);
      * adminMapper.replyUpload(replyVO); log.info("replyVO: " + replyVO); }
      */
    
    
   
   
}
