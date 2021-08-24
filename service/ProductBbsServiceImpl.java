package com.recipe.common.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.dao.*;
import com.recipe.common.vo.*;

@Service
public class ProductBbsServiceImpl implements ProductBbsService{
	@Autowired
	ProductBbsDAO bbsDAO;
	
	@Override
	public int write(ProductBbsVO bbsVO) {
		return bbsDAO.write(bbsVO);
	}
	@Override
	public List<ProductBbsVO> getList(HashMap<String, Object> map){
		return bbsDAO.getList(map);
	}
	@Override 
	public List<ProductBbsVO> getStarList(HashMap<String, Object> map){
		return bbsDAO.getStarList(map);
	}
	@Override
	public ProductBbsVO getBbs(int bbsID) {
		return bbsDAO.getBbs(bbsID);
	}
	@Override
	public int update(ProductBbsVO bbsVO) {
		return bbsDAO.update(bbsVO);
	}
	@Override
	public int hitUpdate(int bbsID) {
		return bbsDAO.hitUpdate(bbsID);
	}
	@Override
	public int RecoUpdate(int bbsID) {
		return bbsDAO.recoUpdate(bbsID);
	}
	@Override
	public int delete(int bbsID) {
		return bbsDAO.delete(bbsID);
	}
	@Override
	public List<ProductBbsVO> userFavoriteList(String userID){
		return bbsDAO.userFavoriteList(userID);
	}
	@Override
	public int bbsStockUpdate(HashMap<String, Object> map) {
		return bbsDAO.bbsStockUpdate(map);
	}
}
