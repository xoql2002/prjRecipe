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
public class BasketController {
	@Autowired
	private BasketService bs;
	ModelAndView mv = new ModelAndView();
	@RequestMapping("basket")
	private String basket(Model model,String userID) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bbsSort","BBSHIT");
		List<BasketVO> basketlist = bs.getUserBasket(userID);
		model.addAttribute("list",basketlist);
		return "basket";
	}
	@RequestMapping("userBasket.do")
	@ResponseBody
	private String doUserBasket(@ModelAttribute BasketVO basketVO,Model model) {
		int result = 0;
		if(basketVO.getUserID()==null || basketVO.getUserID().equals("")) {
			result = -3;
		}else if(bs.basketCheck(basketVO)!=null) {
			result = -2;
		}else {
			result = bs.userBasket(basketVO);
		}
		return String.valueOf(result);
	}
	@RequestMapping("productCnUpdate")
	private String productCnUpdate(@ModelAttribute BasketVO basketVO,Model model) {
		
		bs.productCnUpdate(basketVO);
		return "redirect:/basket?userID="+basketVO.getUserID();
	}
	@RequestMapping("basketDelete")
	private String basketDelete(@ModelAttribute BasketVO basketVO,Model model) {
		bs.basketDelete(basketVO);
		return "redirect:/basket?userID="+basketVO.getUserID();
	}
}
