package com.spring.qna.service;

import com.spring.qna.dao.QnaCommentDao;
import com.spring.qna.dto.QnaCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaCommentService {

    @Autowired
    private QnaCommentDao qnaCommentDAO;
    public List<QnaCommentDto> selectComment(QnaCommentDto qnaCommentDto) throws  Exception{
        return qnaCommentDAO.selectComment(qnaCommentDto);
    }

    public int deleteComment(int qnaSeq,int qnaCommentSeq) throws Exception{
        return qnaCommentDAO.deleteComment(qnaSeq,qnaCommentSeq);
    }
}
