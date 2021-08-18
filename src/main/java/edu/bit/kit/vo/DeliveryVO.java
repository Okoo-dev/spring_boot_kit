package edu.bit.kit.vo;


import java.util.ArrayList;
import java.util.Date;

import lombok.Data;


//DELIVERY_ID        NOT NULL NUMBER(10)    
//ORDER_NUMBER       NOT NULL NUMBER(30)    
//CO_NAME                     VARCHAR2(100) 
//CO_DATE                     DATE          
//CO_DELIVERY_NUMBER          VARCHAR2(100) 
//CO_STATE                    VARCHAR2(100) 
   
       




@Data 
public class DeliveryVO {
   private int delvId;
   private int ordNumber;
   private String delvName;
   private Date delvDate;
   private String delvNumber;
   private String delvState;
      
    
}
