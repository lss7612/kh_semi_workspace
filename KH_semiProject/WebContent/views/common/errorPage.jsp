<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류가 발생 했다</title>
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
    
</head>
<body>

<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
     <img src="/resources/images/biglogo.png" />
  </div>
  <!-- /.login-logo -->
  
  <div class="card">
    <div class="card-body login-card-body">
    <br>
    <h1 style="text-align:center;"><%=exception %></h1>
      <p class="login-box-msg" style="font-weight:bold;">현재 개발중 임미다 기다리세요..</p>
  </div>
  
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


</body>
</html>

<%--
<%@ page errorPage ="/error" %>
 --%>