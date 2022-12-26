package com.spring.qna.service;

import com.spring.qna.dao.QnaCommentDAO;
import com.spring.qna.dto.QnaCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaCommentService {

    @Autowired
    private QnaCommentDAO qnaCommentDAO;
    public List<QnaCommentDTO> selectComment(QnaCommentDTO qnaCommentDto) throws  Exception{
        return qnaCommentDAO.selectComment(qnaCommentDto);
    }

    public int deleteComment(int qnaSeq,int qnaCommentSeq) throws Exception{
        return qnaCommentDAO.deleteComment(qnaSeq,qnaCommentSeq);
    }
}
