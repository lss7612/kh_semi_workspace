<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<jsp:include page="/views/common/headerKKH.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<style type="text/css">
h3 {
	text-align: center;
}

#can {
	position: relative;
	float: right;
}

.canvas {
	display: inline-block;
	width: 70px;
	height: 70px;
	text-align: center;
	vertical-align: middle;
}

.canvas>span {
	display: inline-block;
	vertical-align: text-top;
	margin: 15px 0;
}

/********************************X표시************************/
.xicon1 {
	position: absolute;
	top: -12px;
	left: 36px;
	width: 1px;
	height: 95px;
	background-color: #000;
	transform: rotate(-45deg);
}

.xicon2 {
	position: absolute;
	top: -12px;
	left: 36px;
	width: 1px;
	height: 95px;
	background-color: #000;
	transform: rotate(45deg);
}

.xicon3 {
	position: absolute;
	top: -12px;
	left: 113px;
	width: 1px;
	height: 95px;
	background-color: #000;
	transform: rotate(-45deg);
}

.xicon4 {
	position: absolute;
	top: -12px;
	left: 113px;
	width: 1px; /*두께끝??감사합니다*/
	height: 95px; /*선길이*/
	background-color: #000;
	transform: rotate(45deg);
}

.xicon5 {
	position: absolute;
	top: -12px; /*위에서부터 */
	left: 192px; /*왼쪽으로부터 192px 위치*/
	width: 1px;
	height: 95px;
	background-color: #000;
	transform: rotate(-45deg); /*ㅇㅇㅇ여ㅑㅕ기가 회전해주는거*/
}

.xicon6 {
	position: absolute;
	top: -12px;
	left: 192px;
	width: 1px;
	height: 95px;
	background-color: #000;
	transform: rotate(45deg);
}

table {
	margin: 0 auto;
}

th {
	background-color: #ccc;
}
</style>

<script type="text/javascript">
	window.onload = function() {
		loaded();
	}
	var popupX = (window.screen.width / 2);

	var popupY= (window.screen.height /2) ;
	
	
	function send() {
	window.open('/approval/person', '_blank', 'status=no, height=500, width=500, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	}
	
	
	$(document).ready(function() {
	    $("#approveform").submit(function() {
	    	
	    	if(value==$("#title").val()){
	    		alert("제목을 입력하세요")

				$("#title").val("")
	    		return false
	    	}
	    	
	    	if(value==$("#content").val()){
	    		alert("내용을 입력하세요")

	    		$("#content").val("")
	    		
	    		return false
	    	}
	    	
	    })
	})
	
	
	
	
</script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js">
	
</script>



	<%String firstApproval=request.getParameter("firstApproval");
String secondApproval=request.getParameter("secondApproval");
String firstApprovalNo=request.getParameter("firstApprovalNo");
String secondApprovalNo=request.getParameter("secondApprovalNo"); %>


	
<div class="content-wrapper">
<%-- 		<jsp:include page="/views/common/topMenu.jsp"></jsp:include> --%>
<%-- 		<jsp:include page="/views/common/sideMenu.jsp"></jsp:include> --%>

		<main>

			<header>승인 작성 페이지입니다</header>

			<h3>업무 일지</h3>
			<form action="/approval/approvalWriteWork" method="post"
				id="approveform" name="approval_form" enctype="multipart/form-data">

				<select id="dimension" onchange="location.href=this.value">
					<option value="" selected disabled hidden>결재계 선택</option>


					<option value="/approval/approvalWrite">휴가계</option>
					<option value="/approval/approvalWriteWork">업무일지</option>

				</select>
				<div id="can">
					<div id="canvas1" class="canvas" style="border: 1px solid #000;"></div>
					<span class="xicon1 "></span> <span class="xicon2 "></span>

					<div id="canvas2" class="canvas" style="border: 1px solid #000;">
						<span id="1st">
							<%if(firstApproval!=null){ %> <%=firstApproval%>
							<%}%>
						</span>
					</div>
					<span class="xicon3 "></span> <span class="xicon4 "></span>


					<div id="canvas3" class="canvas" style="border: 1px solid #000;">
						<span id="2nd">
							<%if(secondApproval!=null){ %> <%=secondApproval%>
							<%}%>
						</span>
					</div>
					<span class="xicon5 "></span> <span class="xicon6 "></span>


					<button id="c3" type="button" value="button" onclick="send();">
						결재권자 추가</button>

				</div>
				<div>

					<table>
						<tr>
							<th>제목</th>
							<td><input type="text" id="title" name="title"
								placeholder="제목을 입력해주세요" /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea rows="20" cols="100" id="content"
									name="content" placeholder="내용 입력란"></textarea></td>
						</tr>
					</table>

				</div>
				<div>

					<br> <br> <label>파일 <input type="file"
						name="upfile" id="upfile" /></label><br> <br>
				</div>


				<div>

					<input type='hidden' name='firstApprovalNo'
						value='<%=firstApprovalNo %>' /> <input type='hidden'
						name='secondApprovalNo' value='<%=secondApprovalNo %>' />
				</div>
				<input type="hidden" name="form_name" value=""> <input
					type='submit' value='전송'>
			</form>

		</main>


	</div>
<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>