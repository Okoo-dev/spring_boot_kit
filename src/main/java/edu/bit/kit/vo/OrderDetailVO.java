package edu.bit.kit.vo;

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
public class OrderDetailVO {
    //private int ordNumber;
    //private int prodNumber;
    //private int ordAmount;
    //private String ordRecipient;
    //private String ordLocation;
	private int ordDetailNumber;
	private int ordNumber;
	private int cartAmount;
	private int cartProductNumber;
	
}
