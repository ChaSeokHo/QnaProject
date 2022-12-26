package com.spring.qna.service;

import com.spring.qna.dao.QnaFileDAO;
import com.spring.qna.dto.QnaFileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaFileService {

    @Autowired
    private QnaFileDAO qnaFileDao;

    public int insertFile(QnaFileDTO qnaFileDto) throws Exception {
        return qnaFileDao.insertFile(qnaFileDto);
    }

    public QnaFileDTO selectFile(QnaFileDTO qnaFileDto) throws Exception{
        return qnaFileDao.selectFile(qnaFileDto);
    }
    public int deleteFile(int qnaSeq) throws Exception{
        return qnaFileDao.deleteFile(qnaSeq);
    }
}
