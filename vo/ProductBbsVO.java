package com.recipe.common.vo;

public class ProductBbsVO {
	private int bbsID;
	private String bbsTitle;
	private String userNickName;
	private String bbsDate;
	private String bbsContent;
	private int bbsAvailable;
	private String bbsCategory1;
	private String bbsFileName;
	private int bbsHit;
	private int bbsStar;
	private int bbsReviewC;
	private String userID;
	private String bbsPrice;
	private String bbsPriceDC;
	private int bbsPrice2;
	private String bbsStock;
	
	public String getBbsStock() {
		return bbsStock;
	}
	public void setBbsStock(String bbsStock) {
		this.bbsStock = bbsStock;
	}
	public int getBbsPrice2() {
		return bbsPrice2;
	}
	public void setBbsPrice2(int bbsPrice2) {
		this.bbsPrice2 = bbsPrice2;
	}
	public String getBbsPrice() {
		return bbsPrice;
	}
	public void setBbsPrice(String bbsPrice) {
		this.bbsPrice = bbsPrice;
	}
	public String getBbsPriceDC() {
		return bbsPriceDC;
	}
	public void setBbsPriceDC(String bbsPriceDC) {
		this.bbsPriceDC = bbsPriceDC;
	}
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public int getBbsAvailable() {
		return bbsAvailable;
	}
	public void setBbsAvailable(int bbsAvailable) {
		this.bbsAvailable = bbsAvailable;
	}
	public String getBbsCategory1() {
		return bbsCategory1;
	}
	public void setBbsCategory1(String bbsCategory1) {
		this.bbsCategory1 = bbsCategory1;
	}
	public String getBbsFileName() {
		return bbsFileName;
	}
	public void setBbsFileName(String bbsFileName) {
		this.bbsFileName = bbsFileName;
	}
	public int getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}
	public int getBbsStar() {
		return bbsStar;
	}
	public void setBbsStar(int bbsStar) {
		this.bbsStar = bbsStar;
	}
	public int getBbsReviewC() {
		return bbsReviewC;
	}
	public void setBbsReviewC(int bbsReviewC) {
		this.bbsReviewC = bbsReviewC;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "ProductBbsVO [bbsID=" + bbsID + ", bbsTitle=" + bbsTitle + ", userNickName=" + userNickName
				+ ", bbsDate=" + bbsDate + ", bbsContent=" + bbsContent + ", bbsAvailable=" + bbsAvailable
				+ ", bbsCategory1=" + bbsCategory1 + ", bbsFileName=" + bbsFileName + ", bbsHit=" + bbsHit + ", bbsStar="
				+ bbsStar + ", bbsReviewC=" + bbsReviewC + ", userID=" + userID + ", bbsPrice=" + bbsPrice
				+ ", bbsPriceDC=" + bbsPriceDC + ", bbsPrice2=" + bbsPrice2 + ", bbsStock=" + bbsStock + "]";
	}

}
