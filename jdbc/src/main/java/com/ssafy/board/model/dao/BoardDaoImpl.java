package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	
	private static BoardDao boardDao = new BoardDaoImpl();
	
	private BoardDaoImpl() {}

	public static BoardDao getBoardDao() {
		return boardDao;
	}

	@Override
	public void registerArticle(BoardDto boardDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 board table에 insert 하세요!!!


		DBUtil db = DBUtil.getInstance();
		try {
			conn = db.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		// 2. sql 작성
		StringBuilder sql = new StringBuilder("insert into board (subject, content, user_id)\n");
		sql.append("values (?,?,?)");
		pstmt = conn.prepareStatement(sql.toString());

		// 2 -1 pstmt  작성
		pstmt.setString(1, boardDto.getSubject());
		pstmt.setString(2, boardDto.getContent());
		pstmt.setString(3, boardDto.getUserId());
		pstmt.executeUpdate();




//		END
	}

	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;

//		TODO : board table의 모든 글정보를 글번호순으로 정렬하여 list에 담고 return 하세요!!!
        try {
            conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from board \n");
			sql.append("order by article_no desc");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setRegisterTime(rs.getString("register_time"));

				list.add(boardDto);
			}


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}


//		END
		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table에서 제목에 subject를 포함하고 있는 글정보를 list에 담고 return 하세요!!!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


        try {
            conn = DBUtil.getInstance().getConnection();

			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from board \n");
			sql.append("where subject like ? \n");
			sql.append("order by article_no desc");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+subject + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setRegisterTime(rs.getString("register_time"));

				list.add(boardDto);
			}






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
			DBUtil.getInstance().close(rs,pstmt,conn);
		}


//		END
		return list;
	}

	@Override
	public BoardDto viewArticle(int no) throws SQLException {
		BoardDto boardDto = null;
//		TODO : board table에서 글번호가 no인 글 한개를 return 하세요!!!
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select *\n");
			sql.append("from board\n");
			sql.append("where article_no = ? \n");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setRegisterTime(rs.getString("register_time"));

				list.add(boardDto);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			DBUtil.getInstance().close(rs,pstmt,conn);
		}



//		END
		return boardDto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 이용하여 글번호에 해당하는 글제목과 내용을 수정하세요!!!
		// 1. 드라이브 로드
		// 2. 커넥션 연결

		DBUtil db = DBUtil.getInstance();
		conn = db.getConnection();


		// 3. preparestatement
		StringBuilder sql = new StringBuilder("update board \n");
		sql.append("set subject = ? , content =  ? \n");
		sql.append("where user_id = ?");

		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1,boardDto.getSubject());
		pstmt.setString(2, boardDto.getContent());
		pstmt.setString(3, boardDto.getUserId());

		pstmt.executeUpdate();

//		END
	}

	@Override
	public void deleteArticle(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : board table에서 글번호가 no인 글 정보를 삭제하세요!!!


		DBUtil db = DBUtil.getInstance();
        try {
            conn = db.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


		StringBuilder sql = new StringBuilder("delete from board \n");
		sql.append("where article_no = ?");
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, no);
		pstmt.executeUpdate();

//		END
	}

}
