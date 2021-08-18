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

    private int PRODUCT_NUMBER;
    private String CO_NAME;
    private Date CO_RECIEVINGDATE;
    private int CO_STOCK;
    private String CO_CATEGORY;
    private int CO_PRICE;
    private String CO_SERVINGS;
    private String CO_COOKINGTIME;
    private String CO_PREPARE_TIME;
    private String CO_COMMENT;

    private String prodNumber;
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