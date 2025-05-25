package com.example.SpringProject.repository;

import com.example.SpringProject.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
