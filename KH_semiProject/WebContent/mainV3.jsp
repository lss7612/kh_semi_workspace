<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	
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
					<li>
					<a href="/address/view" name = "address">주소록</a>
						<ul>
							<li><a href="/address/view">사원 목록</a></li>
							<li><a href="/address/mine">내 주소록</a></li>
						</ul>
					</li>
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
				<div id="profile">
					<ul>
						<li>프로필 공간입니다</li>
						<li>등등</li>
					</ul>
				</div>
			</div>


		</nav>
		<main>
		내용없음
		
		
		</main>

		<footer>FOOTER</footer>
	</div>

</body>
</html>