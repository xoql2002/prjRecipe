package com.recipe.common.controller;

import java.util.*;
import java.util.regex.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.recipe.common.service.*;
import com.recipe.common.vo.*;
@Controller
public class UserController {
	@Autowired
	private UserService us;
	ModelAndView mv = new ModelAndView();
	@RequestMapping("login")
	private String login() {
		return "login";
	}
	@RequestMapping("join")
	private String join() {
		return "join";
	}
	@RequestMapping("checkID")
	private String checkID() {
		return "checkID";
	}
	@RequestMapping("findUser")
	private String findUser() {
		return "findUser";
	}
	@RequestMapping("login.do")
	public ModelAndView login(@ModelAttribute UserVO userVO,HttpSession session,Model model) {
		int result = 0;
		String userPassword = us.login(userVO);
		if(userPassword==null) {
			result = -1;
		}else{
			if(userPassword.equals(userVO.getUserPassword())) {
				result = 1;
			}
			else {
				result = -2;
			}
		}
		if(result==1) {
			session.setAttribute("userID",userVO.getUserID());
			session.setAttribute("userNickName",us.getUserNickName(userVO.getUserID()));
		}
		mv.setViewName("loginAction");
		model.addAttribute("result", result);
		return mv;
	}
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		mv.setViewName("redirect:/");	
		return mv;
	}
	@RequestMapping("join.do")
	public ModelAndView join(@ModelAttribute UserVO userVO,HttpSession session,Model model) {
		int result = 0;
		String regex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String input = userVO.getUserEmail();
		boolean resultEmail = Pattern.matches(regex, input);
		if(us.getUser(userVO.getUserID())!=null) {
			result = -1;
		}else if (userVO.getUserID() == null || userVO.getUserPassword() == null || userVO.getUserName() == null
				|| userVO.getUserGender() == null || userVO.getUserEmail() == null || userVO.getUserNickName() ==null||
				userVO.getUserAddress() ==null ||userVO.getUserAddress1()==null || userVO.getUserPhone() == null|| userVO.getUserPost() == null||
				userVO.getUserID().equals("") || userVO.getUserPassword().equals("") || userVO.getUserName().equals("")
				|| userVO.getUserGender().equals("") || userVO.getUserEmail().equals("") || userVO.getUserNickName().equals("")
				|| userVO.getUserAddress().equals("") ||  userVO.getUserAddress1().equals("")||userVO.getUserPhone().equals("") || userVO.getUserPost().equals("")) {
			result = -2;
		} else if(us.checkNickName(userVO.getUserNickName()) != null){
			result = -3;
		}else if(!userVO.getUserPassword().equals(userVO.getUserPasswordTest())){
			result = -4;
		}else if(userVO.getUserPassword().length()<6){
			result = -5;
		}else if(!resultEmail){
			result = -6;
		}else if(us.checkEmail(userVO.getUserEmail()) != null){
			result = -7;
		}else {
			result = us.join(userVO);
		}
		if(result==1) {
			session.setAttribute("userID",userVO.getUserID());
			session.setAttribute("userNickName",userVO.getUserNickName());
		}
		mv.setViewName("joinAction");
		model.addAttribute("result", result);
		return mv;
	}
	@RequestMapping("checkID.do")
	public ModelAndView checkID(Model model,String checkID) {	
		String result = us.checkID(checkID);
		model.addAttribute("result", result);
		mv.setViewName("checkIDAction");
		return mv;
	}
	@RequestMapping("findUserID.do")
	public ModelAndView findUserID(Model model,String userEmail) {	
		String result = us.findUserID(userEmail);
		model.addAttribute("result", result);
		mv.setViewName("findUserID");
		return mv;
	}
	@RequestMapping("findUserPW.do")
	public ModelAndView findUserPW(@ModelAttribute UserVO userVO,Model model) throws Exception {
		int result = 0;
		Random r = new Random();
		int num = r.nextInt(999999);
		mv.setViewName("findUserPWAction");
		if(!userVO.getUserEmail().equals("") && !userVO.getUserID().equals("")) {
		String findID = us.findUserID(userVO.getUserEmail());
			if(findID != null) {
				if(findID.equals(userVO.getUserID())) {
					EmailVO eVO = new EmailVO();
					eVO.setSubject(userVO.getUserID() + "님 비밀번호 찾기 메일입니다.");
					eVO.setContent(userVO.getUserID() + "님 인증번호는 "+num+" 입니다.");
					eVO.setReceiver(userVO.getUserEmail());
					model.addAttribute("num", num);
					model.addAttribute("userID",userVO.getUserID());
					us.SendEmail(eVO);
					mv.setViewName("findPWCheck");
				}else {
					result = -1;
				}
			}else {
				result = -2;
			}
		}else {
			result = -3;
		}
		model.addAttribute("result",result);
		return mv;
	}
	@RequestMapping("findPWCheck")
	public ModelAndView findPWCheck(@ModelAttribute UserVO userVO,Model model,int num,String checkNum){
		int result = 0;
		mv.setViewName("findPWCheckAction");
		if(checkNum.equals("")) {
			result = -1;
		}else if(num==Integer.parseInt(checkNum)) {
		model.addAttribute("userID",userVO.getUserID());
		mv.setViewName("findPWChange");
		}else if(num != Integer.parseInt(checkNum)) {
			result = -2;
		}
		model.addAttribute("result",result);
		return mv;
	}
	@RequestMapping("findPWChange")
	public ModelAndView findPWChange(@ModelAttribute UserVO userVO,Model model) {	
		int result = 0;
		if (userVO.getUserChangePw()==null||userVO.getUserChangePwTest()==null||
				userVO.getUserChangePw().equals("")||userVO.getUserChangePwTest().equals("")
		) {
			result = -2;
		}else if(userVO.getUserChangePw().length()<6){
			result = -3;
		}else if(!userVO.getUserChangePw().equals(userVO.getUserChangePwTest())){
			result = -4;
		}else {
			result = us.userPwUpdate(userVO);
		}
		mv.setViewName("findPWChangeAction");
		model.addAttribute("result", result);
		return mv;
	}
	@RequestMapping("userUpdate")
	private String userUpdate(String userID,Model model) {
		model.addAttribute("user",us.getUser(userID));
		return "userUpdate";
	}
	@RequestMapping("userUpdate.do")
	public ModelAndView doUserUpdate(@ModelAttribute UserVO userVO,Model model) {
		int result = 0;
		String regex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String userPassword = us.login(userVO);
		boolean resultEmail = Pattern.matches(regex, userVO.getUserEmail());
		if(us.checkNickName(userVO.getUserNickName()) != null && !us.getUserNickName(userVO.getUserID()).equals(userVO.getUserNickName())){
			result = -1;
		}else if(us.checkEmail(userVO.getUserEmail()) != null && !us.getUserEmail(userVO.getUserID()).equals(userVO.getUserEmail())){
			result = -5;
		}else if (userVO.getUserID() == null || userVO.getUserPassword() == null || userVO.getUserName() == null
				|| userVO.getUserGender() == null || userVO.getUserEmail() == null || userVO.getUserNickName() ==null||
				userVO.getUserAddress() ==null ||userVO.getUserAddress1()==null || userVO.getUserPhone() == null|| userVO.getUserPost() == null||
				userVO.getUserID().equals("") || userVO.getUserPassword().equals("") || userVO.getUserName().equals("")
				|| userVO.getUserGender().equals("") || userVO.getUserEmail().equals("") || userVO.getUserNickName().equals("")
				|| userVO.getUserAddress().equals("") ||  userVO.getUserAddress1().equals("")||userVO.getUserPhone().equals("") || userVO.getUserPost().equals("")) {
			result = -2;
		}else if(!userPassword.equals(userVO.getUserPassword())){
			result = -3;
		}else if(!resultEmail){
			result = -4;
		}else {
			result = us.userUpdate(userVO);
		}
		mv.setViewName("userUpdateAction");
		model.addAttribute("result", result);
		return mv;
	}
	@RequestMapping("userUpdatePw")
	private String userUpdatePw() {
		return "userUpdatePw";
	}
	@RequestMapping("userUpdatePw.do")
	public ModelAndView doUserUpdatePw(@ModelAttribute UserVO userVO,Model model) {
		int result = 0;
		String userPassword = us.login(userVO);
		if (userVO.getUserPassword()==null||userVO.getUserChangePw()==null||userVO.getUserChangePwTest()==null||
				userVO.getUserPassword().equals("")||userVO.getUserChangePw().equals("")||userVO.getUserChangePwTest().equals("")
		) {
			result = -2;
		}else if(!userPassword.equals(userVO.getUserPassword())){
			result = -3;
		}else if(userVO.getUserChangePw().length()<6){
			result = -4;
		}else if(!userVO.getUserChangePw().equals(userVO.getUserChangePwTest())){
			result = -5;
		}else {
			result = us.userPwUpdate(userVO);
		}
		mv.setViewName("userUpdatePwAction");
		model.addAttribute("result", result);
		return mv;
	}
	@RequestMapping("userFavorite.do")
	private ModelAndView doUserFavorite(@ModelAttribute UserVO userVO,Model model) {
		String userFavorite = ","+userVO.getUserFavorite()+",";
		userVO.setUserFavorite(userFavorite);
		int result = 0;
		if(userVO.getUserID()==null || userVO.getUserID().equals("")) {
			result = -3;
		}else if(us.getUserFavorite(userVO.getUserID())!=null && us.getUserFavorite(userVO.getUserID()).indexOf(userVO.getUserFavorite()) != -1) {
			result = -2;
		}else {
			result = us.userFavorite(userVO);
		}
		model.addAttribute("result", result);
		mv.setViewName("userFavoriteAction");
		return mv;
	}
	@RequestMapping("userDelete")
	private String userDelete() {
		return "userDelete";
	}
	@RequestMapping("userDelete.do")
	private ModelAndView doUserDelete(@ModelAttribute UserVO userVO,Model model,HttpSession session) {
		int result = 0;
		String userPassword = us.login(userVO);
		if(userPassword==null) {
			result = -1;
		}else{
			if(userPassword.equals(userVO.getUserPassword())) {
				result = us.userDelete(userVO);
			}
			else {
				result = -2;
			}
		}
		if(result==1) {
			session.invalidate();
		}
		mv.setViewName("userDeleteAction");
		model.addAttribute("result", result);
		return mv;
	}
}
