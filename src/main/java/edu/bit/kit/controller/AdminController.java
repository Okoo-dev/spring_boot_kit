package edu.bit.kit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.kit.service.AdminService;
import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.OrderDetailVO;
import edu.bit.kit.vo.ProductVO;
import edu.bit.kit.vo.ReplyVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    // admin 페이지 호출 메서드
	/* @PreAuthorize("hasRole('ROLE_ADMIN')") */
    @GetMapping("/admin/index")
    public String adminMain() {

        log.info("adminMain..");

        return "admin/admin_main";
    }

    // 회원 관리 페이지 호출 메서드
    @GetMapping("/admin/userlist")
    public String userList(Model model) {

        log.info("userList..", model);
        model.addAttribute("userList", adminService.getUserList());

        return "admin/user_list";
    }

    // 회원 상세 뷰 호출 메서드
    @GetMapping("/admin/userview")
    public String userView(UserVO userVO, Model model) {
        log.info("user_view..");
        log.info("userVO" + userVO);
        model.addAttribute("user_view", adminService.getUser(userVO.getUserId()));

        return "admin/user_view";
    }

    // 회원 정보 수정 메서드
    @PostMapping("/admin/modify")
    public String modify(UserVO userVO) {
        log.info("modify()..");
        log.info("userVO" + userVO);
        adminService.modify(userVO);

        return "redirect:userlist";
    }

    // 회원 정보 삭제 메서드
    @GetMapping("/admin/delete")
    public String delete(UserVO userVO) {
        log.info("delete()..");
        log.info("userVO" + userVO);

        adminService.remove(userVO.getUserId());

        return "redirect:userlist";
    }

    // 주문 리스트 메서드
    @GetMapping("/admin/orderlist")
    public String orderList(Model model) {

        log.info("orderview..");
        model.addAttribute("orderview", adminService.getOrderList());

        return "admin/order_list";
    }

    // 주문 상세 메서드
    @GetMapping("/admin/orderview")
    public String orderView(OrderDetailVO orderDetailVO, Model model) {
        log.info("orderDtailView..");
        log.info("orderDetailVO" + orderDetailVO);
        model.addAttribute("orderDetailView", adminService.getOrder(orderDetailVO.getOrdNumber()));

        return "admin/order_view";
    }

    // 상품 목록 화면 메서드
    @GetMapping("/admin/prodList")
    public String prodList(Model model) {
        log.info("prod_list");
        model.addAttribute("prod_list", adminService.getProdList());
        return "admin/prod_list";
    }

    // 상품 상세 수정 삭제 뷰
    @GetMapping("/admin/prodView")
    public String prodView(ProductVO productVO, Model model) {
        log.info("prod_view..");
        log.info("productVO" + productVO);
        model.addAttribute("prod_view", adminService.getProd(productVO.getProdNumber()));
        return "admin/prod_view";
    }

    // 상품 등록 화면 메서드
    @GetMapping("/admin/prodAdd")
    public String prodAdd() {
        return "admin/prod_add";
    }

    // 상품 등록 메서드
    @PostMapping("/admin/prodUpload")
    public String prodUpload(ProductVO productVO, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        log.info("prodUpload()..");
        adminService.prodUpload(productVO, multipartHttpServletRequest);

        return "redirect:prodList";
    }

    // 상품 정보 수정 메서드

    @PostMapping("/admin/prodModify")
    public String prodModify(ProductVO productVO) {
        log.info("prodmodify()..");
        log.info("productVO" + productVO);

        adminService.prodModify(productVO);

        return "redirect:prodList";
    }

    // 상품 정보 삭제 메서드

    @GetMapping("/admin/prodDelete")
    public String prodDelete(ProductVO productVO) {
        log.info("proddelete()..");
        log.info("productVO" + productVO);

        adminService.prodRemove(productVO.getProdNumber());

        return "redirect:prodList";
    }

    // 상품 선택 삭제 메서드
    // 선택 삭제를 위해서 prodNumber를 int -> String 으로 바꿨음
    @PostMapping("/admin/prodDelete")
    public String ajaxDelete(HttpServletRequest request) {

        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for (int i = 0; i < size; i++) {
            adminService.prodRemove(ajaxMsg[i]);
        }

        return "redirect:prodList";
    }

    // 공지사항 게시판
    @GetMapping("/admin/noticeList")
    public String noticeList(Model model) {

        log.info("noticeList..");
        model.addAttribute("noticeList", adminService.getNoticeList());

        return "admin/notice_list";
    }

    // 공지 사항 등록 화면
    @GetMapping("/admin/noticeAdd")
    public String noticeAdd() {
        return "admin/notice_add";
    }

    // 공지사항 등록
    @PostMapping("/admin/noticeUpload")
    public String noticeUpload(BoardVO boardVO, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        log.info("noticeUpload()..");
        adminService.noticeUpload(boardVO, multipartHttpServletRequest);

        return "redirect:noticeList";
    }

    // 공지사항 뷰
    @GetMapping("/admin/notice")
    public String notice(BoardVO boardVO, Model model) {
        log.info("notice..");
        log.info("boardVO" + boardVO);
        model.addAttribute("notice", adminService.getBoard(boardVO.getBrdId()));

        return "admin/notice";
    }

    // 공지사항 수정 삭제 뷰
    @GetMapping("/admin/noticeView")
    public String noticeView(BoardVO boardVO, Model model) {
        log.info("notice_view..");
        log.info("boardVO" + boardVO);
        model.addAttribute("notice_view", adminService.getBoard(boardVO.getBrdId()));

        return "admin/notice_view";
    }

    // 공지사항 수정 메서드
    @PostMapping("/admin/noticeModify")
    public String noticeModify(BoardVO boardVO) {
        log.info("noticeModify()..");
        log.info("boardVO" + boardVO);

        adminService.boardModify(boardVO);

        return "redirect:noticeList";
    }

    // 공지사항 삭제 메서드
    @GetMapping("/admin/noticeDelete")
    public String noticeDelete(BoardVO boardVO) {
        log.info("noticeDelete()..");
        log.info("boardVO" + boardVO);

        adminService.boardRemove(boardVO.getBrdId());

        return "redirect:noticeList";
    }

    // 공지사항 선택삭제
    @PostMapping("/admin/boardDelete")
    public String ajaxBoardDelete(HttpServletRequest request) {

        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for (int i = 0; i < size; i++) {
            adminService.boardRemove(ajaxMsg[i]);
        }

        return "redirect:noticeList";
    }

    // 1:1 문의 게시판
    @GetMapping("/admin/questionList")
    public String questionList(Model model) {

        log.info("questionList..");
        model.addAttribute("questionList", adminService.getQuestionList());

        return "admin/question_list";
    }

    // 1:1 문의 확인 메서드
    @GetMapping("/admin/questionView")
    public String questionView(BoardVO boardVO, Model model) {
        log.info("question_view..");
        log.info("boardVO" + boardVO);
        model.addAttribute("question_view", adminService.getBoard(boardVO.getBrdId()));

        return "admin/question_view";
    }

    // 1:1 삭제 메서드
    @GetMapping("/admin/questionDelete")
    public String questionDelete(BoardVO boardVO) {
        log.info("questionDelete()..");
        log.info("boardVO" + boardVO);

        adminService.boardRemove(boardVO.getBrdId());

        return "redirect:questionList";
    }

    // 1:1 선택삭제
    @PostMapping("/admin/questionDelete")
    public String ajaxQuestionDelete(HttpServletRequest request) {

        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for (int i = 0; i < size; i++) {
            adminService.boardRemove(ajaxMsg[i]);
        }

        return "redirect:questionList";
    }

    // 1:1 문의 답글 등록 화면
    // 우선 보류
    /*
     * @GetMapping("/admin/questionReply") public String questionReply() { return
     * "admin/question_reply"; }
     * 
     * // 1:1 문의 답글 등록
     * 
     * @PostMapping("/admin/replyUpload") public String replyUpload(ReplyVO replyVO)
     * { log.info("replyUpload().."); adminService.replyUpload(replyVO);
     * 
     * return "redirect:quetionList"; }
     */

    @RequestMapping("/admin/replyList") // 댓글 리스트
    @ResponseBody
    private List<ReplyVO> replyList(Model model, String brdId) throws Exception {

        return adminService.replyList(brdId);
    }

    @RequestMapping("/admin/replyInsert") // 댓글 작성
    @ResponseBody
    private int replyInsert(ReplyVO replyVO) throws Exception {

        log.info("replyVO" + replyVO);

        return adminService.replyInsert(replyVO);
    }

    @RequestMapping("/admin/replyUpdate") // 댓글 수정
    @ResponseBody
    private int replyUpdate(ReplyVO replyVO) throws Exception {
        log.info("replyVO" + replyVO);
        return adminService.replyUpdate(replyVO);
    }
    

    @RequestMapping("/admin/replyDelete/{replyId}") // 댓글 삭제
    @ResponseBody
    private int replyDelete(@PathVariable int replyId) throws Exception {

        return adminService.replyDelete(replyId);
    }

    // 이벤트 게시판
    @GetMapping("/admin/eventList")
    public String eventList(Model model) {

        log.info("eventList..");
        model.addAttribute("eventList", adminService.getEventList());

        return "admin/event_list";
    }

    // 이벤트 등록
    @PostMapping("/admin/eventUpload")
    public String eventUpload(BoardVO boardVO) {
        log.info("eventUpload()");
        adminService.eventUpload(boardVO);
        return "redirect:eventList";
    }

    // 리뷰 게시판
    @GetMapping("/admin/reviewList")
    public String reviewList(Model model) {

        log.info("reviewList..");
        model.addAttribute("reviewList", adminService.getReviewList());

        return "admin/review_list";
    }

}
