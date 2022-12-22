package com.spring.qna.controllers;

import com.spring.qna.dto.QnaDTO;
import com.spring.qna.dto.QnaFileDTO;
import com.spring.qna.service.QnaFileService;
import com.spring.qna.service.QnaService;
import com.spring.qna.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Value("${qna.upload.path}")
    String qnaPath;

    @Transactional
    @RequestMapping("insert")
    public String insert(@RequestParam MultipartFile[] uploadfile , Model model , QnaDTO dto, QnaFileDTO Fdto, FileUtil util,String sysName) throws Exception {
        service.insert(dto);
        List<QnaFileDTO> list = new ArrayList<>();
        for (MultipartFile file : uploadfile) {
            if (!file.isEmpty()) {
                sysName = UUID.randomUUID().toString() + file.getOriginalFilename();
                Fdto = new QnaFileDTO(
                        0,
                        file.getOriginalFilename(),
                        sysName,
                        dto.getQnaSeq());
                list.add(Fdto);

                util.save(uploadfile,qnaPath,sysName);
            }
        }
        System.out.println(Fdto.getQnaSysName());
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

    @RequestMapping("delete")
    public String delete(int qnaSeq, FileUtil util,String qnaSysName) throws Exception{
        System.out.println(qnaSysName);
        service.delete(qnaSeq);
        Fservice.deleteFile(qnaSeq);

        util.delete(qnaPath,qnaSysName);
        return "index";
    }
}
