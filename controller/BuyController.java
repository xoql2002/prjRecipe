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
public class BuyController {
	@Autowired
	private BuyService bs;
	@Autowired
	private UserService us;
	@Autowired
	private ProductBbsService pbs;
	ModelAndView mv = new ModelAndView();
	@RequestMapping("buyList")
	private String buyList(Model model,String userID) {
		List<BuyVO> buyList = bs.buyList(userID);
		int productSum=0;
		for(int i=0;i<buyList.size();i++) {
			productSum = productSum + (buyList.get(i).getBbsPrice2()*buyList.get(i).getBuyCn());
		}
		model.addAttribute("list",buyList);
		model.addAttribute("productSum",productSum);
		return "buyList";
	}
	@RequestMapping("userBuy.do")
	@ResponseBody
	private String doUserBuy(@ModelAttribute BuyVO buyVO,Model model,String productCheck) {
		String buyCheck[] = productCheck.split("/");
		int result = 0;
		if(buyVO.getUserID()==null || buyVO.getUserID().equals("")) {
			result = -3;
		}else {
			for(int i=0;i<buyCheck.length;i++) {
				BuyVO vo = new BuyVO();
				vo.setUserEmail(buyVO.getUserEmail());
				vo.setUserName(buyVO.getUserName());
				vo.setUserPhone(buyVO.getUserPhone());
				vo.setUserAddress(buyVO.getUserAddress());
				vo.setUserPost(buyVO.getUserPost());
				vo.setUserID(buyVO.getUserID()); 
				vo.setBbsPrice2(Integer.parseInt((buyCheck[i].split("="))[0]));
				vo.setBbsID(Integer.parseInt((buyCheck[i].split("="))[1]));
				vo.setBuyTitle((buyCheck[i].split("="))[2]);
				vo.setBuyCn(Integer.parseInt((buyCheck[i].split("="))[3]));
				bs.userBuy(vo);
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("bbsID",vo.getBbsID());
				map.put("buyCn",vo.getBuyCn());
				map.put("userID",buyVO.getUserID());
				pbs.bbsStockUpdate(map);
				bs.basketDelete(map);
				
			}
			result = 1;
		}
		return String.valueOf(result);
	}
	@RequestMapping("buy")
	private ModelAndView buy(@ModelAttribute BuyVO buyVO,Model model,String productCheck) throws Exception{
		String buyCheck[] = productCheck.split("/");
		int result = 0;
		mv.setViewName("buyAction");
		if(buyVO.getProductSum().replace(",","")==null||buyVO.getProductSum().replace(",","").equals("")||buyVO.getProductSum().replace(",","").equals("0")) {
			result = -1;
		}else if(buyVO.getUserID()==null || buyVO.getUserID().equals("")) {
			result = -2;
		}else {
			List<BuyVO> list = new ArrayList<BuyVO>();
			for(int i=0;i<buyCheck.length;i++) {
				BuyVO vo = new BuyVO();
				vo.setBbsPrice2(Integer.parseInt((buyCheck[i].split("="))[0]));
				vo.setBbsID(Integer.parseInt((buyCheck[i].split("="))[1]));
				vo.setBuyTitle((buyCheck[i].split("="))[2]);
				vo.setBuyCn(Integer.parseInt((buyCheck[i].split("="))[3]));
				list.add(vo);
			}
			model.addAttribute("productCheck",productCheck);
			model.addAttribute("list",list);
			model.addAttribute("user",us.getUser(buyVO.getUserID()));
			model.addAttribute("productSum",buyVO.getProductSum().replace(",",""));
			mv.setViewName("buy");
		}
		model.addAttribute("result",result);
		return mv;
	}
	@RequestMapping("adminDelivery")
	private String adminDelivery(Model model) {
		List<BuyVO> buyList = bs.buyAllList();
		model.addAttribute("list",buyList);
		return "adminDelivery";
	}
}
