package com.spring.qna.dao;

import com.spring.qna.dto.QnaCommentDto;
import com.spring.qna.mapper.QnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaCommentDao {

    @Autowired
    private QnaMapper qnaMapper;

    public List<QnaCommentDto> selectComment(QnaCommentDto Cdto) throws Exception{
        return qnaMapper.selectComment(Cdto);
    }

    public int deleteComment(int qnaSeq,int qnaCommentSeq) throws Exception{
        return qnaMapper.deleteComment(qnaSeq,qnaCommentSeq);
    }
}
