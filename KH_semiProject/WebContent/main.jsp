<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type = "text/css" href="/resources/css/main.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
 <script type="text/javascript">
 
 $('document').ready(function(){
	
	 $('a').click(function(){
		 $('main').load($(this).attr('href'))
		 return false
	 })
	 
 })
 
 </script>
 
<!-- 메인메뉴 20201023 by sangjin  -->
<!-- list 추가하고싶은 서브 메뉴 <li>태그 박아서 넣으면됨 -->
<!-- css는 resources/css 폴더에 따로 빼놨으니까 거기서 수정하세요~ -->
<!-- html 전체적인 틀같은거는 잘하는사람이 수정 부탁드립니다.. -->


<!-- 20201024 이상성 -->
<!-- 아래 a태그의 href에 본인 서블릿의 url을 등록하면 main부분에 페이지가 로드됩니다. -->
<!-- 본인의 코드를 제 깃에 합쳐보세요 하다가 모르는거 있으면 채팅방공유해주세요. 같이해결합시다. -->




</head>
<body>
<div class="container">
<header>
	<div>
		<ul class="navi">
			<li><a href="#">home버튼</a></li>
			<li>
				<a href="#">쪽지</a>
				<ul>
					<li><a href="#">받은쪽지함</a></li>
					<li><a href="#">보낸쪽지함</a></li>
					<li><a href="/note/send">쪽지쓰기</a></li>
				</ul>
			</li>
			<li><a href="/address/view"">주소록</a></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="#">커뮤니티</a></li>
			<li><a href="#">전자결재</a></li>

		</ul>
	</div>
	<div><button>채팅</button>
		 <button>다크모드</button>
	</div>

</header>
  <nav>NAV

  
  
  
  
  </nav>
  <main>MAIN</main>

  <footer>FOOTER</footer>
</div>

</body>
</html>