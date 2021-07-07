package edu.bit.kit.vo;
/*
게시글번호(PK)(FK)	board_id(PK)(FK)	N/A	NUMBER(30)	NOT NULL
주문번호(PK)(FK)	order_number(PK)(FK)	N/A	NUMBER(30)	NOT NULL
상품번호(PK)(FK)	product_number(PK)(FK)	N/A	NUMBER(30)	NOT NULL

*/
import java.sql.Timestamp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {

	private int brdId;
	private int prodNumber;
	private int ordNumber;

}
