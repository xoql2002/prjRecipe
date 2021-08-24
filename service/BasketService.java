package com.recipe.common.service;

import java.util.*;

import com.recipe.common.vo.*;

public interface BasketService {
	public int userBasket(BasketVO basketVO);
	public List<BasketVO> getUserBasket(String userID);
	public int productCnUpdate(BasketVO basketVO);
	public int basketDelete(BasketVO basketVO);
	public String basketCheck(BasketVO basketVO);
}
