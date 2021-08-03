package edu.bit.kit.service;

import java.util.List;

import edu.bit.kit.vo.ReviewVO;

public interface ReviewService {
	List<ReviewVO> getList();
	ReviewVO get(int bid);
	int remove(int bid);
    void update(int bid);
}
