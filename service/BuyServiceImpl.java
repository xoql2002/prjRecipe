package com.recipe.common.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.dao.*;
import com.recipe.common.vo.*;
@Service
public class BuyServiceImpl implements BuyService {
	@Autowired
	BuyDAO buyDAO;
	
	@Override
	public int userBuy(BuyVO buyVO) {
		return buyDAO.userBuy(buyVO);
	}
	@Override
	public List<BuyVO> buyList(String userID){
		return buyDAO.buyList(userID);
	}
	@Override
	public int basketDelete(HashMap<String, Object> map) {
		return buyDAO.basketDelete(map);
	}
	@Override
	public List<BuyVO> buyAllList(){
		return buyDAO.buyAllList();
	}
	
	
}
