package com.example.SpringProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Member {
    @Id // 엔티티 대푯값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동적으로 1씩 증가
    private Long id;
    @Column
    private String email;
    @Column
    private String password;
}
