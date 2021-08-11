package edu.bit.kit.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
    
	private String brdId;
	private int brdNumber;
	private String brdName;
	private String brdContent;
	private Date brdDate;
	private int brdHit;
	private String brdTitle;
	private String brdUserid;
	private List<ResourceFileVO> fileList;
}
