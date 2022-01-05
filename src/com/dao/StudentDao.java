package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.dbcon.DbConnection;
import com.bo.StudentBO;

public class StudentDao {

	DbConnection odDbConnection = new DbConnection();
	Connection con = null;

	public StudentBO onloadListData() throws Exception {
		StudentBO oStudentBO = new StudentBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ArrayList classIDList = new ArrayList();
		ArrayList classIDNameList = new ArrayList();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		try {
			sql = new StringBuffer();
			sql.append("SELECT NVL(CLASS_ID,''),NVL(CLASS_NAME,'') FROM HR.CLASSES ORDER BY CLASS_ID");			
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				classIDList.add(oRs.getString(1));
				classIDNameList.add(oRs.getString(2));				
			}
			oStudentBO.setClassIDList(classIDList);
			oStudentBO.setClassIDNameList(classIDNameList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oStudentBO;
	}

	public StudentBO addStudent(String studentID, String studentName, String classID) {
		StudentBO oStudentBO = new StudentBO();
		con = odDbConnection.loadConnection();
		try {
			Statement stmt = con.createStatement();
			CallableStatement cst = con.prepareCall("{CALL HR.ADD_STUDENTS(?,?,?,?)}");
			cst.setString(1, studentID);
			cst.setString(2, studentName);
			cst.setString(3, classID);
			cst.registerOutParameter(4, java.sql.Types.VARCHAR);
			try {
				cst.execute();
				oStudentBO.setErrorMessage(cst.getString(4));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oStudentBO;
	}
	public StudentBO loadStudentData() throws Exception {
		StudentBO oStudentBO = new StudentBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT A.ID, A.STUDENT_NAME,B.CLASS_NAME FROM HR.STUDENTS A , HR.CLASSES B WHERE A.CLASS = B.CLASS_ID ORDER BY TO_NUMBER(A.ID)"); 
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				StudentBO oAssignTeacherTeacherBO = new StudentBO();
				oAssignTeacherTeacherBO.setStudentID(oRs.getString(1));
				oAssignTeacherTeacherBO.setStudentName(oRs.getString(2));
				oAssignTeacherTeacherBO.setClassName(oRs.getString(3));
				tempList.add(oAssignTeacherTeacherBO);				
			}
			oStudentBO.setStudentList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oStudentBO;
	}

}
