package com.ezen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.domain.BoardVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc	// Controller, Service, Repository 등을 모두 테스트
public class BoardControllerTest3 {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception{
		
		String result = restTemplate.getForObject("/hello?name=gildong", String.class);
		
		assertEquals("Hello: gildong", result);
	}
	
	@Test
	public void testGetBoard() throws Exception{
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		
		assertEquals("테스트 제목", board.getTitle());
	}
}
