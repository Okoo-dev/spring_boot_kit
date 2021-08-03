package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.ReviewMapper;
import edu.bit.kit.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public List<ReviewVO> getList() {
	    System.out.println("Servie:getList() ..");
		return reviewMapper.getList();
	}

	@Override
	public ReviewVO get(int brdId) {
	    System.out.println("service:get()..");
		return reviewMapper.read(brdId);
	}

	@Override
	public int remove(int brdId) {
	    System.out.println("service:remove()..");

		return reviewMapper.delete(brdId);
	}

    @Override
    public void update(int brdId) {
        System.out.println("sevice:update()..");
        
    }

}
