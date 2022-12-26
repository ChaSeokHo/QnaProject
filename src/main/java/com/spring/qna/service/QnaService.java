package com.spring.qna.service;

import com.spring.qna.dao.QnaDao;
import com.spring.qna.dto.QnaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaService {
    @Autowired
    private QnaDao qnaDao;

    public int insert(QnaDto qnaDto) throws Exception {
        return qnaDao.insert(qnaDto);
    }
    public List<QnaDto> select() throws  Exception{
        return qnaDao.select();
    }

    public QnaDto selectDetail(QnaDto qnaDto) throws  Exception{
        return qnaDao.selectDetail(qnaDto);
    }
    public int delete(int qnaSeq) throws Exception {
        return qnaDao.delete(qnaSeq);
    }
}
