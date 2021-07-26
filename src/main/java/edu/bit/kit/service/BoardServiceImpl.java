package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.BoardMapper;
import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.CouponVO;
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
    public UserVO getUser() {
        
        log.info("getUser()..");
        return  boardmapper.getUser();
    }

    @Override
    public PointVO getPoint() {
        
        log.info("getPoint()..");
        return  boardmapper.getPoint();
    }

    @Override
    public int getCouponCount() {

        log.info("getCoupon()..");
        return  boardmapper.getCouponCount();
    }


}
