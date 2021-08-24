package com.recipe.common.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.dao.*;
import com.recipe.common.vo.*;

@Service
public class BasketServiceImpl implements BasketService{
	@Autowired
	BasketDAO basketDAO;
	@Override
	public int userBasket(BasketVO basketVO) {
		return basketDAO.userBasket(basketVO);
	}
	@Override
	public List<BasketVO> getUserBasket(String userID) {
		return basketDAO.getUserBasket(userID);
	}
	@Override
	public int productCnUpdate(BasketVO basketVO) {
		return basketDAO.productCnUpdate(basketVO);
	}
	@Override
	public String basketCheck(BasketVO basketVO) {
		return basketDAO.basketCheck(basketVO);
	}
	@Override
	public int basketDelete(BasketVO basketVO) {
		return basketDAO.basketDelete(basketVO);
	}
}
