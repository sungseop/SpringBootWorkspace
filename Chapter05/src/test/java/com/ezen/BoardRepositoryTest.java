package com.ezen;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.domain.Board;
import com.ezen.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	@Ignore
	public void testInsertBoard() {
		Board board = new Board();
		
		board.setTitle("첫번째 게시글");
//		board.setWriter("작성자");
		board.setContent("반갑습니다.");
		board.setCreateDate(new Date());
		board.setCnt(1L);
		
		boardRepo.save(board);
	}
	
	@Test
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get(); // get() - Optional객체에서 데이터를 추출하는 메소
		
		System.out.println(board);
	}
	
	@Test
	@Ignore
	public void testUpdateBoard() {
		System.out.println("===> 1번 게시글 조회");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("===> 1번 게시글 수정");
		board.setTitle("수정된 제목");
		boardRepo.save(board);
	}
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
}









