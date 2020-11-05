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
	width: 100%;
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
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>전자결재쓰기</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">결재함</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-3">
            <a href="mailbox.html" class="btn btn-primary btn-block mb-3">결재함으로 가기</a>
            
            
            <!-- 사이드에 넣을 카테고리지만 좌측 카테고리에 안넣고 이거써도 될거같은뎅???
            지울지 말지는 보고 결정하셔도 됨미다-->
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">결재 목록함</h3>

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i>
                  </button>
                </div>
              </div>
              <div class="card-body p-0">
                <ul class="nav nav-pills flex-column">
                  <li class="nav-item active">
                    <a href="/approval/approvalWrite" class="nav-link">
                      <i class="fas fa-inbox"></i> 결재작성                     	
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="/approval/approvalmy" class="nav-link">
                      <i class="fas fa-inbox"></i> 기안함
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="/approval/DoApproval" class="nav-link">
                      <i class="fas fa-inbox"></i> 결재함
                    </a>
                  </li>
                
                </ul>
              </div>
              <!-- /.card-body -->
            </div>
            
                  
            <!-- /.card -->
            
            <!-- //사이드에 넣을 카테고리지만 좌측 카테고리에 안넣고 이거써도 될거같은뎅???-->
    
          </div>
          <!-- /.col -->
          <div class="col-md-9">
            <div class="card card-primary card-outline">
             <!-- 헤더에 내용 -->
              <div class="card-header">
                <h3 class="card-title">기안함</h3>
              </div>
              
              
              
              <!-- /.card-header -->
              <div class="card-body">
              
              <div class="form-group">


			<main>

			<h3 style="text-align: center;">기안 목록</h3>

			<div class=dobutton>
				<button id="dobutton" type="button" onclick="location.href='/approval/countApproval?&a=2'" value="2">완결 문서</button>
				<button id="dobutton" type="button" onclick="location.href='/approval/countApproval?&a=3'" value="3">반려 문서</button>
				<button id="dobutton" type="button" onclick="location.href='/approval/countApproval?&a=1'" value="1">대기 문서</button>
				<button id="dobutton" type="button" onclick="location.href='/approval/countApproval?&a=4'" value="4">1차 승인 문서</button>
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
<!-- 					<th>버튼</th> -->
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

<!-- 					<td> -->
<%-- 					<a href=# name="modify" onclick="window.open('<%=result%>?num=<%=list.get(i).getAprvl_no()%>&type=<%=list.get(i).getAprvl_type()%>&title=<%=list.get(i).getAprvl_title() %>&content=<%=list.get(i).getAprvl_article()%>&','_blank','width=800,height=800'); return false;" >수정</a></td>				 --%>
<!-- 				</tr> -->
				<%}	%>
			</table>
			
			<div style="text-align : center;padding:50px 50px; width:400px;  margin: 0 auto;">
			<jsp:include page="/views/common/paging_appmy.jsp" />
			</div>
		</main>
	

            </div>             
       
               
           
                
                 <!-- 입력칸1 -->
  
                <!--// 내용칸 -->
                
                
                <!-- 파일첨부 -->
                
                
   
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
      				<div id="bot">
				<button  class="btn btn-default" onclick="location.href='/approval/approvalWrite' ">기안하기</button>
			
			</div>
              
                </div>
              <!-- /.card-footer -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>



<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>

