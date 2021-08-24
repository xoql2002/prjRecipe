package com.recipe.common.service;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

import com.recipe.common.dao.*;
import com.recipe.common.vo.*;

@Service
public class UserServiceImpl implements UserService{
		@Autowired
		UserDAO userDAO;
		@Autowired
		private JavaMailSender mailSender; 
		 
		@Override
		public String login(UserVO userVO) {
			return userDAO.login(userVO);
		}
		@Override
		public int join(UserVO userVO) {
			return userDAO.join(userVO);
		}
		@Override
		public int userUpdate(UserVO userVO) {
			return userDAO.userUpdate(userVO);
		}
		@Override
		public int userPwUpdate(UserVO userVO) {
			return userDAO.userPwUpdate(userVO);
		}
		@Override
		public String getUserNickName(String userID) {
			return userDAO.getUserNickName(userID);
		}
		@Override
		public String getUserEmail(String userID) {
			return userDAO.getUserEmail(userID);
		}
		@Override
		public String checkID(String userID) {
			return userDAO.checkID(userID);
		}
		@Override
		public String findUserID(String userEmail) {
			return userDAO.findUserID(userEmail);
		}
		@Override
		public int userFavorite(UserVO userVO) {
			return userDAO.userFavorite(userVO);
		}
		@Override
		public UserVO getUser(String userID){
			return userDAO.getUser(userID);
		}
		@Override
		public String checkNickName(String userNickName) {
			return userDAO.checkNickName(userNickName);
		}
		@Override
		public String checkEmail(String userEmail) {
			return userDAO.checkEmail(userEmail);
		}
		@Override
		public String getUserFavorite(String userID) {
			return userDAO.getUserFavorite(userID);
		}
		@Override
		public int userDelete(UserVO userVO) {
			return userDAO.userDelete(userVO);
		}
		@Override
		 public void SendEmail(EmailVO eVO) throws Exception {
	         MimeMessage msg = mailSender.createMimeMessage();
	         try {
	             msg.setSubject(eVO.getSubject());
	             msg.setText(eVO.getContent());
	             msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(eVO.getReceiver()));
	            
	         }catch(MessagingException e) {
	             System.out.println("MessagingException");
	             e.printStackTrace();
	         }
	         try {
	             mailSender.send(msg);
	         }catch(MailException e) {
	             System.out.println("MailException¹ß»ý");
	             e.printStackTrace();
	         }
	     }
}
