package com.ezen;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ezen.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		// EntityManger 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
		
			/*
			// 글 등록
			tx.begin();
			Board board = new Board();
			
			board.setTitle("JPA 제목");
			board.setWriter("이순신");
			board.setContent("게시글 내용입니다.");
			board.setCreateDate(new Date());
			board.setCnt(0);
			
			em.persist(board);  
			
			tx.commit();
			*/
			// 글 상세 조회
			//Board searchResult = em.find(Board.class, 1);
			//System.out.println("===>"+searchResult);
			
			// 글 수정
			// 트랜잭션 시작
			
			//tx.begin();
			/*
			Board board = em.find(Board.class, 2);
			board.setTitle("게시글 제목 수정");
			*/
			
			// 게시글 삭제
			/*
			Board board = em.find(Board.class, 2);
			board.setSeq(2);
			em.remove(board);
			
			
			// 트랜잭션 커밋
			tx.commit();  // 수정 사항 반영
			*/
			// 글 목록 조회
			String jpql = "SELECT b FROM Board b ORDER BY b.seq DESC"; 
			
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for(Board item : boardList) {
				System.out.println("--->" + item.toString());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			//tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}






