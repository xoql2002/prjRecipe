package com.recipe.common.vo;

public class BbsVO {
	private int bbsID;
	private String bbsTitle;
	private String userNickName;
	private String bbsDate;
	private String bbsContent;
	private int bbsAvailable;
	private String bbsPeopleNum;
	private String bbsCategory1;
	private String bbsCookTime;
	private String bbsFileName;
	private int bbsHit;
	private int bbsReco;
	private String bbsIgd;
	private int bbsStar;
	private int bbsReviewC;
	private String userID;

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getBbsReviewC() {
		return bbsReviewC;
	}
	public void setBbsReviewC(int bbsReviewC) {
		this.bbsReviewC = bbsReviewC;
	}
	public int getBbsStar() {
		return bbsStar;
	}
	public void setBbsStar(int bbsStar) {
		this.bbsStar = bbsStar;
	}
	public String getBbsIgd() {
		return bbsIgd;
	}
	public void setBbsIgd(String bbsIgd) {
		this.bbsIgd = bbsIgd;
	}
	public int getBbsReco() {
		return bbsReco;
	}
	public void setBbsReco(int bbsReco) {
		this.bbsReco = bbsReco;
	}
	public int getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}
	public String getBbsFileName() {
		return bbsFileName;
	}
	public void setBbsFileName(String bbsFileName) {
		this.bbsFileName = bbsFileName;
	}
	public String getBbsCategory1() {
		return bbsCategory1;
	}
	public void setBbsCategory1(String bbsCategory1) {
		this.bbsCategory1 = bbsCategory1;
	}
	public String getBbsCookTime() {
		return bbsCookTime;
	}
	public void setBbsCookTime(String bbsCookTime) {
		this.bbsCookTime = bbsCookTime;
	}
	public String getBbsPeopleNum() {
		return bbsPeopleNum;
	}
	public void setBbsPeopleNum(String bbsPeopleNum) {
		this.bbsPeopleNum = bbsPeopleNum;
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
	@Override
	public String toString() {
		return "BbsVO [bbsID=" + bbsID + ", bbsTitle=" + bbsTitle + ", userNickName=" + userNickName + ", bbsDate="
				+ bbsDate + ", bbsContent=" + bbsContent + ", bbsAvailable=" + bbsAvailable + ", bbsPeopleNum="
				+ bbsPeopleNum + ", bbsCategory1=" + bbsCategory1 + ", bbsCookTime=" + bbsCookTime + ", bbsFileName="
				+ bbsFileName + ", bbsHit=" + bbsHit + ", bbsReco=" + bbsReco + ", bbsIgd=" + bbsIgd + ", bbsStar="
				+ bbsStar + ", bbsReviewC=" + bbsReviewC + ", userID=" + userID + "]";
	}

}
