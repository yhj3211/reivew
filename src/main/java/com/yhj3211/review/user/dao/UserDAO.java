package com.yhj3211.review.user.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yhj3211.review.user.model.User;

@Repository
public interface UserDAO {

	//회원가입
	public int userSignUp(@Param("name") String name,
							@Param("loginId") String loginId,
							@Param("password") String password,
							@Param("nickname") String nickname,
							@Param("email") String email,
							@Param("number") String number,
							@Param("birth") String birth);
	
	//로그인
	public User userSignIn(@Param("loginId") String loginId,
							@Param("password") String password);
	
	//아이디 중복확인
	public int loginIdDup(@Param("loginId") String loginId);
	
}
