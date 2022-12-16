package com.spring.qna.service;

import com.spring.qna.dao.QnaDAO;
import com.spring.qna.dao.QnaFileDAO;
import com.spring.qna.dto.QnaDTO;
import com.spring.qna.dto.QnaFileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaService {
    @Autowired
    private QnaDAO dao;


    public int insert(QnaDTO dto) throws Exception {
        return dao.insert(dto);
    }
    public List<QnaDTO> select() throws  Exception{
        return dao.select();
    }

    public QnaDTO selectDetail(QnaDTO dto) throws  Exception{
        return dao.selectDetail(dto);
    }
}
