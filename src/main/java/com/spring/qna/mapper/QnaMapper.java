package com.spring.qna.mapper;

import com.spring.qna.dto.QnaCommentDTO;
import com.spring.qna.dto.QnaDTO;
import com.spring.qna.dto.QnaFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {
     int insert(QnaDTO qnaDto);

     int insertFile(QnaFileDTO qnaFileDto);

     List<QnaDTO> select();

     List<QnaCommentDTO> selectComment(QnaCommentDTO qnaCommentDto);

     QnaDTO selectDetail(QnaDTO qnaDto);

     QnaFileDTO selectFile(QnaFileDTO qnaFileDto);

     int delete(int qnaSeq);

     int deleteFile(int qnaSeq);

     int deleteComment(int qnaSeq,int qnaCommentSeq);
}
