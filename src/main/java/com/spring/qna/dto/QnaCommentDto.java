package com.spring.qna.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnaCommentDto {
    private int qnaCommentSeq;
    private int qnaCommentWriter;
    private String qnaCommentContents;
    private Timestamp qnaCommentWriteDate;
    private int qnaSeq;
}
