package com.ezen.service;

import java.util.List;

import com.ezen.domain.Board;

public interface BoardService {

	List<Board> getBoardList(Board board);

	Board getBoard(Board board);

	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}