package edu.bit.kit.vo;


import java.util.Date;

import lombok.Data;


//ORDER_NUMBER NOT NULL NUMBER(30)    
//USER_ID      NOT NULL VARCHAR2(100) 
//CO_DATE               DATE          




@Data  //lombok이 제공하는 Data 어노테이션은 getter, setter, noargs, tostring 한 번에 다 만들어준다.
public class OrderVO {
	/*
	 * private int ordNumber; private String userId; private Date ordDate;
	 */
    private int ordNumber;
   private String userId;
    private String receiverName;
    private String receiverTel;
   private String receiverZipcode;
   private String receiverAddress1;
   private String receiverAddress2;
  private int sumMoney;
  private int couponDiscount;
  private int pointDiscount;
  private int totalPay;
   private Date ordDate;
   private String payChoice;
}
