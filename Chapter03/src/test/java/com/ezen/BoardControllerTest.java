package com.ezen;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BoardControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHello() throws Exception{
		
		mockMvc.perform(get("/hello").param("name", "GilDong"))
		       .andExpect(status().isOk())	// Http의 응답 결과 코드
		       .andExpect(content().string("Hello: GilDong"))	// 컨트롤러의 응답 메세지
		       .andDo(print());	// 응답 결과 메세지
	}
}
