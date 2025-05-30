package com.example.SpringProject.dto;


import com.example.SpringProject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MemberForm {
    private Long id;
    private String email;
    private String password1;
    private String password2;

    public Member toEntity() {return new Member(id, email, password1);
    }

    public boolean isPasswordMatch() {
        return password1 != null && password1.equals(password2);
    }
}
