<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
   
<link rel="stylesheet" href="./resources/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/assets/css/font-awesome.min.css">
<link rel="stylesheet"
	href="./resources/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="./resources/assets/css/modal-video.min.css">
<link rel="stylesheet" href="./resources/assets/css/animate.css">
<link rel="stylesheet" href="./resources/assets/css/normalize.css">
<link rel="stylesheet" href="./resources/css/style.css">
<link rel="stylesheet" href="./resources/assets/css/responsive.css">
<link rel="stylesheet" href="./resources/css/studdype/mainsection.css">
<link rel="stylesheet" href="./resources/css/studdype/header&footer.css">
<link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<style type="text/css">
   #center{
      background-color:lightblue;
      background-image:url('./resources/assets/img/img_study8.png');/*임의 배경 설정 */
      width:100%;
      opacity:70%;
   }
   header{
      margin-left:45%;
      
   }
   #line1{
      margin-top:0.5%;
   }
   #line{
      margin-top:5%;
   }
   #title{
      margin-top:20%;
      margin-left:5%;
      color:white;
   }
   #btn{   
   
      margin-left:65%;
   }
   #img{
      height:50px;
      background-color:white;
      border-radius:60%;
      margin-left:5%;
   }
   #id{
      margin-left:220%;
      margin-top:10%;
      width:280px;
      height:50px;
   }
   #pw{
      margin-left:220%;
      width:280px;
      margin-top:10%;
      height:50px;
   }
   #login{
      margin-left:41%;
      margin-top:3%;
      width:260px;
      height:50px;
      background-color:purple;
      color:white;
      font-weight:bold;
      font-size:20px;
   }
   #email{
      margin-left:40%;
   }
   #foot{
      margin-left:1%;
   }
</style>
<script src="./resources/assets/js/jquery.3.2.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		// 해더 상단 영역 숨기기 (메뉴 넘어갈때는 이 코드 show()로 바꾸기)
		//$(".justify-content-center").hide(); 
		$(".justify-content-center").css({"background":"black"}); 
	})
function login_btn(){
	var form = $("#loginForm");
	var mem_id = $("#id");
	var mem_pw = $("#pw");
	
	if ( mem_id.val() == null || mem_id.val().trim() == ''){
		alert("아이디를 확인해 주세요.");
	}else if ( mem_pw.val() == null || mem_pw.val().trim() == '' ){
		alert("비밀번호를 확인해 주세요.");
	}else {
		form.submit();
	}
};


</script>
</head>
<body>
<jsp:include page="../commond/studdypeHeader.jsp"></jsp:include>

    <form id="loginForm" action="login.do" method="POST">
       <table>
          <tr>
             <td>
                <input type="text" name="mem_id" id="id" placeholder="아이디를 입력해주세요" style="border:2px solid #F5A9F2">
             </td>
          </tr>
          <br>
          <tr>
             <td>

                <input type="password" name="mem_pw" id="pw" placeholder="비밀번호를 입력해주세요" style="border:2px solid #F5A9F2">

             </td>
          </tr>
       
       </table>
    
       <input type="submit" onclick="login_btn();" value="LOGIN" id="login" style="border:0">

    
    
    </form>
    
    
   <br>
   <br>
   <a href="email.do" id="email" onClick="window.open(this.href,'','width=700, height=430'); return false;">아이디 계정찾기</a>
   <a href="pwd.do" id="pwd1" onClick="window.open(this.href,'','width=700, height=430'); return false;">비밀번호 찾기</a>
   <a href="signform.do" id="">회원가입</a>
   
	
	<jsp:include page="../commond/studdypeFooter.jsp"></jsp:include>

	<script src="./resources/assets/js/popper.min.js"></script>
	<script src="./resources/assets/js/bootstrap.min.js"></script>
	<script src="./resources/assets/js/owl.carousel.min.js"></script>
	<script src="./resources/assets/js/modal-video.js"></script>
	<script src="./resources/assets/js/loadmore.js"></script>
	<script src="./resources/assets/js/prefixfree.min.js"></script>
	<script src="./resources/assets/js/main.js"></script>

</body>
</html>