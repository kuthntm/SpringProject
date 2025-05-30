package com.example.SpringProject.service;

import com.example.SpringProject.dto.MemberForm;
import com.example.SpringProject.entity.Article;
import com.example.SpringProject.entity.Member;
import com.example.SpringProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Member join(MemberForm form){
        if (!form.isPasswordMatch()) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        Member member = form.toEntity();
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        return memberRepository.save(member);
    }

    public Member show(Long id){
        return memberRepository.findById(id).orElse(null);
    }
    public List<Member> index(){
        return (List<Member>) memberRepository.findAll();
    }

    public boolean delete(Long id){
        Member target = memberRepository.findById(id).orElse(null);
        if (target != null){
            memberRepository.delete(target);
            return true;
        }
        else
            return false;
    }

    public Member edit(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member update(MemberForm dto){
       Member member = dto.toEntity();
       Member target = memberRepository.findById(member.getId()).orElse(null);
        if (target == null) {
            throw new IllegalArgumentException("회원 ID가 없습니다.");
        }
        target.patch(member);
        return memberRepository.save(target);
    }
}
