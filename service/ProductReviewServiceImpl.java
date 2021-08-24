package com.recipe.common.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.dao.*;
import com.recipe.common.vo.*;

@Service
public class ProductReviewServiceImpl implements ProductReviewService{
	@Autowired
	ProductReviewDAO reviewDAO;
	  
	@Override
	public int writeReview(ProductReviewVO reviewVO) {
		return reviewDAO.writeReview(reviewVO); 
	}
	@Override
	public List<ProductReviewVO> getReviewList(int bbsID){
		return reviewDAO.getReviewList(bbsID);
	}
	@Override
	public List<ProductReviewVO> reviewCheckList(int bbsID){
		return reviewDAO.reviewCheckList(bbsID);
	}
}
