<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="dto.appr.Person" %>
<%@page import="java.util.List"%>
<%-- <%	List<Board> list = (List<Board>) request.getAttribute("list"); %> --%>

<% List<Person> people  = (List<Person>) request.getAttribute("people"); %>
<% List<Person> dept_name  = (List<Person>) request.getAttribute("dept_name"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>

	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<title>jQuery treeview</title>

	<link rel="stylesheet" href="/views/appovalViews/jquery-treeview/jquery.treeview.css" />
<!--     <link rel="stylesheet" href="/views/appovalViews/jquery-treeview/red-treeview.css" /> -->
	<link rel="stylesheet" href="/views/appovalViews/jquery-treeview/demo/screen.css" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
	<script src="/views/appovalViews/jquery-treeview/demo/jquery.cookie.js"></script>
	<script src="/views/appovalViews/jquery-treeview/jquery.treeview.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(function() {
			$("#browser").treeview();
		});
	</script>


<script type="text/javascript">

$(document).ready(function () {


	$("button[name='add']").click(function() {
		//임시변수
		var temp=$(this).attr('value');
		var temp_Member=$(this).attr('memberNo');
		//값찍어보는거
		console.log(temp);
		//첫번째 사람 추가
		if(!$("#result1").text()){
			//이름html추가
			$("#result1").html(temp);
			// 속성값 추가
			$("#first").attr('value',temp);
			$("#first_no").attr('value',temp_Member);
			
		//두번째 사람 추가	
		}else {
			//이름html추가
			$("#result2").html(temp);
			// 속성값 추가
			$("#second").attr('value',temp);
			$("#second_no").attr('value',temp_Member);
		}
	
	
	})
	
	$("button[name='sub']").click(function() {
		if($("#result2").text()){
			//2차 결재권자 제거
			$("#result2").text("");
			
			//멤버넘버 속성값 제거
			$("#second").attr('value','');
			$("#second_no").attr('value','');
		}else {
			//1차 결재권자 제거
			$("#result1").text("");
			//멤버넘버 속성값 제거
			$("#first").attr('value','');
			$("#first_no").attr('value','');
		}
	})

})



function goSubmit() {
    window.opener.name = "parentPage"; // 부모창의 이름 설정
    document.myForm.target = "parentPage"; // 타켓을 부모창으로 설정
    document.myForm.action = "/approvalMy/mod";
    document.myForm.submit();
    self.close();
}

</script>




	</head>
	<body>
ㅋㅋㅋ
<!-- 	<h1 id="banner"><a href="http://bassistance.de/jquery-plugins/jquery-plugin-treeview/">jQuery Treeview Plugin</a> Demo</h1> -->
	<div id="main">

	<h4>결재권자 추가</h4>
	<ul id="browser" class="filetree">
	
	
	<% for(int i=0; i<dept_name.size(); i++) { %>
	
		
		<li class="closed"><img src="/views/appovalViews/jquery-treeview/images/folder.gif" /><%=dept_name.get(i).getDept_name() %>
			<ul>
			<% for(int j=0; j<people.size();j++){%>
	
				<% if(dept_name.get(i).getDept_name().equals(people.get(j).getDept_name())) { %>
				<li> <img src="/views/appovalViews/jquery-treeview/images/file.gif" /><%=people.get(j).getUser_name() %>
				<!-- memberNo 속성은 유저번호를 전달하기위해 임의로 추가한것 -->
				<button name ="add" value="<%=people.get(j).getUser_name() %>" memberNo="<%=people.get(j).getUser_no() %>">추가</button>
				<button name ="sub" value="<%=people.get(j).getUser_name() %>">삭제</button></li>
				

			<%	}} %>
			</ul>
		</li>
			
	<%	} %>
	
		
	</ul>
	
	

</div>
<form name ="myForm" action="#">
	<div style="text-align:center;">1차 결재권자 : <div id="result1" ></div></div>
	<div style="text-align:center;">2차 결재권자  : <div id="result2"></div></div>
	<input id="first" type="hidden" value="" name="firstApproval" />
	<input id="second" type="hidden" value="" name="secondApproval" />
	<input id="first_no" type="hidden" value="" name="firstApprovalNo" />
	<input id="second_no" type="hidden" value="" name="secondApprovalNo" />
	
	<input type="button" onclick="goSubmit()" value="등록" />

</form>
</body>



</html>