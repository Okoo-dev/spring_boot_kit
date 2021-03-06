package edu.bit.kit.service;

import java.util.List;

import edu.bit.kit.security.UserPrincipalVO;
import edu.bit.kit.vo.BoardVO;
import edu.bit.kit.vo.CouponVO;
import edu.bit.kit.vo.DeliveryVO;
import edu.bit.kit.vo.OrderVO;
import edu.bit.kit.vo.PointVO;
import edu.bit.kit.vo.UserVO;



public interface BoardService {

    public List<BoardVO> getEventList();

    public UserVO getUser(String userId);

    public PointVO getPoint(String userId);

    public List<OrderVO> getOrderList(String userId);
    
    public List<CouponVO> getCoupon(String userId);
    
    public int getCouponCount(String userId);
    
    public int getExpCouponCount(String userId);

    public int getCartCount(String userId);

    public List<DeliveryVO> getDeliveryList(String userId);
    
    public void updateAccount(String userId, String userAccount);

    public void signUpInsert(UserVO userVO);
    
    public String idChk(UserVO userVO) throws Exception;
    
    public int passChk(UserVO userVO) throws Exception;
    
    public void signUpAuth(UserVO userVO);
    
    public void signUpPoint(UserVO userVO);
    
    public void updateUser(UserVO userVO);
    
    public void deleteUser(UserVO userVO);
    
}

