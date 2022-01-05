package com.bean;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class ClassBean extends ActionForm {
	private String classID = "";
	private String className = "";
	private ArrayList classList = new ArrayList();

	private String errorMessage = "";
	private String errorCode = "";
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public ArrayList getClassList() {
		return classList;
	}
	public void setClassList(ArrayList classList) {
		this.classList = classList;
	}
	
	
	
}
