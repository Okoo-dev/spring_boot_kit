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
   private String payResult;
   private Date payDate;
   
    
}
