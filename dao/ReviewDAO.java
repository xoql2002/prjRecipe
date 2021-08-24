package com.recipe.common.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.vo.*;

@Repository
public class ReviewDAO {
	@Autowired
	private SqlSession sqlSession;
	public int writeReview(ReviewVO reviewVO) {
		return sqlSession.insert("reviewMapper.writeReview",reviewVO);
	}
	public List<ReviewVO> getReviewList(int bbsID){
		return sqlSession.selectList("reviewMapper.getReviewList",bbsID);
	}
	public List<ReviewVO> reviewCheckList(int bbsID){
		return sqlSession.selectList("reviewMapper.reviewCheckList",bbsID);
	}
}
