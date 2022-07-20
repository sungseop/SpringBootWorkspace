package com.ezen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.domain.Board;
import com.ezen.domain.Member;
import com.ezen.persistence.BoardRepository;
import com.ezen.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitTest {
	
	@Autowired
	private MemberRepository memberRepo;
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDataInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("1111");
		member1.setName("이순신");
		member1.setRole("ROLE_USER");
		
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("2222");
		member2.setName("장보고");
		member2.setRole("ROLE_ADMIN");
		
		memberRepo.save(member2);
		
		// 각 멤버의 게시글 등록
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			
			board.setWriter("이순신");
			board.setTitle("이순신이 등록한 게시글 " + i);
			board.setContent("이순신이 등록한 게시글 내용 " + i);
			
			boardRepo.save(board);
		}
		
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			
			board.setWriter("장보고");
			board.setTitle("장보고가 등록한 게시글 " + i);
			board.setContent("장보고가 등록한 게시글 내용 " + i);
		
			boardRepo.save(board);
		}
	}
}
