package com.recipe.common.service;

import java.util.*;

import com.recipe.common.vo.*;

public interface ProductBbsService {
	public int write(ProductBbsVO bbsVO);
	public List<ProductBbsVO> getList(HashMap<String, Object> map);
	public List<ProductBbsVO> getStarList(HashMap<String, Object> map);
	public ProductBbsVO getBbs(int bbsID);
	public int update(ProductBbsVO bbsVO);
	public int hitUpdate(int bbsID);
	public int RecoUpdate(int bbsID);
	public int delete(int bbsID);
	public List<ProductBbsVO> userFavoriteList(String userID);
	public int bbsStockUpdate(HashMap<String, Object> map);
}
