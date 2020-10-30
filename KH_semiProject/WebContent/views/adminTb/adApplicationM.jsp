<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<jsp:include page="/views/common/adHeaderKKH.jsp" />

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
<!-- content-header -->
<div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">가입승인 페이지</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">회원관리</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
  <!-- //content-header -->
  
  

 <!-- Main content -->
    <section class="content">
      <div class="container-fluid">

<div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Responsive Hover Table</h3>
                
                
                

                <div class="card-tools">
                <div class="col-sm-10">
                
              
                    <div class="col-sm-10">
                      <!-- checkbox -->
                      <div class="form-group">
                        <div class="form-check">
                          
                          <label class="form-check-label"><input class="form-check-input" type="checkbox" checked />활성화 계정</label>
                        </div>
                        <div class="form-check">
                          
                          <label class="form-check-label"><input class="form-check-input" type="checkbox" checked />비활성화 계정</label>
                        </div>
                 
                      </div>
                    </div> 
                
                
                      <!-- select -->
                      <div class="form-group float-right selright">
                        <select class="form-control">
                          <option>전체</option>
                          <option>이름</option>
                          <option>아이디</option>
                        </select>
                      </div>
                    </div>
                    
                    
                
                
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">
			
                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>User</th>
                      <th>Date</th>
                      <th>Status</th>
                      <th>Reason</th>
                      <th><label class="mch"><input type="checkbox"/></label></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>183</td>
                      <td>John Doe</td>
                      <td>11-7-2014</td>
                      <td><span class="tag tag-success">Approved</span></td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                      <td><label class="mch"><input type="checkbox"/></label></td>
                    </tr>
                    <tr>
                      <td>219</td>
                      <td>Alexander Pierce</td>
                      <td>11-7-2014</td>
                      <td><span class="tag tag-warning">Pending</span></td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                      <td><label class="mch"><input type="checkbox"/></label></td>
                    </tr>
                    <tr>
                      <td>657</td>
                      <td>Bob Doe</td>
                      <td>11-7-2014</td>
                      <td><span class="tag tag-primary">Approved</span></td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                      <td><label class="mch"><input type="checkbox"/></label></td>
                    </tr>
                    <tr>
                      <td>175</td>
                      <td>Mike Doe</td>
                      <td>11-7-2014</td>
                      <td><span class="tag tag-danger">Denied</span></td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                      <td><label class="mch"><input type="checkbox"/></label></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
              
              <div class="btfloat">
              <button type="button" class="btn btn-primary col-1">삭제</button>
             
              
     
            
           
              <button type="button" class="btn  btn-primary col-1">숨김</button>
               </div>
             
              
                <div class="card-footer clearfix" style="margin:0 auto;">
                <ul class="pagination pagination-sm m-0" >
                  <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">4</a></li>
                  <li class="page-item"><a class="page-link" href="#">5</a></li>
                  <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                </ul>
              </div>
            </div>
            <!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
        
        </div>
        </section>
   </div><!-- //Content Wrapper. Contains page content -->
    
    
    <jsp:include page="/views/common/adFooterKKH.jsp" />