package edu.bit.kit.vo;


import java.util.Date;

import lombok.Data;


//PAYMENT_ID   NOT NULL NUMBER(10)    
//ORDER_NUMBER NOT NULL NUMBER(30)    
//CO_RESULT             VARCHAR2(100) 
//CO_DATE               DATE          




@Data 
public class PayVO {
   private int payId;
   private int ordNumber;
   private String payResult;  // 결제 상태 - 결제 대기중, 결제 완료../
   private Date payDate;
   private String payType;
   
    
}
