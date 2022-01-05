package com.bean;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class ClassReportBean extends ActionForm {

	private String classID = "";
	private String className = "";
	private ArrayList classIDList = new ArrayList();
	private ArrayList classIDNameList = new ArrayList();
	private String teacherID = "";
	private String teacherName = "";
	private String studentID = "";
	private String studentName = "";
	private String subjectID = "";
	private String subjectName = "";
	private ArrayList studentList = new ArrayList();
	private ArrayList classReportList = new ArrayList();

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

	public ArrayList getClassReportList() {
		return classReportList;
	}

	public void setClassReportList(ArrayList classReportList) {
		this.classReportList = classReportList;
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
