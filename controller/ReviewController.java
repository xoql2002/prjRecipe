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
public class ReviewController {
	@Autowired
	private ReviewService rs;
	ModelAndView mv = new ModelAndView();
	@RequestMapping("writeReview.do")
	private ModelAndView writeReview(@ModelAttribute ReviewVO reviewVO,Model model) {
		int result = 0;
		List<ReviewVO> list = rs.reviewCheckList(reviewVO.getBbsID());
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getUserID().equals(reviewVO.getUserID())){
				result = -5;
			}
		}
		if(result != -5) {
		if(reviewVO.getUserID()==null||reviewVO.getUserID().equals("")) {
			result = -2;
		}else if (reviewVO.getBbsID()==0) {
			result = -3;
		}else if (reviewVO.getReviewStar()==0||reviewVO.getReviewContent()==null||reviewVO.getReviewContent().equals("")) {
			result = -4;
		}else  {
			result = rs.writeReview(reviewVO); 
		}
		}
		model.addAttribute("result",result);
		model.addAttribute("bbsID",reviewVO.getBbsID());
		mv.setViewName("writeReviewAction");
		return mv;
	}
}
