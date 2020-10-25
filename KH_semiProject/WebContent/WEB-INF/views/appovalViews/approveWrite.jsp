<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<style type="text/css">
h3 {
	text-align: center;
}
canvas {
	position:absolute;

}

#can{
	position:relative;
    padding-left: 0;
    padding-right: 0;
    margin-left: auto;
    margin-right: 50px;
    display: block;
    width: 40px;
}
#c{
	position:absolute;
	background-color: transparent;
	width :40px;
	height :40px;
}

</style>

<script type="text/javascript">
window.onload = function() {
	loaded();
}
 function loaded(){
	 var canvas =document.getElementById("canvas1");
	 
	 var context = canvas.getContext('2d');
	 console.log(context)
	 console.log("aa")
	 context.beginPath();
	 context.moveTo(0, 0);
	 context.lineTo(40, 40);
	 context.stroke();
	 context.moveTo(40, 0);
	 context.lineTo(0, 40);
	 context.stroke();

 }

</script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js">

</script>

</head>
<body>

	<div class="container">
		<header>
			<div>
				<ul class="navi">
					<li><a href="#">home버튼</a></li>
					<li><a href="/note/send" name="message">쪽지</a>
						<ul>
							<li><a href="/note/send" name="message">받은쪽지함</a></li>
							<li><a href="/note/send" name="message">보낸쪽지함</a></li>
							<li><a href="/note/send" name="message">쪽지쓰기</a></li>
						</ul></li>
					<li><a href="/address/view" name="address">주소록</a>
						<ul>
							<li><a href="/address/view">사원 목록</a></li>
							<li><a href="/address/mine">내 주소록</a></li>
						</ul></li>
					<li><a href="#">공지사항</a></li>
					<li><a href="#">커뮤니티</a></li>
					<li><a href="/menu/approval" name="rufwo">전자결재</a>
						<ul>
							<li><a href="/menu/approval" name="rufwo">전체결재함</a></li>
							<li><a href="/menu/deptApproval" name="rufwo">부서결재함</a></li>
							<li><a href="/menu/approvalWrite" name="rufwo">결재 작성하기</a></li>

						</ul></li>

				</ul>
			</div>
			<div>
				<button>채팅</button>
				<button>다크모드</button>
			</div>

		</header>

		<nav>
			<div class="submenu">
				<div id="appr">
					<ul>
						<li><a href="/menu/approval" name="rufwo">전체결재함</a></li>
						<li><a href="/menu/deptApproval" name="rufwo">부서결재함</a></li>
						<li><a href="/menu/approvalWrite" name="rufwo">결재 작성하기</a></li>
					</ul>
				</div>
			</div>


		</nav>
		<main>

				<header>승인 작성 페이지입니다</header>

				<h3>연차 휴가계</h3>
				<form action="#" method="post">

					<select id="dimension">
						<option value="holiday">휴가계</option>
						<option value="work">업무일지</option>
					</select>
					<div id="can">
					<canvas id="canvas1" width="40" height="40"
						style="border: 1px solid #000;"></canvas>
					<button id="c">btn</button>
					</div>
				</form>
		</main>

		<footer>FOOTER</footer>
	</div>

</body>
</html>