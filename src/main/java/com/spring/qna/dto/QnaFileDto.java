package com.spring.qna.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QnaFileDto {
    private int qnaFilesSeq;
    private String qnaOriName;
    private String qnaSysName;
    private int qnaSeq;

}
