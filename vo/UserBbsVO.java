package com.recipe.common.vo;

public class UserBbsVO {
	private int bbsID;
	private String userBbsTitle;
	private String userNickName;
	private String userBbsDate;
	private String userBbsContent;
	private int userBbsAvailable;
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public String getUserBbsTitle() {
		return userBbsTitle;
	}
	public void setUserBbsTitle(String userBbsTitle) {
		this.userBbsTitle = userBbsTitle;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserBbsDate() {
		return userBbsDate;
	}
	public void setUserBbsDate(String userBbsDate) {
		this.userBbsDate = userBbsDate;
	}
	public String getUserBbsContent() {
		return userBbsContent;
	}
	public void setUserBbsContent(String userBbsContent) {
		this.userBbsContent = userBbsContent;
	}
	public int getUserBbsAvailable() {
		return userBbsAvailable;
	}
	public void setUserBbsAvailable(int userBbsAvailable) {
		this.userBbsAvailable = userBbsAvailable;
	}
	@Override
	public String toString() {
		return "UserBbsVO [bbsID=" + bbsID + ", userBbsTitle=" + userBbsTitle + ", userNickName=" + userNickName
				+ ", userBbsDate=" + userBbsDate + ", userBbsContent=" + userBbsContent + ", userBbsAvailable="
				+ userBbsAvailable + "]";
	}

}
