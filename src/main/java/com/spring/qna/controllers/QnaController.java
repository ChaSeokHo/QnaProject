package com.spring.qna.controllers;

import com.spring.qna.dto.QnaDTO;
import com.spring.qna.dto.QnaFileDTO;
import com.spring.qna.service.QnaFileService;
import com.spring.qna.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/qna/")
public class QnaController {

    @Autowired
    private QnaService service;

    @Autowired
    private QnaFileService Fservice;

    @RequestMapping("write")
    public String write() {
        return "qnaWrite";
    }
    @Transactional
    @RequestMapping("insert")
    public String insert(@RequestParam MultipartFile[] uploadfile , Model model , QnaDTO dto, QnaFileDTO Fdto) throws Exception {

        service.insert(dto);

    List<QnaFileDTO> list = new ArrayList<>();
    for (MultipartFile file : uploadfile) {
        if (!file.isEmpty()) {
            Fdto = new QnaFileDTO(
                    0,
                    file.getOriginalFilename(),
                    file.getName(),
                    dto.getQnaSeq(),
                    file.getContentType()
            );
            list.add(Fdto);

            File newFileName = new File(Fdto.getQnaOriName());
            file.transferTo(newFileName);
        }
    }
        model.addAttribute("files", list);
        Fservice.insertFile(Fdto);
        return "redirect:/";
    }

    @RequestMapping("detail")
    public String selectDetail(QnaDTO dto, Model model , QnaFileDTO fdto) throws Exception {
        QnaDTO qdto = service.selectDetail(dto);
        QnaFileDTO dto1 = Fservice.selectFile(fdto);
        model.addAttribute("file",dto1);
        model.addAttribute("detail",qdto);
        return "detail";
    }
}
