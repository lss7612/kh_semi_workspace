<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/views/common/headerKKH.jsp" />



<style type="text/css">

.cal_top{
    text-align: center;
    font-size: 30px;
  
    text-align : center;
    margin:  0 auto;
}

#sh{

    font-size: 20px;
    margin:  0 auto;
}

.cal{
    text-align: center;    
}
table.calendar{
    border: 1px solid black;
    display: inline-table;
    text-align: left;
}
table.calendar td{
    vertical-align: top;
    border: 1px solid skyblue;
    width: 100px;
}


.modal_wrap{
        display: none;
        width: 500px;
        height: 500px;
        position: absolute;
        top:50%;
        left: 50%;
        margin: -250px 0 0 -250px;
        background:#eee;
        z-index: 2;
    }
    .black_bg{
        display: none;
        position: absolute;
        content: "";
        width: 100%;
        height: 100%;
        background-color:rgba(0, 0,0, 0.5);
        top:0;
        left: 0;
        z-index: 1;
    }
    .modal_close{
        width: 26px;
        height: 26px;
        position: absolute;
        top: -30px;
        right: 0;
    }
    .modal_close> a{
        display: block;
        width: 100%;
        height: 100%;
   	   background:url(https://img.icons8.com/metro/26/000000/close-window.png);
        text-indent: -9999px;
    }


</style>



<script type="text/javascript">

window.onload = function() {

function onClick() {
    document.querySelector('.modal_wrap').style.display ='block';
    document.querySelector('.black_bg').style.display ='block';
}   
function offClick() {
    document.querySelector('.modal_wrap').style.display ='none';
    document.querySelector('.black_bg').style.display ='none';
}

document.getElementById('modal_btn').addEventListener('click', onClick);
document.querySelector('.modal_close').addEventListener('click', offClick);

};
</script>


</head>
<body>



    <div class="cal_top"> 
        <a href="#" id="movePrevMonth"><span id="prevMonth" class="cal_tit">&lt;</span></a>
        <span id="cal_top_year"></span>
        <span id="cal_top_month"></span>
        <a href="#" id="moveNextMonth"><span id="nextMonth" class="cal_tit">&gt;</span></a>
     <button type='button' id="modal_btn">스케줄 입력</button>
	
		
        
    
    </div>
    <div id="cal_tab" class="cal">
    </div>
    
   
     
	<div class="black_bg"></div>
	<div class="modal_wrap">
    	<div class="modal_close"><a href="#">close</a></div>
    	
    	<!-- 스케줄 모달창 이름 -->
    	<div>
  		스케줄 입력
    	</div><br>
    	<!-- 스케줄 입력 모달창 시작 -->
    	
    	스케줄 타입
    	<br>
		<input type="radio" name="type" value="개인">개인
		<input type="radio" name="type" value="공유">공유
		<hr>
    	
    	스케줄 이름
    	<br>
		<input type="text" >
		<hr>
    	
    	스케줄 내용
    	<br>
		<input type="text" >
		<hr>
    	
    	   스케줄 시작 일자<br>
		<input type="date" name="d"value="2020-10-01"/>
		<hr>

		   스케줄 종료 일자<br>
		<input type="date" name="d"value="2020-10-01"/><br><br>
		
	
		<button type="submit" value="입력 완료">입력완료 </button>

			
    	</div>
		<div>
    	<div>
    
    
	    
    
 <br><br>
 
<script type="text/javascript">
    
    var today = null;
    var year = null;
    var month = null;
    var firstDay = null;
    var lastDay = null;
    var $tdDay = null;
    var $tdSche = null;
 
    $(document).ready(function() {
        drawCalendar();
        initDate();
        drawDays();
        $("#movePrevMonth").on("click", function(){movePrevMonth();});
        $("#moveNextMonth").on("click", function(){moveNextMonth();});
    });
    
    //calendar 그리기
    function drawCalendar(){
        var setTableHTML = "";
        setTableHTML+='<table class="calendar">';
        setTableHTML+='<tr><th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th></tr>';
        for(var i=0;i<6;i++){
            setTableHTML+='<tr height="100">';
            for(var j=0;j<7;j++){
                setTableHTML+='<td style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">';
                setTableHTML+='    <div class="cal-day"></div>';
                setTableHTML+='    <div class="cal-schedule"></div>';
                setTableHTML+='</td>';
            }
            setTableHTML+='</tr>';
        }
        setTableHTML+='</table>';
        $("#cal_tab").html(setTableHTML);
    }
 
    //날짜 초기화
    function initDate(){
        $tdDay = $("td div.cal-day")
        $tdSche = $("td div.cal-schedule")
        dayCount = 0;
        today = new Date();
        year = today.getFullYear();
        month = today.getMonth()+1;
        firstDay = new Date(year,month-1,1);
        lastDay = new Date(year,month,0);
    }
    
    //calendar 날짜표시
    function drawDays(){
        $("#cal_top_year").text(year);
        $("#cal_top_month").text(month);
        for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
            $tdDay.eq(i).text(++dayCount);
        }
        for(var i=0;i<42;i+=7){
            $tdDay.eq(i).css("color","red");
        }
        for(var i=6;i<42;i+=7){
            $tdDay.eq(i).css("color","blue");
        }
    }
 
    //calendar 월 이동
    function movePrevMonth(){
        month--;
        if(month<=0){
            month=12;
            year--;
        }
        if(month<10){
            month=String("0"+month);
        }
        getNewInfo();
        }
    
    function moveNextMonth(){
        month++;
        if(month>12){
            month=1;
            year++;
        }
        if(month<10){
            month=String("0"+month);
        }
        getNewInfo();
    }

    
    function getNewInfo(){
        for(var i=0;i<42;i++){
            $tdDay.eq(i).text("");
        }
        dayCount=0;
        firstDay = new Date(year,month-1,1);
        lastDay = new Date(year,month,0);
        drawDays();
    }
</script>

    
    
    <jsp:include page="/views/common/footerKKH.jsp" />
