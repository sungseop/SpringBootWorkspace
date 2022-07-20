package com.ezen;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.domain.Board;
import com.ezen.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest {

	@Autowired
	private BoardRepository boardRepo;
	
	/*
	@Test
	@Ignore
	public void testQueryAnnotationTest1() {
		List<Board> boardList = boardRepo.queryAnnotationTest1("게시글 제목 10");
		
		System.out.println("===> 검색 결과");
		for(Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	@Ignore
	public void testQueryAnnotationTest2() {
		List<Board> boardList = boardRepo.queryAnnotationTest2("게시글 제목 10");
		
		System.out.println("===> 검색 결과");
		for(Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	@Ignore
	public void testQueryAnnotationTest3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("게시글 제목 10");
		
		System.out.println("===> 검색 결과");
		for(Object[] row : boardList) {
			System.out.println("--->" + Arrays.toString(row));  // Object 배열을 문자열로 변환하여 출력
		}
	}
	
	@Test
	public void testQueryAnnotationTest4() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest4("게시글 제목 10");
		
		System.out.println("===> 검색 결과");
		for(Object[] row : boardList) {
			System.out.println("--->" + Arrays.toString(row));  // Object 배열을 문자열로 변환하여 출력
		}
	}
	
	@Test
	public void testQueryAnnotationTest5() {
		Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		
		List<Board> boardList = boardRepo.queryAnnotationTest5(paging);
		
		System.out.println("===> 검색 결과");
		for(Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	*/
}
