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
public class ReplyVO {
    private int replyId;
    private String userId;
    private String boardId;
    private String replyContent;
    private Date replyDate;
    private int replyGroup;
    private int replyStep;
    private int replyIndent;
    
}