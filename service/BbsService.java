package com.recipe.common.service;

import java.util.*;
import com.recipe.common.vo.*;

public interface BbsService {
	public int write(BbsVO bbsVO);
	public List<BbsVO> getList(HashMap<String, Object> map);
	public List<BbsVO> getStarList(HashMap<String, Object> map);
	public BbsVO getBbs(int bbsID);
	public int update(BbsVO bbsVO);
	public int hitUpdate(int bbsID);
	public int RecoUpdate(int bbsID);
	public int delete(int bbsID);
	public List<BbsVO> userFavoriteList(String userID);
}
