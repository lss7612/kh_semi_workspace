<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page contentType="text/html; charset=UTF-8" %>
<title>Insert title here</title>
</head>
<body>

<h1> 스케줄 입력</h1>
<hr>

<form action="/semi/SchdlInput" method="post">
<table>

<tr>
	<tb><label for="shno" id="shno"> 스케줄 넘버</label></tb><br>
	<tb><input type="text" id="shno" name="schdl_no"> </tb><br>
	<br>
	
	
	<tb><label for="shtype" id="shtype"> 스케줄 타입</label></tb><br>
	<tb><input type="radio" id="shtype1" name="schdl_type" value="1">개인스케줄</tb>		
	<tb><input type="radio" id="shtype1" name="schdl_type" value="2">공유스케줄</tb><br>
	<br>
	
	<tb><label for="shname" id="shname"> 스케줄 이름</label></tb><br>
	<tb><input type="text" id="shname" name="schdl_title"> </tb><br>
	<br>
	
	<tb><label for="shcon" id="shcon"> 스케줄 내용</label></tb><br>
	<tb><input type="text" id="shcon" name="schdl_content"> </tb><br>
	<br>
	
	 스케줄 시작 일자<br>
	<input type="date" name="schdl_start" value="2020-10-01"/>

나중에 로그인한 후에 스케줄을 입력하면, 로그인한 유저 번호를 가져오는 작업은 따로해볼께요
일단 유저넘버도 널이면 안되니까 
여기서늗너 ㅂ이ㅏㄴ로받 ㅇ안받아와도 이따가 디에이오임플에서 따로 넣어볼게요
	
 	스케줄 종료 일자<br>
	<input type="date" name="schdl_end" value="2020-10-01"/>
	
	<br><br>	
	
	스케줄 작성 일자<br>
	<input type="date" name="revision_date" value="2020-10-01"/>
	
	<br><br>

	
	<datalist id="fruits">
	<option value="shno">50</option>

	</datalist>
	
	<label For="fr">스케줄 번호 </label>
		<br>
	<input list="fruits" name="table_no" id="fr"/>	
	
	<br><br>
	<tb></tb>
	<tb><button>확인</button>
	
</tr>

</table>
</form>
</body>
</html>