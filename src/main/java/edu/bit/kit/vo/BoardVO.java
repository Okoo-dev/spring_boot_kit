package edu.bit.kit.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class BoardVO {

	private int brdId;
	private int brdNumber;
	private String brdName;
	private String brdContent;
	private Date brdDate;
	private int brdHit;
	private String brdTitle;
	private String brdUserid;
}
