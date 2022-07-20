package com.ezen.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="member")
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long seq;
	private String title;
//	private String writer;  // member가 있으므로 comment 처리
	private String content;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createDate;  // H2에 테이블 생성시 create_date
	private Long cnt;
	// Owner 클래스쪽에 관계 설정
	// nullable=false: member에 값이 있는 경우만 조회한다는 의미
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false)
	private Member member;

	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}
