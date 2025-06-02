package com.example.SpringProject.repository;

import com.example.SpringProject.entity.Member;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
