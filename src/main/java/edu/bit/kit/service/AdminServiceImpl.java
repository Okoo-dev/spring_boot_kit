package edu.bit.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.kit.mapper.AdminMapper;
import edu.bit.kit.vo.OrderDetailVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.ProductVO;
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
    };
    
    // 상품 등록
    @Override
    public void prodUpload(ProductVO productVO) {
        log.info("getOrder...");
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

   
}
