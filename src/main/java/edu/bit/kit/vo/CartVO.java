package edu.bit.kit.vo;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CartVO {

	private int cartId;
	private int cartNumber;
	private int cartAmount;
	private int cartProductNumber;
	private String cartUserid;
	
	private ArrayList<ProductVO> productList;

}
