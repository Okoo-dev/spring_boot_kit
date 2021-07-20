package edu.bit.kit.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private int brdId;
	private int brdNumber;
	private String brdContent;
	private Date brdDate;
	private int brdHit;
	private String brdTitle;
	private String brdUserid;
}
