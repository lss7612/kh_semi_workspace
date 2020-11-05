<%@ page language="java" contentType="text/html; charset=EUC-KR"

	pageEncoding="UTF-8"%>
<%@page import="dto.appr.Appr"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%
	List<Appr> list = (List<Appr>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="/resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bbootstrap 4 -->
<link rel="stylesheet"
	href="/resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">

<!-- Theme style -->
<link rel="stylesheet" href="/resources/dist/css/adminlte.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="/resources/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="/resources/plugins/summernote/summernote-bs4.css">

<link rel="stylesheet" href="/resources/css/style.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/approval/myDetail" method="post">
		<div class="content-wrapper">


			<div class="card-body">
				<div class="row">
					<div class="col-md-6" data-select2-id="46">
						<div class="form-group"></div>

						<div class="form-group"></div>






						<table>
							<tr>
								<th>결재계</th>
								<td>
									<div class="form-group">
										<input type="text" name=aprvl_type id="aprvl_type"
											readonly="readonly" value="<%=list.get(0).getAprvl_type()%>" />
									</div>
								</td>

							</tr>

							<tr>
								<th>결재 상신일</th>
								<td>
									<div class="form-group">
										<input type="text" name="create_date" id="create_date"
											readonly="readonly" value="<%=list.get(0).getCreate_date()%>" />
									</div>
								</td>
								<th style="width:120px; text-align:center"><div class="form-group"> 결재일</div></th>
								<td>
									<div class="form-group">
										<input type="text" name="final_date" id="final_date"
											readonly="readonly" value="<%=list.get(0).getFinal_date()%>" />
									</div>
								</td>
							</tr>
							<tr>
								<th>결재번호</th>
								<td>
									<div class="form-group">
										<input type="number" name="aprvl_no" id="aprvl_no"
											readonly="readonly" value="<%=list.get(0).getApprl_no()%>" />
									</div>
								</td>
							</tr>
							<tr>
								<th>상신자</th>
								<td>
								<div class="form-group">
								<input type="text" name="user" id="user"
									readonly="readonly" value="<%=list.get(0).getUser_name()%>" />
								</div>
								</td>
								
								<th style="width:120px; text-align:center"><div class="form-group">  1차결재자</div></th>
								<td>
								<div class="form-group">
								
								<input type="text" name="mid_auth" id="mid_auth"
									readonly="readonly" value="<%=list.get(0).getMid_auth_name()%>" />
									</div>
									</td>
								<th style="width:120px; text-align:center"><div class="form-group">  2차결재자</div></th>
								<td>
								<div class="form-group">
								<input type="text" name="final_auth" id="final_auth"
									readonly="readonly"
									value="<%=list.get(0).getFinal_auth_name()%>" />
									</div>
									</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>
								<div class="form-group">
								<input type="text" name="aprvl_title" id="aprvl_title"
									readonly="readonly" value="<%=list.get(0).getAprvl_title()%>" />
									</div>
									</td>
							</tr>
							<tr>


								<th>내용</th>
								<td colspan="5">
								<div class="form-group">
								<textarea style="border-collapse: collapse;" rows="20"
										cols="80" name="aprvl_article" id="aprvl_article"
										readonly="readonly"
										placeholder="<%=list.get(0).getAprvl_article()%>"></textarea>
										</div>
										</td>
							</tr>
							<tr>
								
								<th>
								<div class="form-group">
								첨부파일<a class="btn"
									href="/upload/<%=list.get(0).getFile_name()%>" download><%=list.get(0).getFile_origin_name()%>
								</a>
								</div>
								</th>


							</tr>
						</table>

















						
						<!-- /.form-group -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
		</div>
		<input type="button" value="창닫기" onClick="window.close()">




	</form>
</body>
</html>