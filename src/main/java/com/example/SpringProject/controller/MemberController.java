package com.example.SpringProject.controller;

import com.example.SpringProject.dto.MemberForm;
import com.example.SpringProject.entity.Member;
import com.example.SpringProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUP(){
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form){
        Member member = form.toEntity();
        Member saved = memberRepository.save(member);
        return "redirect:/members/" + saved.getId();
    }
}
