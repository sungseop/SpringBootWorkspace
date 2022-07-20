package com.ezen.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
// (1) 테이블 사용 키 생성
//@Table(name="BOARD")
//@TableGenerator(name="BOARD_SEQ_GENERATOR",
//				table="ALL_SEQUENCES",
//				pkColumnValue="BOARD_SEQ",
//				initialValue=0,
//				allocationSize=1)
// (2) 시퀀스 사용 키 생성
@SequenceGenerator(name="BOARD_SEQ_GENERATOR",
				   sequenceName="BOARD_SEQUENCE",
				   initialValue=1,
				   allocationSize=1)
public class Board {
	@Id
// (1) 테이블 사용 키 생성
//	@GeneratedValue(strategy=GenerationType.TABLE,
//					generator="BOARD_SEQ_GENERATOR")
// (2) 시퀀스 사용 키 생성
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
				    generator="BOARD_SEQ_GENERATOR")
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate = new Date();
	private int cnt = 0;
}





