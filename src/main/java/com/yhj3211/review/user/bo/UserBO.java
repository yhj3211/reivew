package com.yhj3211.review.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhj3211.review.user.dao.UserDAO;
import com.yhj3211.review.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	//회원가입
	public int signUp(String name, String loginId, String password, String email, String number, String birth) {
		return userDAO.userSignUp(name, loginId, password, email, number, birth);
	}
	
	//로그인
	public User signIn(String loginId, String password) {
		return userDAO.userSignIn(loginId, password);
	}
}
