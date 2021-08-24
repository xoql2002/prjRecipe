package com.recipe.common.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.vo.*;

@Repository
public class BuyDAO {
	@Autowired
	private SqlSession sqlSession;
	public int userBuy(BuyVO buyVO) {
		return sqlSession.insert("buyMapper.userBuy",buyVO);
	}
	public List<BuyVO> buyList(String userID) {
		return sqlSession.selectList("buyMapper.buyList",userID);
	}
	public int basketDelete(HashMap<String, Object> map) {
		return sqlSession.delete("buyMapper.basketDelete",map);
	}
	public List<BuyVO> buyAllList() {
		return sqlSession.selectList("buyMapper.buyAllList");
	}
	
}
