<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="dto.appr.ApprMy"%>

<%@page import="java.util.List"%>
<%
	List<ApprMy> list = (List<ApprMy>) request.getAttribute("list");
%>
<%  
String holi = "/approvalMy/modHoly";
String work = "/approvalMy/mod";
%>
<jsp:include page="/views/common/headerKKH.jsp"></jsp:include>

<style>
table {
	border-top: 2px solid;
	border-color: #ccc;
	margin: 0 auto;
	width: 80%;
}

.dobutton {
	text-align: center;
	margin-bottom: 10px;
}

#dobutton {
	width: 130px;
	height: 50px;
}

#bot :first-child {
	margin-left: 10%
}
</style>
<script type="text/javascript">





$(document).ready(function() {
    $("#approveform").submit(function() {
	
    })

})
</script>


	
<div class="content-wrapper">
		

<%-- 		<jsp:include page="/views/common/sideMenu.jsp"></jsp:include> --%>
		<main>

			<h3 style="text-align: center;">기안함</h3>

			<div class=dobutton>
				<button id="dobutton">승인 문서 3</button>
				<button id="dobutton">반려 문서 1</button>
			</div>


			<table>
				<tr>
<!-- 					<th><label>전체선택<input type="checkbox" name="color" -->
<!-- 							value="blue"> -->
<!-- 					</label></th> -->
					<th>이름</th>
					<th>부서</th>
					<th>직급</th>
					<th>결재 제목</th>
					<th>결재계</th>
					<th>상신일</th>
					<th>결재상태</th>
					<th>결재 일시</th>
					<th>버튼</th>
				</tr>
				
				
				<!-- 결재 목록 -->
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				
				<tr>
				
<!-- 					<td><input type="checkbox" name="color" value="blue"></td> -->
					<td><%=list.get(i).getUser_name() %></td>
					<td><%=list.get(i).getDept_name() %></td>
					<td><%=list.get(i).getPosition_name() %></td>
					<td><a href='#' onclick="window.open('/approval/myDetail?a=<%=list.get(i).getAprvl_no()%>&b=<%=list.get(i).getAprvl_type() %>','_blank','width=800,height=800'); return false;" id=<%=i%> name=<%=list.get(i).getAprvl_no() %>><%=list.get(i).getAprvl_title() %></a></td>
					<td><%=list.get(i).getAprvl_type() %></td>
					<td><%=list.get(i).getCreate_date() %></td>
					<td><%=list.get(i).getState_name() %></td>
					<td><%=list.get(i).getFinal_date() %></td>
					<% String result=work; 
					System.out.println("휴가계맞니??"+list.get(i).getAprvl_type());
					String kk= list.get(i).getAprvl_type();
					if(kk.equals("휴가계"))%><%{  %>
					<%  result=holi; 
					System.out.println(result);
					%>
					<% }%>

					<td>
					<a href=# name="modify" onclick="window.open('<%=result%>?num=<%=list.get(i).getAprvl_no()%>&type=<%=list.get(i).getAprvl_type()%>&title=<%=list.get(i).getAprvl_title() %>&content=<%=list.get(i).getAprvl_article()%>&','_blank','width=800,height=800'); return false;" >수정</a></td>				
				</tr>
				<%}	%>
			</table>
			<div id="bot">
				<button>기안하기</button>
				<button>삭제</button>
			</div>
			<div>
			<jsp:include page="/views/common/paging.jsp" />
			</div>
		</main>
	

	</div>



<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>

