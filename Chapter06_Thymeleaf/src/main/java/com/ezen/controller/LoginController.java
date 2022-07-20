package com.ezen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ezen.domain.Member;
import com.ezen.service.MemberService;

@Controller
@SessionAttributes("member")
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public void loginView() {
		
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member loginUser = memberService.getMember(member);
		
		// 테이블에서 ID를 조건으로 조회한 사용자가 존재하고 화면에 입력된 비밀번호와 테이블에서 조회한 비밀번호가 같은지 비교
		if(loginUser != null &&
				loginUser.getPassword().equals(member.getPassword())) {
			// 인증된 사용자
			model.addAttribute("member", loginUser);
			
			return "redirect:getBoardList";
		} else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		
		return "redirect:index.html";
	}
}
