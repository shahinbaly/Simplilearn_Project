package com.bean;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class SubjectBean extends ActionForm {
	private String subjectID = "";
	private String subjectName = "";
	private ArrayList subjectList = new ArrayList();

	private String errorMessage = "";
	private String errorCode = "";
	
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	public ArrayList getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(ArrayList subjectList) {
		this.subjectList = subjectList;
	}
	



}
