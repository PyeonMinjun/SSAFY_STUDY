package com.ssafy.board.model;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;

import java.sql.SQLException;

public class BoardServiceTest {

    public static void main(String[] args) {
        // BoardDao 객체 생성
        BoardDao boardDao = BoardDaoImpl.getBoardDao();

        // 테스트용 BoardDto 생성
        BoardDto boardDto = new BoardDto();
        boardDto.setSubject("수정된 제목");
        boardDto.setContent("수정된 내용");
        boardDto.setUserId("testUser100");

        try {
            // 게시글 수정 메서드 호출
            boardDao.modifyArticle(boardDto);
            System.out.println("게시글 수정 완료");
        } catch (SQLException e) {
            // 예외 발생 시 메시지 출력
            System.out.println("SQL 예외 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
