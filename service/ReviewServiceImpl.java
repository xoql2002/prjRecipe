package com.recipe.common.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.dao.*;
import com.recipe.common.vo.*;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	ReviewDAO reviewDAO;
	 
	@Override
	public int writeReview(ReviewVO reviewVO) {
		return reviewDAO.writeReview(reviewVO); 
	}
	@Override
	public List<ReviewVO> getReviewList(int bbsID){
		return reviewDAO.getReviewList(bbsID);
	}
	@Override
	public List<ReviewVO> reviewCheckList(int bbsID){
		return reviewDAO.reviewCheckList(bbsID);
	}
}
