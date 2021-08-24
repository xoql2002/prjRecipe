package com.recipe.common.controller;

import java.io.*;
import java.util.*;

import javax.annotation.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.*;

import com.recipe.common.service.*;
import com.recipe.common.vo.*;

@Controller
public class ProductBbsController {
	@Autowired
	private ProductBbsService pbs;
	@Autowired
	private ProductReviewService prs;
	ModelAndView mv = new ModelAndView();
	@Resource(name = "uploadPath")
	private String uploadPath;
	@RequestMapping("productBbs")
	private String productBbs(Model model,int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bbsSort",bbsSort);
		map.put("bbsCategory",bbsCategory);
		map.put("searchItem", searchItem);
		List<ProductBbsVO> list = pbs.getList(map);
		int listSize = 0;
		listSize = list.size();
		int min = 0 +((pageNumber-1)*12);
		int max = 12*pageNumber; 
		if(listSize>max){
			listSize=max*pageNumber;
		}
		for (int i = 0; i < list.size(); i++) {
			map.put("bbsID",list.get(i).getBbsID());
			List<ProductBbsVO> starList = pbs.getStarList(map);
			list.set(i,starList.get(i));
		} 
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("list",list);
		model.addAttribute("listSize",listSize);
		model.addAttribute("min",min);
		model.addAttribute("max",max);
		return "productBbs";
	}
	@RequestMapping("productWrite")
	private String productWrite() {
		return "productWrite";
	}
	@RequestMapping("productWrite.do")
	public ModelAndView doProductWrite(@ModelAttribute ProductBbsVO bbsVO,Model model,HttpServletRequest request,MultipartFile file) {
		String fileName = file.getOriginalFilename(); 
		UUID uuid = UUID.randomUUID();
		if(!fileName.equals("")) {
			fileName = uuid.toString()+"_"+ fileName;
			File target = new File(uploadPath, fileName);
        
        //경로 생성
        if ( ! new File(uploadPath).exists()) {
            new File(uploadPath).mkdirs();
        }
        //파일 복사
        try {
            FileCopyUtils.copy(file.getBytes(), target);
        } catch(Exception e) {
            e.printStackTrace();
        }
		}
		String bbsContent = request.getParameter("bbsContent") + "&&&" + request.getParameter("bbsContent2")+ "&&&" + request.getParameter("bbsContent3")
		+ "&&&" + request.getParameter("bbsContent4")+ "&&&" + request.getParameter("bbsContent5")+ "&&&" + request.getParameter("bbsContent6")+ "&&&" + request.getParameter("bbsContent7");
		bbsVO.setBbsContent(bbsContent);
		bbsVO.setBbsFileName(fileName); 
		int result = 0;
		String []bbsContentCheck = bbsVO.getBbsContent().split("&&&");
		if (bbsVO.getBbsTitle().equals("") || bbsContentCheck.length == 0 || bbsVO.getBbsPrice().equals("") || bbsVO.getBbsCategory1().equals("") || bbsVO.getBbsPriceDC().equals("")
				|| bbsVO.getBbsFileName().equals("")||bbsVO.getBbsStock().equals("")) {
			result = -2;
		} else {
			result = pbs.write(bbsVO);
		}
		mv.setViewName("productWriteAction");	
		model.addAttribute("result",result);
		return mv;
	}
	@RequestMapping("productView")
	private String productView(@ModelAttribute ProductBbsVO bbsVO,Model model,int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		pbs.hitUpdate(bbsVO.getBbsID());
		bbsVO = pbs.getBbs(bbsVO.getBbsID());
		String bbsContent[] = bbsVO.getBbsContent().split("&&&");
		for(int i =0;i<bbsContent.length;i++){
			bbsContent[i].replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n","<br>");
		}
		List<ProductReviewVO> list = prs.getReviewList(bbsVO.getBbsID());
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("list",list);
		model.addAttribute("bbsContent",bbsContent);
		model.addAttribute("bbsVO",bbsVO);
		return "productView";
	}
	@RequestMapping("productUpdate")
	public String productUpdate(@ModelAttribute ProductBbsVO bbsVO,Model model,int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		bbsVO = pbs.getBbs(bbsVO.getBbsID());
		String bbsContent[] = bbsVO.getBbsContent().split("&&&");
		for(int i =0;i<bbsContent.length;i++){
			bbsContent[i].replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n","<br>");
		}
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("bbsContent",bbsContent);
		model.addAttribute("bbsVO",bbsVO);
		return "productUpdate";
	}
	@RequestMapping("productUpdate.do")
	public ModelAndView doProductUpdate(@ModelAttribute ProductBbsVO bbsVO,Model model,HttpServletRequest request,MultipartFile file,
			int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		String fileName = file.getOriginalFilename(); 
		UUID uuid = UUID.randomUUID();
		if(!fileName.equals("")) {
		fileName = uuid.toString()+"_"+ file.getOriginalFilename();
        File target = new File(uploadPath, fileName);
        
        //경로 생성
        if ( ! new File(uploadPath).exists()) {
            new File(uploadPath).mkdirs();
        }
        //파일 복사
        try {
            FileCopyUtils.copy(file.getBytes(), target);
        } catch(Exception e) {
            e.printStackTrace();
        }
		}else {
			fileName=request.getParameter("fileName");
		}
		String bbsContent = request.getParameter("bbsContent") + "&&&" + request.getParameter("bbsContent2")+ "&&&" + request.getParameter("bbsContent3")
		+ "&&&" + request.getParameter("bbsContent4")+ "&&&" + request.getParameter("bbsContent5")+ "&&&" + request.getParameter("bbsContent6")+ "&&&" + request.getParameter("bbsContent7");
		bbsVO.setBbsContent(bbsContent);
		bbsVO.setBbsFileName(fileName);
		int result = 0;
		String []bbsContentCheck = bbsVO.getBbsContent().split("&&&");
		if (bbsVO.getBbsTitle().equals("") || bbsContentCheck.length == 0 || bbsVO.getBbsPrice().equals("") || bbsVO.getBbsCategory1().equals("") || bbsVO.getBbsPriceDC().equals("")
				|| bbsVO.getBbsFileName().equals("")) {
			result = -2;
		} else {
			result = pbs.update(bbsVO);
		}
		mv.setViewName("productUpdateAction");	
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("result",result);
		model.addAttribute("bbsID",bbsVO.getBbsID());
		return mv;
	}
	@RequestMapping("productDelete")
	public ModelAndView doDelete(int bbsID,Model model,int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		mv.setViewName("productDeleteAction");
		int result = pbs.delete(bbsID);
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("result",result);
		return mv;
	}
}
