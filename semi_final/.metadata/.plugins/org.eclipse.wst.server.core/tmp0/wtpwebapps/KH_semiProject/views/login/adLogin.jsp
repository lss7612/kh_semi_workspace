<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page errorPage ="/views/common/errorpage.jsp" %>
    

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>일조 그룹웨어 관리자 로그인</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/dist/css/adminlte.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    
  
<%        
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private");
    response.setDateHeader("Expires", -1);
%>
  
    

    
  <script type="text/javascript">
  
  function loginOk() {

	  var f = document.loginForm;


	  if(!f.user_id.value) {

	  alert("아이디를 입력해라");

	  f.user_id.focus();

	  return false;

	  }


	  if(!f.user_pw.value) {

	  alert("비밀번호를 입력해라");

	  f.user_pw.focus();

	  return false;

	  }

	  f.submit();

	  }

  
  </script>
  
     <script type="text/javascript">
 window.history.forward();
 function noBack(){window.history.forward();}
</script>

  
  
</head>
<body class="hold-transition login-page" onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">

<div class="login-box">
  <div class="login-logo">
     <img src="/resources/images/biglogo.png" />
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sign in to start your session</p>

      <form action="<%=request.getContextPath()%>/Login/adLogin" method="post"  name="adLoginForm" >
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="아이디" id="user_id" name="user_id" autofocus onkeypress="if(event.keyCode == 13){ loginOk(); return false;}" >
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
         
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="비밀번호"  id="user_pw" name="user_pw" onkeypress="if(event.keyCode == 13){ loginOk(); return false;}">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        
        <!-- 로그인 실패시 메세지 -->
			  <!-- param.변수 => request.getParameter("변수") -->
			  <span style="color: red;">${param.message}</span>
        <div class="row">
       
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block" />로그인</button>
          </div>
          <!-- /.col -->
        </div>
      </form>
		
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="/resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/dist/js/adminlte.min.js"></script>
</body>
</html>
