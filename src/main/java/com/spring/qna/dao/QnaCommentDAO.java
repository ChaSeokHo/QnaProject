package com.spring.qna.dao;

import com.spring.qna.dto.QnaCommentDTO;
import com.spring.qna.mapper.QnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaCommentDAO {

    @Autowired
    private QnaMapper qnaMapper;

    public List<QnaCommentDTO> selectComment(QnaCommentDTO qnaCommentDto) throws Exception{
        return qnaMapper.selectComment(qnaCommentDto);
    }

    public int deleteComment(int qnaSeq,int qnaCommentSeq) throws Exception{
        return qnaMapper.deleteComment(qnaSeq,qnaCommentSeq);
    }
}
