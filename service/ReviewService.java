package com.recipe.common.service;

import java.util.*;

import com.recipe.common.vo.*;

public interface ReviewService {
	public int writeReview(ReviewVO reviewVO);
	public List<ReviewVO> getReviewList(int bbsID);
	public List<ReviewVO> reviewCheckList(int bbsID);
}
