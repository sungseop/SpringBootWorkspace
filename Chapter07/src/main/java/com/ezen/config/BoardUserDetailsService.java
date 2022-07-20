package com.ezen.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ezen.domain.Member;
import com.ezen.domain.SecurityUser;
import com.ezen.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;
	
	public BoardUserDetailsService() {
		// TODO Auto-generated constructor stub
	}
	
	// MemberRepository를 통해 회원 정보를 조회하여 스프링에서 인증 관리를 하기 위해 UserDetails 객체에 저장하여 리턴함
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// MemberRepository로 회원 정보 조회
		Optional<Member> optionalUser = memberRepo.findById(username);
		
		if(optionalUser.isPresent()) {
			// UserDetails 타입의 객체로 변환하여 리턴
			Member member = optionalUser.get();
			return new SecurityUser(member);
		} else {
			throw new UsernameNotFoundException(username + "사용자 없음");
		}
	}
}