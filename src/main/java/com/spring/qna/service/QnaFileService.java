package com.spring.qna.service;

import com.spring.qna.dao.QnaFileDao;
import com.spring.qna.dto.QnaFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaFileService {

    @Autowired
    private QnaFileDao qnaFileDao;

    public int insertFile(QnaFileDto qnaFileDto) throws Exception {
        return qnaFileDao.insertFile(qnaFileDto);
    }

    public QnaFileDto selectFile(QnaFileDto qnaFileDto) throws Exception{
        return qnaFileDao.selectFile(qnaFileDto);
    }
    public int deleteFile(int qnaSeq) throws Exception{
        return qnaFileDao.deleteFile(qnaSeq);
    }
}
