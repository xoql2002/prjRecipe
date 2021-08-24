package com.recipe.common.service;

import com.recipe.common.vo.*;

public interface UserService {
	public String login(UserVO userVO) ;
	public int join(UserVO userVO);
	public int userUpdate(UserVO userVO);
	public int userPwUpdate(UserVO userVO);
	public String getUserNickName(String userID);
	public String checkID(String userID);
	public String findUserID(String userEmail);
	public int userFavorite(UserVO userVO);		
	public UserVO getUser(String userID);
	public String checkNickName(String userNickName);
	public String checkEmail(String userEamil);
	public String getUserEmail(String userID);
	public String getUserFavorite(String userID);
	public int userDelete(UserVO userVO);
	public void SendEmail(EmailVO eVO) throws Exception;
}
