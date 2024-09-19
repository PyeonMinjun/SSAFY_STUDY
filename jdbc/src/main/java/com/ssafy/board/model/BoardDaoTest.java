package com.ssafy.board.model;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;

import java.sql.SQLException;

public class BoardDaoTest {

    public static void main(String[] args) {
        // 1. BoardDao 객체 생성
        BoardDao boardDao = BoardDaoImpl.getBoardDao();

        // 2. BoardDto 객체 생성 및 값 설정
        BoardDto boardDto = new BoardDto();
        boardDto.setArticleNo(100); // article_no 값을 설정
        boardDto.setUserId("testUser100"); // user_id 값을 설정
        boardDto.setSubject("Test Subject100"); //

        // subject 값을 설정
        boardDto.setContent("Test Content100"); // content 값을 설정
        boardDto.setRegisterTime("2024-09-19 12:00:00"); // register_time 값을 설정

        // 3. registerArticle 메서드 호출
        try {
            boardDao.registerArticle(boardDto); // DB에 값 삽입
            System.out.println("게시글이 성공적으로 등록되었습니다.");
        } catch (SQLException e) {
            System.out.println("게시글 등록 중 오류 발생: " + e.getMessage());
        }


    }
}