package com.recipe.common.vo;

public class ReviewVO {
	private int bbsID;
	private int reviewStar;
	private String reviewContent;
	private String userID;
	private String userNickName;
	private String reviewDate;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public int getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	@Override
	public String toString() {
		return "ReviewVO [bbsID=" + bbsID + ", reviewStar=" + reviewStar + ", reviewContent=" + reviewContent
				+ ", userID=" + userID + ", userNickName=" + userNickName + ", reviewDate=" + reviewDate + "]";
	}
}
