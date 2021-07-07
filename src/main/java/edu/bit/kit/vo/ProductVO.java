package edu.bit.kit.vo;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductVO {
    private int prodNumber;
    private String prodName;
    private Date prodRecievingDate;
    private int prodStock;
    private String prodCategory;
    private int prodPrice;
    private String prodServings;
    private String prodCookingTime;
    private String prodPrepareTime;
    private String prodComment;
    
}