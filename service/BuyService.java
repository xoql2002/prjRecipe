package com.recipe.common.service;

import java.util.*;

import com.recipe.common.vo.*;

public interface BuyService {
	public int userBuy(BuyVO buyVO);
	public List<BuyVO> buyList(String userID);
	public int basketDelete(HashMap<String, Object> map);
	public List<BuyVO> buyAllList();
}
