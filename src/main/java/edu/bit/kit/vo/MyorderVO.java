package edu.bit.kit.vo;


import java.util.Date;

import lombok.Data;


// 중복된 정보 너무 많음.
// 결제 정보 가져와야 하는데, 여기서 따로 만들기 보다 추후 취합된 코드 가져온 후에 설정하기로.



@Data  
public class MyorderVO {
   private int ordNumber;
   private String userId;
   private Date ordDate;
   private int prodNumber;
   private String prodName;
   
    
}
