<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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

   #can{
      position:relative;
          float:right;
           
      }
      
       .canvas{
          
     display:inline-block;
           width:70px;
           height:70px;
           text-align: center;
           vertical-align: middle;
           
 }
      
      .canvas > span{
          
          display:inline-block;
          vertical-align:text-top;
          
          margin:15px 0;
          
      }
      

      
      /********************************X표시************************/
      .xicon1  {
position:absolute;
          top:-12px;
          left:36px;
  width: 1px;
  height: 95px;
  background-color: #000;
  transform: rotate(-45deg);
}
           .xicon2  {
position:absolute;
          top:-12px;
          left:36px;
  width: 1px;
  height: 95px;
  background-color: #000;
  transform: rotate(45deg);
}

      
            .xicon3  {
position:absolute;
          top:-12px;
          left:113px;
  width: 1px;
  height: 95px;
  background-color: #000;
  transform: rotate(-45deg);
}
           .xicon4  {
position:absolute;
          top:-12px;
          left:113px;
  width: 1px;/*두께끝??감사합니다*/
  height: 95px;/*선길이*/
  background-color: #000;
  transform: rotate(45deg);
}
      
                  .xicon5  {
position:absolute;
          top:-12px; /*위에서부터 */
          left:192px;/*왼쪽으로부터 192px 위치*/
  width: 1px;
  height: 95px;
  background-color: #000;
  transform: rotate(-45deg); /*ㅇㅇㅇ여ㅑㅕ기가 회전해주는거*/
}
           .xicon6  {
position:absolute;
          top:-12px;
          left:192px;
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
	

	var popupX = (window.screen.width / 2);

	var popupY= (window.screen.height /2) ;
	
	
	function send() {
	window.open('/approval/person', '_blank', 'status=no, height=500, width=500, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
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
	    	
		    alert("전송완료!!")
		    
	    })
	
	  
	    
	})
	


</script>


	<%
	
	String firstApproval=request.getParameter("firstApproval");
	String secondApproval=request.getParameter("secondApproval");
	String firstApprovalNo=request.getParameter("firstApprovalNo");
	String secondApprovalNo=request.getParameter("secondApprovalNo");
	
	
	System.out.println(firstApproval);
	System.out.println(secondApproval);
	System.out.println(firstApprovalNo);
	System.out.println(secondApprovalNo);
	%>



<jsp:include page="/views/common/headerKKH.jsp"></jsp:include>

	<div class="content-wrapper">
<%-- 		<jsp:include page="/views/common/topMenu.jsp"></jsp:include> --%>
<%-- 		<jsp:include page="/views/common/sideMenu.jsp"></jsp:include> --%>

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
               <div id="canvas1"  class="canvas"
                  style="border: 1px solid #000;"></div>
                  <span class="xicon1 "></span>
                  <span class="xicon2 "></span>
            
               <div id="canvas2"  class="canvas"
                  style="border: 1px solid #000;"><span id="1st"><%if(firstApproval!=null){ %> <%=firstApproval%><%}%></span></div>
                   <span class="xicon3 "></span>
                  <span class="xicon4 "></span>
                  
                  
               <div id="canvas3" class="canvas"
                  style="border: 1px solid #000;"><span id="2nd"><%if(secondApproval!=null){ %> <%=secondApproval%><%}%></span></div>
                 <span class="xicon5 "></span>
                  <span class="xicon6 "></span>
                  

               <button id="c3" type="button" value="button" onclick="send();">
                 결재권자 추가</button>

            </div>
<!-- 				<div id="can"> -->
<!-- 					<canvas id="canvas1" width="70" height="70" -->
<!-- 						style="border: 1px solid #000;"></canvas> -->
						
				
<!-- 					<canvas id="canvas2" width="70" height="70" -->
<!-- 						style="border: 1px solid #000;"></canvas> -->
<%-- 						<div id="1st"><span><%if(firstApproval!=null){ %> <%=firstApproval%><%}%></span></div> --%>
						
<!-- 					<canvas id="canvas3" width="70" height="70" -->
<!-- 						style="border: 1px solid #000;"></canvas> -->
<%-- 						<div id="2nd"><span><%if(secondApproval!=null){ %> <%=secondApproval%><%}%></span></div> --%>

<!-- 					<button id="c3" type="button" value="button" onclick="send();">결재권자 -->
<!-- 						추가</button> -->

<!-- 				</div> -->








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

				<div>

				<input type='hidden' name='firstApprovalNo' value='<%=firstApprovalNo %>' />
				<input type='hidden' name='secondApprovalNo' value='<%=secondApprovalNo %>' />
				</div>
				<input type="hidden" name="form_name" value=""> <input
					type='submit' value='전송'>
			</form>




		</main>

	
	</div>
	
	<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>
