package com.recipe.common.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.dao.*;
import com.recipe.common.vo.*;

@Service
public class BbsServiceImpl implements BbsService{
	@Autowired
	BbsDAO bbsDAO;
	
	@Override
	public int write(BbsVO bbsVO) {
		return bbsDAO.write(bbsVO);
	}
	@Override
	public List<BbsVO> getList(HashMap<String, Object> map){
		return bbsDAO.getList(map);
	}
	@Override
	public List<BbsVO> getStarList(HashMap<String, Object> map){
		return bbsDAO.getStarList(map);
	}
	@Override
	public BbsVO getBbs(int bbsID) {
		return bbsDAO.getBbs(bbsID);
	}
	@Override
	public int update(BbsVO bbsVO) {
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
	public List<BbsVO> userFavoriteList(String userID){
		return bbsDAO.userFavoriteList(userID);
	}
}
