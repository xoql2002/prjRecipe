package com.recipe.common.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.recipe.common.service.*;
import com.recipe.common.vo.*;

@Controller
public class UserBbsController {
	@Autowired
	private UserBbsService ubs;
	ModelAndView mv = new ModelAndView();
	@RequestMapping("board")
	private String board(int pageNumber,Model model) {
		List<UserBbsVO> list = ubs.getUserBbsList();
		int listSize = 0;
		listSize = list.size();
		int min = 0 +((pageNumber-1)*12);
		int max = 12*pageNumber; 
		if(listSize>max){
			listSize=max*pageNumber;
		}
		model.addAttribute("list",list);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("listSize",listSize);
		model.addAttribute("min",min);
		model.addAttribute("max",max);
		return "board";
	}
	@RequestMapping("boardWrite")
	private String boardWrite() {
		return "boardWrite";
	}
	@RequestMapping("boardWrite.do")
	private ModelAndView doBoardWrite(@ModelAttribute UserBbsVO userBbsVO,Model model) {
		int result = 0;
		if (userBbsVO.getUserBbsTitle().equals("") || userBbsVO.getUserBbsContent().equals("")) {
			result = -2;
		} else {
			result = ubs.writeUserBbs(userBbsVO);
		}
		mv.setViewName("boardWriteAction");
		model.addAttribute("result",result);
		return mv;
	}
	@RequestMapping("boardView")
	private String boardView(@ModelAttribute UserBbsVO userBbsVO,Model model,int bbsID,int pageNumber) {
		userBbsVO = ubs.getUserBbs(bbsID);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("userBbsVO",userBbsVO);
		return "boardView";
	}
	@RequestMapping("boardUpdate")
	private String boardUpdate(@ModelAttribute UserBbsVO bbsVO,Model model,int pageNumber) {
		bbsVO = ubs.getUserBbs(bbsVO.getBbsID());
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("bbsVO",bbsVO);
		return "boardUpdate";
	}
	@RequestMapping("boardUpdate.do")
	private ModelAndView doBoardUpdate(@ModelAttribute UserBbsVO userBbsVO,Model model,int pageNumber) {
		
		int result = 0;
		if (userBbsVO.getUserBbsTitle().equals("") || userBbsVO.getUserBbsContent().equals("")) {
			result = -2;
		} else {
			result = ubs.boardUpdate(userBbsVO);
		}
		mv.setViewName("boardUpdateAction");
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("result",result);
		return mv;
	}
	@RequestMapping("boardDelete")
	public ModelAndView boardDelete(int bbsID,Model model,int pageNumber) {
		mv.setViewName("boardDeleteAction");
		int result = ubs.boardDelete(bbsID);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("result",result);
		return mv;
	}
}
