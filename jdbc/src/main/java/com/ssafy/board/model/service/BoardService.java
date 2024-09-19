package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.BoardDto;

public interface BoardService {

	void registerArticle(BoardDto boardDto) throws SQLException;
	List<BoardDto> searchListAll();
	List<BoardDto> searchListBySubject(String subject);
	BoardDto viewArticle(int no) throws SQLException;
	void modifyArticle(BoardDto boardDto) throws SQLException;
	void deleteArticle(int no) throws SQLException;
	
}
