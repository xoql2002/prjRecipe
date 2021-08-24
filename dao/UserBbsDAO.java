package com.recipe.common.dao;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.recipe.common.vo.*;

@Repository
public class UserBbsDAO {
		@Autowired
		private SqlSession sqlSession;
		
		public int writeUserBbs(UserBbsVO userBbsVO) {
			return sqlSession.insert("userBbsMapper.writeUserBbs",userBbsVO);
		}
		public List<UserBbsVO> getUserBbsList() {
			return sqlSession.selectList("userBbsMapper.getUserBbsList");
		}
		public UserBbsVO getUserBbs(int bbsID) {
			return sqlSession.selectOne("userBbsMapper.getUserBbs",bbsID);
		}
		public int boardUpdate(UserBbsVO userBbsVO) {
			return sqlSession.update("userBbsMapper.boardUpdate",userBbsVO);
		}
		public int boardDelete(int bbsID) {
			return sqlSession.update("userBbsMapper.boardDelete",bbsID);
		}
}
