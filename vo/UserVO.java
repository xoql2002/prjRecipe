package com.recipe.common.vo;

public class UserVO {
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	private String userPasswordTest;
	private String userNickName;
	private String userFavorite;
	private String userChangePw;
	private String userChangePwTest;
	private String userPhone;
	private String userPost;
	private String userAddress;
	private String userAddress1;

	public String getUserAddress1() {
		return userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserChangePw() {
		return userChangePw;
	}

	public void setUserChangePw(String userChangePw) {
		this.userChangePw = userChangePw;
	}

	public String getUserChangePwTest() {
		return userChangePwTest;
	}

	public void setUserChangePwTest(String userChangePwTest) {
		this.userChangePwTest = userChangePwTest;
	}

	public String getUserFavorite() {
		return userFavorite;
	}

	public void setUserFavorite(String userFavorite) {
		this.userFavorite = userFavorite;
	}
	
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserPasswordTest() {
		return userPasswordTest;
	}
	public void setUserPasswordTest(String userPasswordTest) {
		this.userPasswordTest = userPasswordTest;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userGender=" + userGender + ", userEmail=" + userEmail + ", userPasswordTest=" + userPasswordTest
				+ ", userNickName=" + userNickName + ", userFavorite=" + userFavorite + ", userChangePw=" + userChangePw
				+ ", userChangePwTest=" + userChangePwTest + ", userPhone=" + userPhone + ", userPost=" + userPost
				+ ", userAddress=" + userAddress + ", userAddress1=" + userAddress1 + "]";
	}



}
