package com.example.ezprder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ezprder.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByMemberName(String memberName);

}
