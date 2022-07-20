package com.ezen.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.domain.BoardVO;

@RestController
public class BoardController {

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello! " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목");
		board.setWriter("테스터");
		board.setContent("테스트 내용입니다");
		board.setCreateDate(new Date());
		board.setCnt(0);
		
		return board;
	}
}
