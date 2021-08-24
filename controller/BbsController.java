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
public class BbsController {
	@Autowired
	private BbsService bs;
	@Autowired
	private ReviewService rs;
	@Autowired
	private UserService us;
	ModelAndView mv = new ModelAndView();
	@Resource(name = "uploadPath")
	private String uploadPath;
	@RequestMapping("bbs")
	private String bbs(Model model,int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bbsSort",bbsSort);
		map.put("bbsCategory",bbsCategory);
		map.put("searchItem", searchItem);
		List<BbsVO> list = bs.getList(map);
		int listSize = 0;
		listSize = list.size();
		int min = 0 +((pageNumber-1)*12);
		int max = 12*pageNumber; 
		if(listSize>max){
			listSize=max*pageNumber;
		}
		for (int i = 0; i < list.size(); i++) {
			map.put("bbsID",list.get(i).getBbsID());
			List<BbsVO> starList = bs.getStarList(map);
			list.set(i,starList.get(i));
		} 
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("list",list);
		model.addAttribute("min",min);
		model.addAttribute("max",max);
		return "bbs";
	}
	@RequestMapping("write")
	private String write() {
		return "write";
	}
	@RequestMapping("write.do")
	public ModelAndView write(@ModelAttribute BbsVO bbsVO,Model model,HttpServletRequest request,MultipartFile file) {
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
		String bbsIgd = request.getParameter("bbsIgd")+"&&&"+request.getParameter("bbsIgd2")+"&&&"+request.getParameter("bbsIgd3")+"&&&"+request.getParameter("bbsIgd4")+"&&&"+request.getParameter("bbsIgd5")
		+"&&&"+request.getParameter("bbsIgd6")+"&&&"+request.getParameter("bbsIgd7")+"&&&"+request.getParameter("bbsIgd8")+"&&&"+request.getParameter("bbsIgd9")+"&&&"+request.getParameter("bbsIgd10");
		bbsVO.setBbsContent(bbsContent);
		bbsVO.setBbsIgd(bbsIgd);
		bbsVO.setBbsFileName(fileName);
		int result = 0;
		String []bbsContentCheck = bbsVO.getBbsContent().split("&&&");
		String []bbsIgdCheck = bbsVO.getBbsIgd().split("&&&");
		if (bbsVO.getBbsTitle().equals("") || bbsContentCheck.length == 0 || bbsVO.getBbsPeopleNum().equals("") || bbsVO.getBbsCategory1().equals("") || bbsVO.getBbsCookTime().equals("")
				|| bbsVO.getBbsFileName().equals("") || bbsIgdCheck.length == 0) {
			result = -2;
		} else {
			result = bs.write(bbsVO);
		}
		mv.setViewName("writeAction");	
		model.addAttribute("result",result);
		return mv;
	}
	@RequestMapping("view")
	private String view(@ModelAttribute BbsVO bbsVO,Model model,int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		bs.hitUpdate(bbsVO.getBbsID());
		bbsVO = bs.getBbs(bbsVO.getBbsID());
		String bbsIgd[] = bbsVO.getBbsIgd().split("&&&");
		String bbsContent[] = bbsVO.getBbsContent().split("&&&");
		for(int i =0;i<bbsIgd.length;i++){
			bbsIgd[i].replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n","<br>");
		}
		for(int i =0;i<bbsContent.length;i++){
			bbsContent[i].replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n","<br>");
		}
		List<ReviewVO> list = rs.getReviewList(bbsVO.getBbsID());
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("list",list);
		model.addAttribute("bbsIgd",bbsIgd);
		model.addAttribute("bbsContent",bbsContent);
		model.addAttribute("bbsVO",bbsVO);
		return "view";
	}
	@RequestMapping("update")
	public String update(@ModelAttribute BbsVO bbsVO,Model model,int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		bbsVO = bs.getBbs(bbsVO.getBbsID());
		String bbsIgd[] = bbsVO.getBbsIgd().split("&&&");
		String bbsContent[] = bbsVO.getBbsContent().split("&&&");
		for(int i =0;i<bbsIgd.length;i++){
			bbsIgd[i].replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n","<br>");
		}
		for(int i =0;i<bbsContent.length;i++){
			bbsContent[i].replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n","<br>");
		}
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("bbsIgd",bbsIgd);
		model.addAttribute("bbsContent",bbsContent);
		model.addAttribute("bbsVO",bbsVO);
		return "update";
	}
	@RequestMapping("update.do")
	public ModelAndView doUpdate(@ModelAttribute BbsVO bbsVO,Model model,HttpServletRequest request,MultipartFile file,
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
		String bbsIgd = request.getParameter("bbsIgd")+"&&&"+request.getParameter("bbsIgd2")+"&&&"+request.getParameter("bbsIgd3")+"&&&"+request.getParameter("bbsIgd4")+"&&&"+request.getParameter("bbsIgd5")
		+"&&&"+request.getParameter("bbsIgd6")+"&&&"+request.getParameter("bbsIgd7")+"&&&"+request.getParameter("bbsIgd8")+"&&&"+request.getParameter("bbsIgd9")+"&&&"+request.getParameter("bbsIgd10");
		bbsVO.setBbsContent(bbsContent);
		bbsVO.setBbsIgd(bbsIgd);
		bbsVO.setBbsFileName(fileName);
		int result = 0;
		String []bbsContentCheck = bbsVO.getBbsContent().split("&&&");
		String []bbsIgdCheck = bbsVO.getBbsIgd().split("&&&");
		if (bbsVO.getBbsTitle().equals("") || bbsContentCheck.length == 0 || bbsVO.getBbsPeopleNum().equals("") || bbsVO.getBbsCategory1().equals("") || bbsVO.getBbsCookTime().equals("")
				|| bbsVO.getBbsFileName().equals("") || bbsIgdCheck.length == 0) {
			result = -2;
		} else {
			result = bs.update(bbsVO);
		}
		mv.setViewName("updateAction");	
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("result",result);
		model.addAttribute("bbsID",bbsVO.getBbsID());
		return mv;
	}
	@RequestMapping("delete.do")
	public ModelAndView doDelete(int bbsID,Model model,int pageNumber,String bbsSort,String bbsCategory,String searchItem) {
		mv.setViewName("bbsDeleteAction");
		int result = bs.delete(bbsID);
		model.addAttribute("bbsSort",bbsSort);
		model.addAttribute("bbsCategory",bbsCategory);
		model.addAttribute("searchItem",searchItem);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("result",result);
		return mv;
	}
	@RequestMapping("userFavorite")
	private String userFavorite(Model model,int pageNumber,String userID) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bbsSort","BBSHIT");
		String userFavorite = us.getUserFavorite(userID);
		List<BbsVO> getList = bs.getList(map);
		List<BbsVO> userFavoriteList = new ArrayList<BbsVO>();
		if(userFavorite != null) {
		for (int i = 0; i < getList.size(); i++) {
			if(userFavorite.indexOf(","+String.valueOf(getList.get(i).getBbsID())+",") != -1) {
				userFavoriteList.add(getList.get(i));
				map.put("bbsID",userFavoriteList.get(i).getBbsID());
				List<BbsVO> starList = bs.getStarList(map);
				userFavoriteList.set(i,starList.get(i));
			}
		}
		}
		int listSize = 0;
		listSize = userFavoriteList.size();
		int min = 0 +((pageNumber-1)*12); 
		int max = 12*pageNumber; 
		if(listSize>max){
			listSize=max*pageNumber;
		}
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("list",userFavoriteList);
		model.addAttribute("listSize",listSize);
		model.addAttribute("min",min);
		model.addAttribute("max",max);
		return "userFavorite";
	}
}
