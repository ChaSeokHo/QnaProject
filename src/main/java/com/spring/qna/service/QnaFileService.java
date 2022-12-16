package com.spring.qna.service;

import com.spring.qna.dao.QnaFileDAO;
import com.spring.qna.dto.QnaFileDTO;
import com.spring.qna.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaFileService {

    @Autowired
    private QnaFileDAO Fdao;

    public int insertFile(QnaFileDTO Fdto) throws Exception {
        return Fdao.insertFile(Fdto);
    }

    public QnaFileDTO selectFile(QnaFileDTO Fdto) throws Exception{
        FileUtil util = new FileUtil();
        return Fdao.selectFile(Fdto);
    }
}
