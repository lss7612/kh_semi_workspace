<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(window).load(function() {

	$('.submenu').children().css("display", "none")
	var link = document.location.pathname; 
	var pathname = document.location.pathname.split( '/' );
	var path_id = pathname[1];
	console.log(link);
	console.log(path_id);
	
	if (path_id=="mainV4.jsp"){
		
		$('#main').css("display", "block")
		
	}else if(path_id=="approval"){
		
		$('#appr').css("display", "block")
		
	}else if(path_id=="note"){
		
		$('#mes').css("display", "block")
		
	}else if(path_id=="address"){
		
		$('#address').css("display", "block")
		
	}
	
	});


	
</script>
</head>
<body>
	<nav>
			<div class="submenu">
				<div id="main">
					<ul>
						<li><a href="#" name="main">프로필</a></li>
						<li><a href="#" name="main">내정보</a></li>
						<li><a href="#" name="main">내상태</a></li>
					</ul>
				</div>
				<div id="appr">
					<ul>
						<li><button style="background-color:skyblue" type="button" onclick="location.href='/approval/approvalWrite'">결재 작성하기</button></li>
						<li><a href="/approval/approvalmy" name="rufwo">기안함</a></li>
						<li><a href="/approval/DoApproval" name="rufwo">결재함</a></li>
						<li><a href="/approval/deptApproval" name="rufwo">부서결재함</a></li>
					</ul>
				</div>


				<div id="mes">
					<ul>
						<li><a href="/note/send" name="message">받은쪽지함</a></li>
						<li><a href="/note/send" name="message">보낸쪽지함</a></li>
						<li><a href="/note/send" name="message">쪽지쓰기</a></li>
					</ul>
				</div>
				
				<div id="address">
					<ul>
						<li><a href="/address/view">사원 목록</a></li>
						<li><a href="/address/mine">내 주소록</a></li>
					</ul>
				</div>
			</div>
		</nav>
</body>
</html>