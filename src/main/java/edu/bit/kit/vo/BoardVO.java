package edu.bit.kit.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class BoardVO {

	private int brdId;
	private int brdNumber;
	private String brdContent;
	private Date brdDate;
	private int brdHit;
	private String brdTitle;
	private String brdUserid;
}
