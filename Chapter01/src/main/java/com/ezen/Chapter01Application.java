package com.ezen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.ezen", "com.example"})
public class Chapter01Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
		
/*		// 자바 애플리케이션으로 실행
		SpringApplication application = new SpringApplication(Chapter01Application.class);
		
		application.setWebApplicationType(WebApplicationType.NONE); // WebApplicationType.NONE: 톰캣 없이 실행하겠다는 뜻
		application.run(args);
*/
	}

}
