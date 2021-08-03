package edu.bit.kit.vo;


import java.util.Date;

import lombok.Data;


//ORDER_NUMBER NOT NULL NUMBER(30)    
//USER_ID      NOT NULL VARCHAR2(100) 
//CO_DATE               DATE          




@Data  //lombok이 제공하는 Data 어노테이션은 getter, setter, noargs, tostring 한 번에 다 만들어준다.
public class OrderVO {
   //private int ordNumber;
   //private String userId;
   //private Date ordDate;
    private int ordNumber;
    private String userId;
    private String userReceiver;
    private String ordAdress1;
    private String ordAdress2;
    private String ordAdress3;
    private String ordPhone;
    private Date ordDate;
    private int ordPrice;
}
