package com.example.SpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러임을 선언하는 어노테이션
public class FirstController {

    @GetMapping("/hi") // URL 연결 요청 어노테이션, 주소
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "변수값"); // 모델에 변수 등록
        return "greetings"; // greetings.mustache 파일 반환
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "변수값");
        return "goodbye";
    }
}
