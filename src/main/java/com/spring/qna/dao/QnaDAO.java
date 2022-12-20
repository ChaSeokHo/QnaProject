package com.spring.qna.dao;

import com.spring.qna.dto.QnaDTO;
import com.spring.qna.dto.QnaFileDTO;
import com.spring.qna.mapper.QnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaDAO {
    @Autowired
    private QnaMapper qnaMapper;

    public int insert(QnaDTO dto) throws Exception{
        return qnaMapper.insert(dto);
    }
    public List<QnaDTO> select() throws Exception{
        return qnaMapper.select();
    }

    public QnaDTO selectDetail(QnaDTO dto) throws Exception{
        return qnaMapper.selectDetail(dto);
    }
    public int delete(int qnaSeq) throws Exception{
        return qnaMapper.delete(qnaSeq);
    }
}
