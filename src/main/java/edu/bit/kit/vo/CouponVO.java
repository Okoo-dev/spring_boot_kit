package edu.bit.kit.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


//COUPON_ID      NOT NULL NUMBER(30)    
//USER_ID        NOT NULL VARCHAR2(100) 
//CO_NAME                 VARCHAR2(100) 
//CO_EXPIRY_DATE          DATE          
//CO_DATE                 DATE          
//CO_RATE                 NUMBER(5)     
//CO_PRICE                NUMBER(10)    






@Data  //lombok이 제공하는 Data 어노테이션은 getter, setter, noargs, tostring 한 번에 다 만들어준다.

public class CouponVO {
   private int cpnId;
   private String userId;
   private String cpnName;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date cpnExpiryDate;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date cpnDate;
   private int cpnRate;
   private int cpnPrice;
   private int cpn;
}
