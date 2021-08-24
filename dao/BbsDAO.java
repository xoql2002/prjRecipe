package com.recipe.common.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.vo.*;

@Repository
public class BbsDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int write(BbsVO bbsVO) {
		return sqlSession.insert("bbsMapper.write",bbsVO);
	}
	public List<BbsVO> getList(HashMap<String, Object> map){
		return sqlSession.selectList("bbsMapper.getList",map);
	}
	public List<BbsVO> getStarList(HashMap<String, Object> map){
		return sqlSession.selectList("bbsMapper.getStarList",map);
	}
	public BbsVO getBbs(int bbsID){
		return sqlSession.selectOne("bbsMapper.getBbs",bbsID);
	}
	public int update(BbsVO bbsVO){
		return sqlSession.update("bbsMapper.update",bbsVO);
	}
	public int hitUpdate(int bbsID){
		return sqlSession.update("bbsMapper.hitUpdate",bbsID);
	}
	public int recoUpdate(int bbsID){
		return sqlSession.update("bbsMapper.recoUpdate",bbsID);
	}
	public int delete(int bbsID){
		return sqlSession.update("bbsMapper.delete",bbsID);
	}
	public List<BbsVO> userFavoriteList(String userID){
		return sqlSession.selectList("bbsMapper.userFavoriteList",userID);
	}

}
