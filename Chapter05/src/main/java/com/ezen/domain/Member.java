package com.ezen.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="boardList")
@Entity
public class Member {
	@Id
	@Column(name="MEMBER_ID")   // 관계설정을 위해 이름을 부여
	private String id;
	private String password;
	private String name;
	private String role;
	
	// 양방향 관계 설정을 위해 OneToMany 관계를 추가
	// mappedBy: 외래키가 있는 곳의 필드명
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
}
