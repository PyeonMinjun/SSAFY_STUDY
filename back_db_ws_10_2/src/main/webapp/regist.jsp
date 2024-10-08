<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자정보사이트</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
	<h1>SSAFY 사용자 관리</h1>
	<form method="post" action="main">
		<fieldset>
		<legend>사용자 정보 입력</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="act" value="regist">
		<label for="id">제목</label>
		<input type="text" id="id" name="id"><br>
		
		<label for="director">감독</label>
		<input type="text" id="director" name="director"><br>
		
		<label for="genre">장르</label>
		<input type="text" id="genre" name="genre"><br>
		
		<label for="email">이메일</label>
		<input type="text" id="email" name="email"><br>
		
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
		</fieldset>
	</form>
</body>
</html>
