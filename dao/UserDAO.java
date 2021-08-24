package com.recipe.common.dao;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.vo.*;

@Repository
public class UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public String login(UserVO userVO) {
		return sqlSession.selectOne("userMapper.login",userVO);
	}
	public int join(UserVO userVO) {
		return sqlSession.insert("userMapper.join",userVO);
	}
	public int userUpdate(UserVO userVO) {
		return sqlSession.update("userMapper.userUpdate",userVO);
	}
	public int userPwUpdate(UserVO userVO) {
		return sqlSession.update("userMapper.userPwUpdate",userVO);
	}
	public String getUserNickName(String userID) {
		return sqlSession.selectOne("userMapper.getUserNickName",userID);
	}
	public String getUserEmail(String userID) {
		return sqlSession.selectOne("userMapper.getUserEmail",userID);
	}
	public String checkID(String userID) {
		return sqlSession.selectOne("userMapper.checkID",userID); 
	}
	public String findUserID(String userEmail) {
		return sqlSession.selectOne("userMapper.findUserID",userEmail); 
	}
	public int userFavorite(UserVO userVO) {
		return sqlSession.update("userMapper.userFavorite",userVO);
	}
	
	public UserVO getUser(String userID) {
		return sqlSession.selectOne("userMapper.getUser",userID);
	}
	public String checkNickName(String userNickName) {
		return sqlSession.selectOne("userMapper.checkNickName",userNickName);
	}
	public String checkEmail(String userEmail) {
		return sqlSession.selectOne("userMapper.checkEmail",userEmail);
	}

	public String getUserFavorite(String userID) {
		return sqlSession.selectOne("userMapper.getUserFavorite",userID);
	}
	public int userDelete(UserVO userVO) {
		return sqlSession.delete("userMapper.userDelete",userVO);
	}
}
