<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page errorPage ="/error" %>

<jsp:include page="/views/common/adHeaderKKH.jsp" />

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
<!-- content-header -->
<div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">회원정보 수정</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">회원정보 수정</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
  <!-- //content-header -->
  
  
 
  
  <section class="content" style="padding-bottom:50px;"> <!-- content -->
  
  
    <div class="card-body register-card-body">
    

      <form action="#로그인페이지" method="post">
      
       <div class="input-group mb-3">
      
         <div class="text-left" >
             <p>프로필에 보여질 사진과 문구를 수정해주세요.</p>
       
                  <img class="profile-user-img img-fluid img-circle" src="/resources/dist/img/user4-128x128.jpg" alt="사용자 프로필 사진">
            </div>
         
                     
        </div>
        
        <div class="input-group mb-3">
        <input  type="text"  class="form-control" placeholder="20자 이내로 적어주세요">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="far fa-file-alt"></span>
          </div> 
                </div>           
        </div>
      
      <div class="input-group mb-3">
          <input type="email" class="form-control" placeholder="아이디" >
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
          <div style="margin:5px 0px;"> @일조.kr </div> 
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="비밀번호">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="비밀번호 확인">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="이름">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="주민등록번호">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="far fa-address-card"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input  type="text"  class="form-control" placeholder="핸드폰번호">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-mobile-alt"></span>
            </div>
          </div>
        </div>
         <div class="input-group mb-3">
          <input  type="text"  class="form-control" placeholder="우편번호">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-map-marker-alt"></span>
            </div>
          </div>
          <div class="col-4">
           <button type="button" class="btn btn-primary btn-block">주소검색</button>
           </div>
           
        </div>
        
        <div class="input-group mb-3">
          <input  type="text"  class="form-control" placeholder="주소"> 
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-map-marker-alt"></span>
            </div>
          </div>          
        </div>
        
        <div class="input-group mb-3">
          <input  type="text"  class="form-control" placeholder="상세주소">  
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-map-marker-alt"></span>
            </div>
          </div>     
        </div>
        
       
        
        <div class="row">
          <!-- /.col -->
          <div class="col-3 " style="margin:0 auto;">
            <button type="submit" class="btn btn-primary btn-block">수정하기</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

     <%--  <div class="social-auth-links text-center">
        <p>- OR -</p>
        <a href="#" class="btn btn-block btn-primary">
          <i class="fab fa-facebook mr-2"></i>
          Sign up using Facebook
        </a>
        <a href="#" class="btn btn-block btn-danger">
          <i class="fab fa-google-plus mr-2"></i>
          Sign up using Google+
        </a>
      </div>
      --%>
	<br>
      
    </div>
    <!-- /.form-box -->

  	
  
    </section><!-- //content -->
    
    
  
  
   
   </div><!-- //Content Wrapper. Contains page content -->
    
    
    <jsp:include page="/views/common/adFooterKKH.jsp" />
