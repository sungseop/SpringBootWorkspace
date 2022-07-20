package com.ezen.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
/*
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// HttpSecurity 객체 - 이 객체를 이용하여 애플리케이션 자원에 대한 인증과 권한 관리를 제어함
	protected void configure(HttpSecurity security) throws Exception{
		security.authorizeRequests().antMatchers("/").permitAll();	// 모든 사용자 접근 가능
		security.authorizeRequests().antMatchers("/member/**").authenticated();	// 로그인 성공한 사용자만 접근 가능
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");	// MANAGER 권한을 가진 사용자만 접근 가능
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");	// ADMIN 권한을 가진 사용자만 접근 가능
		
		// csrf - Cross Site Request Forgery - 자신의 의도와 상관없이 웹 사이트를 공격하는 행위
		security.csrf().disable();
		//security.formLogin();	// form() 태그를 가진 로그인 화면을 지원한다는 설정
		// 직접 작성한 로그인 화면 제공 설정
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		// 인증되지 않은 사용자에게 제공하는 URL
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		// 로그아웃 설정
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
	}
	
	// 사용자별로 권한을 부여하는 메소드
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("manager")
									 .password("{noop}manager123") // {noop} 비밀번호를 암호화 하지 않도록 설정
									 .roles("MANAGER");
		
		auth.inMemoryAuthentication().withUser("admin")
									 .password("{noop}admin123")
									 .roles("ADMIN");
	}

}
*/
@Configuration
public class SecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private BoardUserDetailsService boardUserDetailsService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.authorizeRequests().antMatchers("/").permitAll();	// 모든 사용자 접근 가능
		security.authorizeRequests().antMatchers("/member/**").authenticated();	// 로그인 성공한 사용자만 접근 가능
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");	// MANAGER 권한을 가진 사용자만 접근 가능
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");	// ADMIN 권한을 가진 사용자만 접근 가능
		
		// csrf - Cross Site Request Forgery - 자신의 의도와 상관없이 웹 사이트를 공격하는 행위
		security.csrf().disable();
		//security.formLogin();	// form() 태그를 가진 로그인 화면을 지원한다는 설정
		// 직접 작성한 로그인 화면 제공 설정
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		// 인증되지 않은 사용자에게 제공하는 URL
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		// 로그아웃 설정
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		// 테이블의 사용자 정보를 Details 타입으로 변환
		security.userDetailsService(boardUserDetailsService);
		
		return security.build();
	}
	
	// 암호화를 수행하기 위한 객체를 리턴
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	// 사용자별로 권한을 부여하는 메소드
/*	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("manager")
									 .password("{noop}manager123") // {noop} 비밀번호를 암호화 하지 않도록 설정
									 .roles("MANAGER");
		
		auth.inMemoryAuthentication().withUser("admin")
									 .password("{noop}admin123")
									 .roles("ADMIN");
	
		// 사용자 정보 조회
		String query1 = "SELECT id, username, concat('{noop}', password) password, true enabled FROM member WHERE id=?";
		// 사용자 권한 조회
		String query2 = "SELECT id, role FROM member WHERE id=?";
		
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(query1)	// 인증 처리
			.authoritiesByUsernameQuery(query2);	// 권한 검증
	}*/
}