package com.yhj3211.review.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yhj3211.review.user.bo.UserBO;
import com.yhj3211.review.user.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	//회원가입
	@PostMapping("/signUp")
	public Map<String, String> signUp(@RequestParam("name") String name,
										@RequestParam("loginId") String loginId,
										@RequestParam("password") String password,
										@RequestParam("nickname") String nickname,
										@RequestParam("email") String email,
										@RequestParam("number") String number,
										@RequestParam("birth") String birth){
		
		Map<String, String> result = new HashMap<>();
		
		int count = userBO.userSignUp(name, loginId, password, nickname, email, number, birth);
		
		if(count > 0) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		return result;
	}
	
	//로그인
	@PostMapping("/signIn")
	public Map<String, Object> signIn(@RequestParam("loginId") String loginId,
										@RequestParam("password") String password,
										HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		Map<String, Object> result = new HashMap<>();
		
		User user = userBO.userSignIn(loginId, password);
		
		if(user != null) {
			session.setAttribute("nickname", user.getNickname());
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			result.put("result", "success");
		
		}else {
			result.put("result", "fail");
		}
		return result;
	}
	
	//아이디 중복확인
	@GetMapping("loginIdDup")
	public Map<String, String> loginIdDup(@RequestParam("loginId") String loginId){
		Map<String, String> result = new HashMap<>();
		
		int count = userBO.loginIdDup(loginId);
		if(count > 0) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		return result;
	}
	
	//닉네임 중복확인
	@GetMapping("nicknameDup")
	public Map<String, String> nicknameDup(@RequestParam("nickname") String nickname){
		
		Map<String, String> result = new HashMap<>();
		
		int count = userBO.nicknameDup(nickname);
		
		if(count > 0) {
			result.put("result", "success");		
		}else {
			result.put("result", "fail");
		}
		return result;
	}
	
}
