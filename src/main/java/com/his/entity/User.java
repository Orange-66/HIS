package com.his.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable
{	
	private Integer userID;
	private String userName;
	private String password;
	private String realName;
	private Integer userType;
	private Integer titleID;
	private String onduty;
	private Integer depID;
	private Integer levID;
	private Integer isDelete;
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getTitleID() {
		return titleID;
	}
	public void setTitleID(Integer titleID) {
		this.titleID = titleID;
	}
	public String getOnduty() {
		return onduty;
	}
	public void setOnduty(String onduty) {
		this.onduty = onduty;
	}
	public Integer getDepID() {
		return depID;
	}
	public void setDepID(Integer depID) {
		this.depID = depID;
	}
	public Integer getLevID() {
		return levID;
	}
	public void setLevID(Integer levID) {
		this.levID = levID;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", realName=" + realName
				+ ", userType=" + userType + ", titleID=" + titleID + ", onduty=" + onduty + ", depID=" + depID
				+ ", levID=" + levID + ", isDelete=" + isDelete + "]";
	}

		
}
