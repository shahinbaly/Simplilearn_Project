package com.bean;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class TeacherBean extends ActionForm {
	private String teacherID = "";
	private String teacherName = "";
	private ArrayList teacherList = new ArrayList();

	private String errorMessage = "";
	private String errorCode = "";

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public ArrayList getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(ArrayList teacherList) {
		this.teacherList = teacherList;
	}
	

}
