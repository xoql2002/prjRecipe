package com.recipe.common.vo;

public class BasketVO {
	private int bbsID;
	private String userID;
	private String bbsPrice;
	private String bbsPriceDC;
	private int bbsPrice2;
	private int bbsStock;
	private int productCn;
	private String bbsTitle;
	private String bbsFileName;
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsFileName() {
		return bbsFileName;
	}
	public void setBbsFileName(String bbsFileName) {
		this.bbsFileName = bbsFileName;
	}
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public int getBbsPrice2() {
		return bbsPrice2;
	}
	public void setBbsPrice2(int bbsPrice2) {
		this.bbsPrice2 = bbsPrice2;
	}
	public int getBbsStock() {
		return bbsStock;
	}
	public void setBbsStock(int bbsStock) {
		this.bbsStock = bbsStock;
	}
	public int getProductCn() {
		return productCn;
	}
	public void setProductCn(int productCn) {
		this.productCn = productCn;
	}
	@Override
	public String toString() {
		return "BasketVO [bbsID=" + bbsID + ", userID=" + userID + ", bbsPrice=" + bbsPrice + ", bbsPriceDC="
				+ bbsPriceDC + ", bbsPrice2=" + bbsPrice2 + ", bbsStock=" + bbsStock + ", productCn=" + productCn
				+ ", bbsTitle=" + bbsTitle + ", bbsFileName=" + bbsFileName + "]";
	}
}
