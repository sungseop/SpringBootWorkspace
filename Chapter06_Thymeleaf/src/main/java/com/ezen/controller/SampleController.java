package com.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.domain.Board;
import com.ezen.service.BoardService;

// Thymeleaf 테스트용 컨트롤러
@Controller
public class SampleController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/ex2")
	public void exModel(Board board, Model model) {
		
		List<Board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList", boardList);
	}
	
	@GetMapping("/exLayout1")
	public void exLayout1() {
		System.out.println("exLayout1....");
	}
	
	@GetMapping({"/layout1", "/exTemplate"})
	public void Layout1() {
		System.out.println("Layout1....");
	}
}
