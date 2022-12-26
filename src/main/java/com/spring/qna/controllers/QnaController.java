package com.spring.qna.controllers;

import com.spring.qna.dto.QnaCommentDTO;
import com.spring.qna.dto.QnaDTO;
import com.spring.qna.dto.QnaFileDTO;
import com.spring.qna.service.QnaCommentService;
import com.spring.qna.service.QnaFileService;
import com.spring.qna.service.QnaService;
import com.spring.qna.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/qna/")
public class QnaController {

    @Autowired
    private QnaService qnaService;

    @Autowired
    private QnaFileService qnaFileService;

    @Autowired
    private QnaCommentService qnaCommentService;
    @RequestMapping("write")
    public String write() {
        return "qnaWrite";
    }

    @Value("${qna.save.path}")
    String qnaPath;

    @Transactional
    @RequestMapping("insert")
    public String insert(@RequestParam MultipartFile[] uploadfile , Model model , QnaDTO qnaDto, QnaFileDTO qnaFileDto, FileUtil util) throws Exception {
        qnaService.insert(qnaDto);
        List<QnaFileDTO> list = new ArrayList<>();
        for (MultipartFile file : uploadfile) {
            if (!file.isEmpty()) {
                String sysName = UUID.randomUUID().toString() + file.getOriginalFilename();
                qnaFileDto = new QnaFileDTO(
                        0,
                        file.getOriginalFilename(),
                        sysName,
                        qnaDto.getQnaSeq());
                list.add(qnaFileDto);
                util.saves(uploadfile,qnaPath,sysName);
            }
        }
        model.addAttribute("files", list);
        qnaFileService.insertFile(qnaFileDto);
        return "redirect:/";
    }

    @RequestMapping("detail")
    public String selectDetail(QnaDTO qnaDto, Model model , QnaFileDTO qnaFileDto, QnaCommentDTO qnaCommentDto) throws Exception {
        QnaDTO qnaDto1 = qnaService.selectDetail(qnaDto);
        QnaFileDTO qnaFileDto1 = qnaFileService.selectFile(qnaFileDto);
        List<QnaCommentDTO> qnaCommentDto1 = qnaCommentService.selectComment(qnaCommentDto);
        model.addAttribute("detail",qnaDto1);
        model.addAttribute("file",qnaFileDto1);
        model.addAttribute("comment",qnaCommentDto1);
        return "detail";
    }

    @RequestMapping("delete")
    public String delete(int qnaSeq, FileUtil util,String qnaSysName) throws Exception{
        qnaService.delete(qnaSeq);
        qnaFileService.deleteFile(qnaSeq);
        util.delete(qnaPath,qnaSysName);
        return "redirect:/";
    }

    @RequestMapping("deleteComment")
    public String delete(int qnaSeq,int qnaCommentSeq) throws Exception{
        qnaCommentService.deleteComment(qnaSeq,qnaCommentSeq);
        return "redirect:/";
    }

    @RequestMapping("download")
    public ResponseEntity<Resource> download(FileUtil util, String sysName, String oriName) throws Exception {
        return util.download(qnaPath,sysName,oriName);
    }
}
