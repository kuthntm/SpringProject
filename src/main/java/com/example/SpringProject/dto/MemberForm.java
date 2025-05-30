package com.example.SpringProject.dto;


import com.example.SpringProject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MemberForm {
    private Long id;
    private String email;
    private String password;

    public Member toEntity() {return new Member(id, email, password);
    }
}
