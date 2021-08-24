package com.recipe.common.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.vo.*;

@Repository
public class BasketDAO {
	@Autowired
	private SqlSession sqlSession;
	public int userBasket(BasketVO basketVO) {
		return sqlSession.insert("basketMapper.userBasket",basketVO);
	}
	public List<BasketVO> getUserBasket(String userID) {
		return sqlSession.selectList("basketMapper.getUserBasket",userID);
	}
	public int productCnUpdate(BasketVO basketVO) {
		return sqlSession.update("basketMapper.productCnUpdate",basketVO);
	}
	public String basketCheck(BasketVO basketVO) {
		return sqlSession.selectOne("basketMapper.basketCheck",basketVO);
	}
	public int basketDelete(BasketVO basketVO) {
		return sqlSession.delete("basketMapper.basketDelete",basketVO);
	}
}
