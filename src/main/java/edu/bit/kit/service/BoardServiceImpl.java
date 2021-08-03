package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.BoardMapper;
import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.DeliveryVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardmapper;
    
    @Override
    public List<BoardVO> getEventList() {
        log.info("getEventList()..");
        return boardmapper.getEventList();
    }

    @Override
    public UserVO getUser(String userId) {
        
        log.info("getUser()..");
        return  boardmapper.getUser(userId);
    }

    @Override
    public PointVO getPoint(String userId) {
        
        log.info("getPoint()..");
        return  boardmapper.getPoint(userId);
    }

    @Override
    public int getCouponCount(String userId) {

        log.info("getCoupon()..");
        return  boardmapper.getCouponCount(userId);
    }


    @Override
    public List<DeliveryVO> getDeliveryList(String userId) {
        
        log.info("getDelivery()..");
        return  boardmapper.getDeliveryList(userId);
    }

    @Override
    public void updateAccount(String userId, String userAccount) {
        log.info("updateAccount()..");
        
        boardmapper.updateAccount(userId, userAccount);
        
    }

    @Override
    public List<CouponVO> getCoupon(String userId) {
        log.info("getCoupon()..");
        
        return boardmapper.getCoupon(userId);
    }

    @Override
    public int getExpCouponCount(String userId) {
        log.info("getExpCouponCount()..");
        
        return boardmapper.getExpCouponCount(userId);
    }
    
}
