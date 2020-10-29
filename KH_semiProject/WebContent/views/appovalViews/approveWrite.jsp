<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<style type="text/css">
h3 {
	text-align: center;
}

#canvas1 {
	position: absolute;
}

#canvas2 {
	position: absolute;
	right: 50px;
}

#canvas3 {
	position: absolute;
	right: 150px;
}

#can {
	position: relative;
	padding-left: 0;
	padding-right: 0;
	margin-left: auto;
	margin-right: 200px;
	display: block;
	width: 40px;
	height: 100px;
}

#c {
	position: absolute;
	background-color: transparent;
	width: 70px;
	height: 70px;
}

#c2 {
	position: absolute;
	background-color: transparent;
	width: 70px;
	height: 70px;
	right: 50px;
}

#c3 {
	position: absolute;
	right: -130px;
	width: 70px;
	height: 70px;
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
	function loaded() {

		var canvas = document.getElementById("canvas1");
		var context = canvas.getContext('2d');
		var canvas2 = document.getElementById("canvas2");
		var context2 = canvas2.getContext('2d');

		var canvas3 = document.getElementById("canvas3");
		var context3 = canvas3.getContext('2d');

		console.log(context)
		context.beginPath();
		context.moveTo(0, 0);
		context.lineTo(70, 70);
		context.stroke();
		context.moveTo(70, 0);
		context.lineTo(0, 70);
		context.stroke();

		context2.beginPath();
		context2.moveTo(0, 0);
		context2.lineTo(70, 70);
		context2.stroke();
		context2.moveTo(70, 0);
		context2.lineTo(0, 70);
		context2.stroke();

		context3.beginPath();
		context3.moveTo(0, 0);
		context3.lineTo(70, 70);
		context3.stroke();
		context3.moveTo(70, 0);
		context3.lineTo(0, 70);
		context3.stroke();
	}
	
	window.screen.width 
	window.screen.height 
	var popupX = (window.screen.width / 2) - (200 / 2);
	// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음
	var popupY= (window.screen.height /2) - (300 / 2);
	// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
	
	function send() {
	window.open('/views/appovalViews/jquery-treeview/demo/images.html', '_blank', 'status=no, height=500, width=500, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	}
	
	$(document).ready(function() {
	    $("#approveform").submit(function() {
	    	
	    	console.log($("#one").val())
	    	console.log("start 값 : " + $("#start").val())
		//타이틀 빈값 체크
	    	console.log($("#title").val());
	    	var value = ""
	    	var day="0000-00-00"
	    	var time="00:00"
	    	
	    	
	    	
	        	if($("#start").val()==0 ){
		    		alert("날짜를 선택하세요")

		    		
		    		return false
		    	}
		    	
		    	if($("#end").val()==0){
		    		alert("날짜를 선택하세요")
		    		
		    		return false
		    	}

		    
			    	if( !$("input:radio[id='one']").is(":checked")){
			    	
			    	
				    	if(time==$("#start_time").val()){
				    		alert("시간을 선택하세요")
			
				 
				    		
				    		return false
				    	}
				    	if(time==$("#end_time").val()){
				    		alert("시간을 선택하세요")
			
// 				    		$("#end_time").val("")
				    		
				    		return false
				    	}
			    
			    	}
		    	
		    	
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

			 var fileCheck = document.getElementById("upfile").value;
		    console.log(fileCheck);
		    
		    if(!fileCheck){
		        alert("파일을 첨부해 주세요");
		        return false;
		    }
	    	
	    })
	
	  
	    
	})
	


</script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js">
	
</script>

</head>
<body>






	<div class="container">
		<jsp:include page="/views/common/topMenu.jsp"></jsp:include>
		<jsp:include page="/views/common/sideMenu.jsp"></jsp:include>

		<main>

			<h3>연차 휴가계</h3>
			<form action="/approval/approvalWrite" method="post" id="approveform"
				name="approval_form" enctype="multipart/form-data">


				<select id="dimension" onchange="location.href=this.value">
					<option value="" selected disabled hidden>결재계 선택</option>
					<option value="/approval/approvalWrite">휴가계</option>
					<option value="/approval/approvalWriteWork">업무일지</option>
				</select>
				<div id="can">
					<canvas id="canvas1" width="70" height="70"
						style="border: 1px solid #000;"></canvas>
				
					<canvas id="canvas2" width="70" height="70"
						style="border: 1px solid #000;"></canvas>
					<canvas id="canvas3" width="70" height="70"
						style="border: 1px solid #000;"></canvas>
				

					<button id="c3" type="button" value="button" onclick="send();">결재권자
						추가</button>



				</div>





				<p></p>

				<div>

					<table>
						<tr>
							<th>휴가종류</th>
							<td><label for="one"> <input type="radio" name="r"
									checked="checked" value="연차휴가" id="one" />연차휴가

							</label> <label for="two"> <input type="radio" name="r"
									value="조퇴" id="two" />조퇴
							</label> <label for="three"> <input type="radio" name="r"
									value="반차" id="three" />반차
							</label></td>
						</tr>
						<tr>
							<th>기간</th>
							<td><input type='date' id="start" name='startday'
								value="0000-00-00" min="0000-00-0" max="2021-12-31" /> <input
								type="time" id="start_time" value="00:00" min="00:00"
								max="23:59" name='start_time'> <input type='date'
								name='endday' value="0000-00-00" id="end" /> <input type="time"
								id="end_time" value="00:00" min="00:00" max="23:59"
								name='end_time'></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" id="title"
								style="width: 99%" /></td>
						</tr>
						<tr>
							<th>사유</th>
							<td><textarea rows="20" cols="100" name="reason"
									id="content"></textarea></td>
						</tr>
					</table>

				</div>
				<div>

					<br> <br> <label>파일 <input type="file"
						name="upfile" id="upfile"/></label><br> <br>
				</div>

				<input type="hidden" name="form_name" value=""> <input
					type='submit' value='전송'>
			</form>




		</main>

		<jsp:include page="/views/common/footer.jsp"></jsp:include>
	</div>

</body>
</html>