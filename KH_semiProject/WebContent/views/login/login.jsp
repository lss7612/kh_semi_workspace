<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="/error" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>일조 그룹웨어 로그인</title>
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

  
  
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
     <img src="/resources/images/biglogo.png" />
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sign in to start your session</p>

      <form action="/Login/login" method="post"  name="loginForm">
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="아이디" id="user_id" name="user_id" autofocus onkeypress="if(event.keyCode == 13){ loginOk(); return false;}" >
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
          <div style="margin:5px 0px;"> @일조.kr </div> 
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
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="remember">
              <label for="remember">
                언젠가는 되겠지.......
              </label>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block" />로그인</button>
          </div>
          <!-- /.col -->
        </div>
      </form>
		
		<p class="mb-1">
        <a href="findId">아이디 찾기</a>
      </p>
      <p class="mb-1">
        <a href="findPw">비밀번호 찾기</a>
      </p>
      <p class="mb-0">
        <a href="/register/register" class="text-center">회원가입하기</a>
      </p>
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
