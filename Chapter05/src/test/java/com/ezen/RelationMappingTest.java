package com.ezen;

import java.util.Date;

import org.junit.Ignore;
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
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;

	@Test
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("1111");
		member1.setName("이순신");
		member1.setRole("User");
		
		//memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("2222");
		member2.setName("장보고");
		member2.setRole("Admin");
		
		//memberRepo.save(member2);
		
		// 각 멤버의 게시글 등록
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			
			board.setMember(member1);
			board.setTitle("이순신이 등록한 게시글 " + i);
			board.setContent("이순신이 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			//boardRepo.save(board);
		}
		memberRepo.save(member1);
		
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			
			board.setMember(member2);
			board.setTitle("장보고가 등록한 게시글 " + i);
			board.setContent("장보고가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			//boardRepo.save(board);
		}
		memberRepo.save(member2);
	}

/*
	// 상세 게시글 테스트
	@Test
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();
		
		System.out.println("["+board.getSeq()+"번 게시글 정보]");
		System.out.println("제목: " + board.getTitle());
		System.out.println("내용: " + board.getContent());
		System.out.println("작성자: " + board.getMember().getName());
		System.out.println("작성자 권한: " + board.getMember().getRole());
	}

	
	// 양방향 연관관계 테스트
	@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		
		System.out.printf("<<<%s의 게시글>>>", member.getName());
		System.out.println("--------------------------------");
		List<Board> boardList = member.getBoardList();
		for(Board board : boardList){
			System.out.println(board.toString());
		}
	}
*/
	
	// Cascade 삭제 테스트
	@Test
	@Ignore
	public void testCascadeDelete() {
		memberRepo.deleteById("member2");
	}
}