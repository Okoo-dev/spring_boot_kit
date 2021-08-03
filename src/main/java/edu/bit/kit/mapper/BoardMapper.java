package edu.bit.kit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.UserVO;

@Mapper
public interface BoardMapper {

   public List<BoardVO> getEventList();


   public UserVO getUser();


public PointVO getPoint();


public int getCouponCount();

}
