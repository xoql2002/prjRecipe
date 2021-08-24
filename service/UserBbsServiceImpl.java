package com.recipe.common.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.dao.*;
import com.recipe.common.vo.*;

@Service
public class UserBbsServiceImpl implements UserBbsService {
	@Autowired
	UserBbsDAO userBbsDAO;
	
	@Override
	public int writeUserBbs(UserBbsVO userBbsVO) {
			return userBbsDAO.writeUserBbs(userBbsVO); 
	}
	@Override
	public List<UserBbsVO> getUserBbsList(){
		return userBbsDAO.getUserBbsList();
	}
	@Override
	public UserBbsVO getUserBbs(int bbsID) {
		return userBbsDAO.getUserBbs(bbsID);
	}
	@Override
	public int boardUpdate(UserBbsVO userBbsVO) {
		return userBbsDAO.boardUpdate(userBbsVO); 
	}
	@Override
	public int boardDelete(int bbsID) {
		return userBbsDAO.boardDelete(bbsID);
	}

}
