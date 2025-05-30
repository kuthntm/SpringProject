package com.example.SpringProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Member {
    @Id // 엔티티 대푯값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동적으로 1씩 증가
    private Long id;
    @Column (unique = true)
    private String email;
    @Column
    private String password;

    public void patch(Member member) {
        if (member.getEmail() != null) {
            this.email = member.getEmail();
        }
        if (member.getPassword() != null) {
            this.password = member.getPassword();
        }
    }
}
