package edu.bit.kit.service;

import java.util.List;

import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.UserVO;



public interface BoardService {

    public List<BoardVO> getEventList();

    public UserVO getUser();

    public PointVO getPoint();

    public int getCouponCount();


}
