package com.bo;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class AssignTeacherBO extends ValidatorForm {
	
	private String assignTeacherID = "";
	private String subjectID = "";
	private String subjectName = "";
	private ArrayList subjectList = new ArrayList();
	private String classID = "";
	private ArrayList classIDList = new ArrayList();
	private ArrayList classIDNameList = new ArrayList();
	private String className = "";
	private String teacherID = "";
	private ArrayList teacherIDList = new ArrayList();
	private ArrayList teacherIDNameList = new ArrayList();
	private String teacherName = "";
	private ArrayList assignedTeacherList = new ArrayList();
	
	

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

	public ArrayList getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList subjectList) {
		this.subjectList = subjectList;
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

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public ArrayList getTeacherIDList() {
		return teacherIDList;
	}

	public void setTeacherIDList(ArrayList teacherIDList) {
		this.teacherIDList = teacherIDList;
	}

	public ArrayList getTeacherIDNameList() {
		return teacherIDNameList;
	}

	public void setTeacherIDNameList(ArrayList teacherIDNameList) {
		this.teacherIDNameList = teacherIDNameList;
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

	public ArrayList getAssignedTeacherList() {
		return assignedTeacherList;
	}

	public void setAssignedTeacherList(ArrayList assignedTeacherList) {
		this.assignedTeacherList = assignedTeacherList;
	}

	public String getAssignTeacherID() {
		return assignTeacherID;
	}

	public void setAssignTeacherID(String assignTeacherID) {
		this.assignTeacherID = assignTeacherID;
	}
	
	

}
