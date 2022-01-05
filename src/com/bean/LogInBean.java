package com.bean;

import org.apache.struts.action.ActionForm;

public class LogInBean extends ActionForm{
	
	private String totalStudent ="";
	private String totalTeacher ="";
	private String totalClass ="";
	private String totalSubject ="";

	private String username ="";
	 private String password = "";
	 private String errorMessage = "";
	 private String errorCode = "";
	 
	 
	 
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the totalStudent
	 */
	public String getTotalStudent() {
		return totalStudent;
	}
	/**
	 * @param totalStudent the totalStudent to set
	 */
	public void setTotalStudent(String totalStudent) {
		this.totalStudent = totalStudent;
	}
	/**
	 * @return the totalTeacher
	 */
	public String getTotalTeacher() {
		return totalTeacher;
	}
	/**
	 * @param totalTeacher the totalTeacher to set
	 */
	public void setTotalTeacher(String totalTeacher) {
		this.totalTeacher = totalTeacher;
	}
	/**
	 * @return the totalClass
	 */
	public String getTotalClass() {
		return totalClass;
	}
	/**
	 * @param totalClass the totalClass to set
	 */
	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}
	
	
	
	 /**
	 * @return the totalSubject
	 */
	public String getTotalSubject() {
		return totalSubject;
	}
	/**
	 * @param totalSubject the totalSubject to set
	 */
	public void setTotalSubject(String totalSubject) {
		this.totalSubject = totalSubject;
	}

}
