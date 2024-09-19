package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {

//	TODO : BoardServiceImpl의 객체를 Singleton으로 새성하고 instance를 return하는 getBoardService()를 만드세요.

	private static final BoardService instace = new BoardServiceImpl();

	private BoardServiceImpl() {
	}

	public static BoardService getInstance() {
		return instace;
	}


//	END

	@Override
	public void registerArticle(BoardDto boardDto) throws SQLException {
		BoardDaoImpl.getBoardDao().registerArticle(boardDto);
	}

	@Override
	public List<BoardDto> searchListAll() {
		return BoardDaoImpl.getBoardDao().searchListAll();
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		return BoardDaoImpl.getBoardDao().searchListBySubject(subject);
	}

	@Override
	public BoardDto viewArticle(int no) throws SQLException {
		return BoardDaoImpl.getBoardDao().viewArticle(no);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		BoardDaoImpl.getBoardDao().modifyArticle(boardDto);
	}

	@Override
	public void deleteArticle(int no) throws SQLException {
		BoardDaoImpl.getBoardDao().deleteArticle(no);
	}

}
