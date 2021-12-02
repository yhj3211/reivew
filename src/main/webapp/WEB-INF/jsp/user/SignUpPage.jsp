<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
	
	<div id="wrap" class="container">
	
		<section class="d-flex justify-content-center">
			<div class="signup-box d-flex align-items-center">
				<div class="w-100">
					<h2 class="text-center">회원가입</h2>
					<div class="text-center"><small class="text-center"><a href="/user/signInPage">로그인 화면으로 돌아가기</a></small></div>
					
					<hr>
					
					
					<div class="d-flex align-items-center">
						<input type="text" id="loginIdInput" class="form-control mt-3 mr-3" placeholder="아이디">
						<button type="submit" id="idCheck" class="btn btn-info mt-3">중복체크</button>
					</div>
					
					<div>
						<small id="Dupfalse" class="d-none">회원가입 가능한 ID입니다.</small>	
						<small id="Duptrue" class="d-none">중복된 아이디입니다.</small>			
					</div>
					
						<input type="password" id="passwordInput" class="form-control mt-3" placeholder="패스워드">
						<small id="errorPassword" class="text-danger d-none">비밀번호가 일치하지 않습니다.</small>
						<input type="text" id="nicknameInput" class="form-control mt-3" placeholder="닉네임">
						<input type="text" id="birthInput" class="form-control mt-3" placeholder="생년월일">
						<input type="text" id="numberInput" class="form-control mt-3" placeholder="번호">
						<input type="text" id="nameInput" class="form-control mt-3" placeholder="이름">
						<input type="text" id="emailInput" class="form-control mt-3" placeholder="이메일">
						
						<button type="submit" id="signUpBtn" class="btn btn-info btn-block mt-3">회원가입</button>
						
				</div>
			</div>
		</section>
		
	<script>
		$("#signUpBtn").on("click", function(){
			var loginId = $("#loginIdInput").val();
			var password = $("#passwordInput").val();
			var nickname = $("#nicknameInput").val();
			var name = $("#nameInput").val();
			var email = $("#emailInput").val();
			var number = $("#numberInput").val();
			var birth = $("#birthInput").val();
			var isDup = true;
			
			if($("#Dupfalse").hasClass("d-none")){
				isDup = true;
			}
			
			if($("#Duptrue").hasClass("d-none")){
				isDup = false;
			}
			
			if(isDup == true){
				alert("아이디 중복확인을 해주세요");
				return;
			}
			
			if(loginId == "" || loginId == null){
				alert("아이디를 입력하세요");
				return;
			}
			
			if(password == "" || password == null){
				alert("패스워드를 입력하세요");
				return;
			}
			
			if(name == "" || name == null){
				alert("이름을 입력하세요");
				return;
			}
			
			if(nickname == "" || nickname == null){
				alert("닉네임을 입력하세요");
				return;
			}
			
			if(email == "" || email == null){
				alert("이메일을 입력하세요");
				return;
			}
			
			if(birth == "" || birth == null){
				alert("생년월일을 입력하세요");
				return;
			}
			
			if(number == "" || number == null){
				alert("전화번호를 입력하세요");
				return;
			}
			
			$.ajax({
				type:"post",
				url:"/user/signUp",
				data:{"name":name, "loginId":loginId, "password":password, "nickname":nickname, "email":email, "number":number, "birth":birth},
				success:function(data){
					if(data.result == "success"){
						alert("회원가입에 성공했습니다");
						location.href="/user/signInPage";
					}else{
						alert("회원가입에 실패했습니다");
						return;
					}
				},error:function(e){
					alert("시스템 에러");	
				}
				
			});
		});
			
		$("#idCheck").on("click", function(){
			var isDup = true;
			var loginId = $("#loginIdInput").val();
			
			if(loginId == "" || loginId == null){
				alert("아이디를 입력해주세요");
				return;
			}
			
			$.ajax({
				type:"get",
				url:"/user/loginIdDup",
				data:{"loginId":loginId},
				success:function(data){
					//중복된 상태
					if(data.result == "success"){
						$("#Duptrue").removeClass("d-none");
						$("#Dupfalse").addClass("d-none");
						alert("중복된 아이디입니다");
						return;
						idDup = true;
					}else{
						$("#Dupfalse").removeClass("d-none");
						$("#Duptrue").addClass("d-none");
						idDup = false;
					}
				},error:function(e){
					alert("시스템 에러");
				}
			});
		});
	</script>
	
	
	</div>
</body>
</html>