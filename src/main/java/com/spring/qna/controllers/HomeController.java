package com.spring.qna.controllers;

import com.spring.qna.dto.QnaDTO;
import com.spring.qna.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private QnaService qnaService;
    @RequestMapping("/")
        public String select(Model model) throws Exception {
        List<QnaDTO> qnaDto = qnaService.select();
        model.addAttribute("qna", qnaDto);
        return "index";
    }
}
