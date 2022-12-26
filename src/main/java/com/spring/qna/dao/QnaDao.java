package com.spring.qna.dao;

import com.spring.qna.dto.QnaDto;
import com.spring.qna.mapper.QnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaDao {
    @Autowired
    private QnaMapper qnaMapper;

    public int insert(QnaDto dto) throws Exception{
        return qnaMapper.insert(dto);
    }
    public List<QnaDto> select() throws Exception{
        return qnaMapper.select();
    }

    public QnaDto selectDetail(QnaDto dto) throws Exception{
        return qnaMapper.selectDetail(dto);
    }
    public int delete(int qnaSeq) throws Exception{
        return qnaMapper.delete(qnaSeq);
    }
}
