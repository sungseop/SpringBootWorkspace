package com.ezen;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.domain.Board;
import com.ezen.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class boardControllerTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void dataInsertTest() {
		for(int i=1; i<=10; i++) {
			Board board = new Board();
			
			board.setTitle("게시글 제목 " + i);
			board.setWriter("작성자");
			board.setContent("게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			boardRepo.save(board);
		}
	}
}
