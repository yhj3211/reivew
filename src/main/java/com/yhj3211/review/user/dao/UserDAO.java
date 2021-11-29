package com.yhj3211.review.user.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.yhj3211.review.user.model.User;

@Repository
public interface UserDAO {

	//회원가입
	public int userSignUp(@RequestParam("name") String name,
						@RequestParam("loginId") String loginId,
						@RequestParam("password") String password,
						@RequestParam("email") String email,
						@RequestParam("number") String number,
						@RequestParam("birth") String birth);
	
	//로그인
	public User userSignIn(@RequestParam("loginId") String loginId,
						@RequestParam("password") String password);
}
