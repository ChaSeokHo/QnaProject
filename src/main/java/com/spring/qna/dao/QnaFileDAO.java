package com.spring.qna.dao;

import com.spring.qna.dto.QnaFileDTO;
import com.spring.qna.mapper.QnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaFileDAO {
    @Autowired
    private QnaMapper qnaMapper;

    public int insertFile(QnaFileDTO Fdto) throws Exception {
        return qnaMapper.insertFile(Fdto);
    }

    public QnaFileDTO selectFile(QnaFileDTO Fdto) throws Exception{
        return qnaMapper.selectFile(Fdto);
    }

    public int deleteFile(int qnaSeq) throws Exception{
        return qnaMapper.deleteFile(qnaSeq);
    }
}
