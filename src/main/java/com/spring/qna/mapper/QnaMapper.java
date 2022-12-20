package com.spring.qna.mapper;

import com.spring.qna.dto.QnaDTO;
import com.spring.qna.dto.QnaFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {
     int insert(QnaDTO dto);

     int insertFile(QnaFileDTO Fdto);

     List<QnaDTO> select();

     QnaDTO selectDetail(QnaDTO dto);

     QnaFileDTO selectFile(QnaFileDTO Fdto);

     int delete(int qnaSeq);

     int deleteFile(int qnaSeq);
}
