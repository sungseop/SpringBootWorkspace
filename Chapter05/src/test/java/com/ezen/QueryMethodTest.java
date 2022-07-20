package com.ezen;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.domain.Board;
import com.ezen.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
	/*
	@Before
	public void dataInsert() {
		for(int i=1; i<=200; i++) {
			Board board = new Board();
			
			board.setTitle("게시글 제목 " + i);
			board.setWriter("작성자");
			board.setContent("게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			boardRepo.save(board);
		}
	}
	*/
	
	@Test
	@Ignore
	public void testFindByTitle() {
		
		List<Board> boardList = boardRepo.findByTitle("게시글 제목 10");
		
		for (Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	@Ignore
	public void testByContentContaining() {
		
		List<Board> boardList = boardRepo.findByContentContaining("15");
		
		System.out.println("===> 검색 결과");
		for(Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	@Ignore
	public void testFindByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("15", "15");
		
		System.out.println("===> 검색 결과");
		for(Board board : boardList) {
			System.out.println("---> " + board);
		}
	}

	@Test
	@Ignore
	public void testFindByTitleContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("13");
		
		System.out.println("===> 검색 결과");
		for(Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	public void testFindByTitleContaining() {
		
		//Pageable paging = PageRequest.of(1, 5);
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		
		//List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
		// 페이징 정보 확인하기
		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
		
		System.out.println("PAGE SIZE: " + pageInfo.getSize());
		System.out.println("TOTAL PAGES: " + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT: " + pageInfo.getTotalElements());
		System.out.println("NEXT: " + pageInfo.hasNext());
		
		List<Board> boardList = pageInfo.getContent();
		System.out.println("===> 검색 결과");
		for(Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
}


















