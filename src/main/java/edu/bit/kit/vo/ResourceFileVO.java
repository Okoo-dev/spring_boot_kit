package edu.bit.kit.vo;
/*
첨부파일번호(PK)	file_number(PK)	N/A	NUMBER(20)	NOT NULL
상품번호(FK)	product_number(FK)	N/A	NUMBER(30)	NOT NULL
게시글번호(FK)	board_id(FK)	N/A	NUMBER(30)	NULL
파일원본이름	co_name	N/A	VARCHAR2(100 BYTE)	NULL
파일경로	co_path	N/A	VARCHAR2(100 BYTE)	NULL
확장자	co_extension	N/A	VARCHAR2(100 BYTE)	NULL

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
public class ResourceFileVO {

	private int srcFileNumber;
	private int prodNumber;
	private int brdId;
	private String srcFileName;
	private String srcFilePath;
	private String srcFileExtension;

}
