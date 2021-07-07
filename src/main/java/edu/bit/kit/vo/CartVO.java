package edu.bit.kit.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class CartVO {

	private int cartId;
	private int cartNumber;
	private int cartAmount;
	private int cartProductNumber;
	private String cartUserid;

}
