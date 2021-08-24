package com.recipe.common.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.vo.*;

@Repository
public class ProductReviewDAO {
	@Autowired
	private SqlSession sqlSession;
	public int writeReview(ProductReviewVO reviewVO) {
		return sqlSession.insert("productReviewMapper.writeReview",reviewVO);
	}
	public List<ProductReviewVO> getReviewList(int bbsID){
		return sqlSession.selectList("productReviewMapper.getReviewList",bbsID);
	}
	public List<ProductReviewVO> reviewCheckList(int bbsID){
		return sqlSession.selectList("productReviewMapper.reviewCheckList",bbsID);
	}
}
