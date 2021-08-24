package com.recipe.common.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.vo.*;

@Repository
public class ProductBbsDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int write(ProductBbsVO bbsVO) {
		return sqlSession.insert("productBbsMapper.write",bbsVO);
	}
	public List<ProductBbsVO> getList(HashMap<String, Object> map){
		return sqlSession.selectList("productBbsMapper.getList",map);
	}
	public List<ProductBbsVO> getStarList(HashMap<String, Object> map){
		return sqlSession.selectList("productBbsMapper.getStarList",map);
	}
	public ProductBbsVO getBbs(int bbsID){
		return sqlSession.selectOne("productBbsMapper.getBbs",bbsID);
	}
	public int update(ProductBbsVO bbsVO){
		return sqlSession.update("productBbsMapper.update",bbsVO);
	}
	public int hitUpdate(int bbsID){
		return sqlSession.update("productBbsMapper.hitUpdate",bbsID);
	}
	public int recoUpdate(int bbsID){
		return sqlSession.update("productBbsMapper.recoUpdate",bbsID);
	}
	public int delete(int bbsID){
		return sqlSession.update("productBbsMapper.delete",bbsID);
	}
	public List<ProductBbsVO> userFavoriteList(String userID){
		return sqlSession.selectList("productBbsMapper.userFavoriteList",userID);
	}
	public int bbsStockUpdate(HashMap<String, Object> map){
		return sqlSession.update("productBbsMapper.bbsStockUpdate",map);
	}
}
