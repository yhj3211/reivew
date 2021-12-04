package com.yhj3211.review.user.bo;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhj3211.review.common.EncryptUtils;
import com.yhj3211.review.user.dao.UserDAO;
import com.yhj3211.review.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	//회원가입
	public int userSignUp(String name, String loginId, String password, String nickname, String email, String number, String birth) {
		
		String encPassword = EncryptUtils.md5(password);
		
		return userDAO.userSignUp(name, loginId, encPassword, nickname, email, number, birth);
	}
	
	//로그인
	public User userSignIn(String loginId, String password) {

		String encPassword = EncryptUtils.md5(password);
		
		return userDAO.userSignIn(loginId, encPassword);
	}
	
	//아이디 중복확인
	public int loginIdDup(String loginId) {
		return userDAO.loginIdDup(loginId);
	}
	
	//닉네임 중복확인
	public int nicknameDup(String nickname) {
		return userDAO.nicknameDup(nickname);
	}
	
}
