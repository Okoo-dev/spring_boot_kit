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
public class OrderDetailVO {
    private int ordNumber;
    private int prodNumber;
    private String prodName;
    private Date ordDate;
    private int ordAmount;
    private String ordRecipient;
    private String ordLocation;
    private String sumPrice;
}
