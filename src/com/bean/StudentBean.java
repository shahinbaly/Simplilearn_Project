package com.bean;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class StudentBean extends ActionForm {
	private String studentID = "";
	private String studentName = "";
	private ArrayList studentList = new ArrayList();
	private String classID = "";
	private ArrayList classIDList = new ArrayList();
	private ArrayList classIDNameList = new ArrayList();
	private String className = "";

	private String errorMessage = "";
	private String errorCode = "";

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public ArrayList getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList studentList) {
		this.studentList = studentList;
	}
	

}
