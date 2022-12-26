package com.spring.qna.mapper;

import com.spring.qna.dto.QnaCommentDto;
import com.spring.qna.dto.QnaDto;
import com.spring.qna.dto.QnaFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {
     int insert(QnaDto dto);

     int insertFile(QnaFileDto Fdto);

     List<QnaDto> select();

     List<QnaCommentDto> selectComment(QnaCommentDto cdto);

     QnaDto selectDetail(QnaDto dto);

     QnaFileDto selectFile(QnaFileDto Fdto);

     int delete(int qnaSeq);

     int deleteFile(int qnaSeq);

     int deleteComment(int qnaSeq,int qnaCommentSeq);
}
