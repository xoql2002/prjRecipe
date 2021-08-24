package com.recipe.common.service;

import java.util.*;

import com.recipe.common.vo.*;

public interface ProductReviewService {
	public int writeReview(ProductReviewVO reviewVO);
	public List<ProductReviewVO> getReviewList(int bbsID);
	public List<ProductReviewVO> reviewCheckList(int bbsID);
}
