package edu.bit.kit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import edu.bit.kit.vo.ReviewVO;

@Mapper
public interface ReviewMapper {
	List<ReviewVO> getList();
	ReviewVO read(int brdId);
    int delete(int brdId);
}
