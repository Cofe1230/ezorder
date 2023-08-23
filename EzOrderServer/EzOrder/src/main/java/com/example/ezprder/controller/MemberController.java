package com.example.ezprder.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ezprder.model.Member;
import com.example.ezprder.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
	private final MemberService memberService;
	
	@GetMapping("insertMember/")
	public void saveMember(String memberName) {
		memberService.saveMember(memberName);
	}
	
	@PostMapping("updateToken")
	public void updateToken(@RequestBody Member member) {
		memberService.updatefcmToken(member);
	}
}
