package com.bean;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class AssignClassForSubjectBean extends ActionForm {

	private String subjectClassID = "";
	private String subjectID = "";
	private String subjectName = "";
	private ArrayList subjectList = new ArrayList();	
	private String classID = "";
	private ArrayList classIDList = new ArrayList();
	private ArrayList classIDNameList = new ArrayList();
	private String className = "";
	private ArrayList classSubjectList = new ArrayList();
	
	

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

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public ArrayList getClassIDList() {
		return classIDList;
	}

	public void setClassIDList(ArrayList classIDList) {
		this.classIDList = classIDList;
	}

	public ArrayList getClassIDNameList() {
		return classIDNameList;
	}

	public void setClassIDNameList(ArrayList classIDNameList) {
		this.classIDNameList = classIDNameList;
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

	public ArrayList getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList subjectList) {
		this.subjectList = subjectList;
	}

	public ArrayList getClassSubjectList() {
		return classSubjectList;
	}

	public void setClassSubjectList(ArrayList classSubjectList) {
		this.classSubjectList = classSubjectList;
	}

	public String getSubjectClassID() {
		return subjectClassID;
	}

	public void setSubjectClassID(String subjectClassID) {
		this.subjectClassID = subjectClassID;
	}
	
	

}
