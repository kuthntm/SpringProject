package com.example.SpringProject.controller;

import com.example.SpringProject.dto.ArticleForm;
import com.example.SpringProject.dto.MemberForm;
import com.example.SpringProject.entity.Article;
import com.example.SpringProject.entity.Member;
import com.example.SpringProject.repository.MemberRepository;
import com.example.SpringProject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/signup")
    public String signUP(){
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form, RedirectAttributes rttr){
        try {
            memberService.join(form);
            return "redirect:/members";
        } catch (IllegalArgumentException e) {
            rttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
            return "redirect:/signup";
        } catch (DataIntegrityViolationException e) {
            rttr.addFlashAttribute("msg", "이미 등록된 회원입니다.");
            return "redirect:/signup";
        }
        /*
        Member saved = memberService.join(form);
        return "redirect:/members/" + saved.getId();
        */
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member memberEntity = memberService.show(id);
        model.addAttribute("member", memberEntity);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        List<Member> memberEntityList = memberService.index();
        model.addAttribute("memberList", memberEntityList);
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Member memberEntity = memberService.edit(id);
        model.addAttribute("member", memberEntity);
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form){
        Member target = memberService.update(form);
        return "redirect:/members/" + target.getId();
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        boolean success = memberService.delete(id);
        if (success){
            rttr.addFlashAttribute("msg", "삭제되었습니다.");
        }
        else{
            rttr.addFlashAttribute("msg", "대상이 존재하지 않습니다.");
        }
        return "redirect:/members";
    }
}
