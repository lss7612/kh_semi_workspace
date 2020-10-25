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
<script type="text/javascript">
	$('document').ready(function() {
		$('main').load("/MainController")
		
		$('a').click(function() {
			$('main').load($(this).attr('href'))

			var Name = $(this).attr('name');
			//탑바 메뉴 클릭시 compareName 함수 호출
			compareName(Name);

			return false

		})

	})

	
//화면 왼쪽영역에 어떤 메뉴를 표출할지 비교하는 함수
//평소에는 display none, main.css 확인....
//

	function compareName(Name) {
		
		$('.submenu').children().css("display", "none")
		
		//클릭한 메뉴의 name속성이 rufwo일 때 appr id를 갖는 태그를 display한다 
		if (Name == "rufwo") {

			$('#appr').css("display", "block")
		//클릭한 메뉴의 name속성이 message일 때 mes id를 갖는 태그를 display한다
		} else if (Name == "message") {

			$('#mes').css("display", "block")
		}

	}
</script>

<!-- 메인메뉴 20201023 by sangjin  -->
<!-- list 추가하고싶은 서브 메뉴 <li>태그 박아서 넣으면됨 -->
<!-- css는 resources/css 폴더에 따로 빼놨으니까 거기서 수정하세요~ -->
<!-- html 전체적인 틀같은거는 잘하는사람이 수정 부탁드립니다.. -->


<!-- 20201024 이상성 -->
<!-- 아래 a태그의 href에 본인 서블릿의 url을 등록하면 main부분에 페이지가 로드됩니다. -->
<!-- 본인의 코드를 제 깃에 합쳐보세요 하다가 모르는거 있으면 채팅방공유해주세요. 같이해결합시다. -->


<!-- 20201025 김상진 -->
<!-- 사이드 메뉴 display 설정 토글되도록 해놓았습니다  -->
<!-- 탑바랑 사이드바에 똑같이 추가하셔야해요..ㅎㅎ   -->
<!-- 예시로 전자결재 확인하시면 됩니다 -->
<!-- 쪽지도 테스트겸 조금 구현해놨습니다 -->

<!-- ********* main.css에  #사이드메뉴id { display:none;} 설정 꼭 해야합니다************ -->
<!-- 고칠 부분 있으실 경우 수정하세여!!! -->


</head>
<body>
	<div class="container">
		<header>
			<div>
				<ul class="navi">
					<li><a href="#">home버튼</a></li>
					<li><a href="/note/send" name="message">쪽지</a>
						<ul>
						<!--name 임시로 message로 넣었습니다 -->
						<!-- url 추가해주세요 -->
							<li><a href="/note/send" name="message">받은쪽지함</a></li>
							<li><a href="/note/send" name="message">보낸쪽지함</a></li>
							<li><a href="/note/send" name="message">쪽지쓰기</a></li>
						</ul></li>
					<li><a href="/address/view">주소록</a></li>
					<li><a href="#">공지사항</a></li>
					<li><a href="#">커뮤니티</a></li>
					<li><a href="/menu/approval" name="rufwo">전자결재</a>
						<ul>
							<li><a href="/menu/approval" name="rufwo">전체결재함</a></li>
							<li><a href="/menu/deptApproval" name="rufwo">부서결재함</a></li>

						</ul></li>

				</ul>
			</div>
			<div>
				<button>채팅</button>
				<button>다크모드</button>
			</div>

		</header>

<!-- NAV -->
<!-- 화면 왼쪽의 서브메뉴 영역 -->
<!--  name속성 각메뉴별로 똑같이 입력 필수!!!-->
<!--  top바의 메뉴 그대로 복사해서 가져오면 됨  -->
<!--  div id는 중복안되게!!!! -->
		<nav>

		
			<div class="submenu">
				<div id="appr">
					<ul>
						<li><a href="/menu/approval" name="rufwo">전체결재함</a></li>
						<li><a href="/menu/deptApproval" name="rufwo">부서결재함</a></li>
					</ul>
				</div>


				<div id="mes">
					<ul>
						<li><a href="/note/send" name="message">받은쪽지함</a></li>
						<li><a href="/note/send" name="message">보낸쪽지함</a></li>
						<li><a href="/note/send" name="message">쪽지쓰기</a></li>
					</ul>
				</div>
			</div>


		</nav>
		<main>MAIN</main>

		<footer>FOOTER</footer>
	</div>

</body>
</html>