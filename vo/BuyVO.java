package com.recipe.common.vo;

public class BuyVO {
	private int bbsID;
	private String userID;
	private int bbsPrice2;
	private String buyTitle;
	private int buyCn;
	private String productSum;
	private String productDelivery;
	private String userEmail;
	private String userName;
	private String userPhone;
	private String userAddress;
	private String userPost;
	private String buyDate;

	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPost() {
		return userPost;
	}
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}
	public String getProductDelivery() {
		return productDelivery;
	}
	public void setProductDelivery(String productDelivery) {
		this.productDelivery = productDelivery;
	}
	public String getProductSum() {
		return productSum;
	}
	public void setProductSum(String productSum) {
		this.productSum = productSum;
	}	
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public String getBuyTitle() {
		return buyTitle;
	}
	public void setBuyTitle(String buyTitle) {
		this.buyTitle = buyTitle;
	}
	public int getBuyCn() {
		return buyCn;
	}
	public void setBuyCn(int buyCn) {
		this.buyCn = buyCn;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getBbsPrice2() {
		return bbsPrice2;
	}
	public void setBbsPrice2(int bbsPrice2) {
		this.bbsPrice2 = bbsPrice2;
	}
	@Override
	public String toString() {
		return "BuyVO [bbsID=" + bbsID + ", userID=" + userID + ", bbsPrice2=" + bbsPrice2 + ", buyTitle=" + buyTitle
				+ ", buyCn=" + buyCn + ", productSum=" + productSum + ", productDelivery=" + productDelivery
				+ ", userEmail=" + userEmail + ", userName=" + userName + ", userPhone=" + userPhone + ", userAddress="
				+ userAddress + ", userPost=" + userPost + ", buyDate=" + buyDate + "]";
	}

}
