package com.recipe.common.service;

import java.util.*;

import com.recipe.common.vo.*;

public interface UserBbsService {
	public int writeUserBbs(UserBbsVO userBbsVO);
	public List<UserBbsVO> getUserBbsList();
	public UserBbsVO getUserBbs(int bbsID);
	public int boardUpdate(UserBbsVO userBbsVO);
	public int boardDelete(int bbsID);
}
