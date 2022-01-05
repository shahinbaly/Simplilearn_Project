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
import com.bo.AssignTeacherBO;

public class AssignTeacherDao {

	DbConnection odDbConnection = new DbConnection();
	Connection con = null;

	public AssignTeacherBO loadTeacherListData() throws Exception {
		AssignTeacherBO oAssignTeacherBO = new AssignTeacherBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ArrayList teacherIDList = new ArrayList();
		ArrayList teacherIDNameList = new ArrayList();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		try {
			sql = new StringBuffer();
			sql.append("SELECT TEACHER_ID,TEACHER_NAME FROM HR.TEACHERS ORDER BY TEACHER_ID");			
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				teacherIDList.add(oRs.getString(1));
				teacherIDNameList.add(oRs.getString(2));	
			}
			oAssignTeacherBO.setTeacherIDList(teacherIDList);
			oAssignTeacherBO.setTeacherIDNameList(teacherIDNameList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignTeacherBO;
	}
	public AssignTeacherBO loadClassListData() throws Exception {
		AssignTeacherBO oAssignTeacherBO = new AssignTeacherBO();
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
			oAssignTeacherBO.setClassIDList(classIDList);
			oAssignTeacherBO.setClassIDNameList(classIDNameList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignTeacherBO;
	}
	public AssignTeacherBO loadSubjectData() throws Exception {
		AssignTeacherBO oAssignTeacherBO = new AssignTeacherBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT NVL(SUBJECT_ID,''),NVL(SUBJECT_NAME,'') FROM HR.SUBJECTS ORDER BY SUBJECT_ID");			
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				AssignTeacherBO oAssignTeacherSubjectBO = new AssignTeacherBO();
				oAssignTeacherSubjectBO.setSubjectID(oRs.getString(1));
				oAssignTeacherSubjectBO.setSubjectName(oRs.getString(2));
				tempList.add(oAssignTeacherSubjectBO);				
			}
			oAssignTeacherBO.setSubjectList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignTeacherBO;
	}
	
	public AssignTeacherBO loadClassSubjectData(String classID) throws Exception {
		AssignTeacherBO oAssignTeacherBO = new AssignTeacherBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT A.SUBJECT_ID,B.SUBJECT_NAME "); 
			sql.append("FROM HR.SUBJECT_CLAS_MAP A,HR.SUBJECTS B "); 
			sql.append("WHERE CLASS_ID ='"+classID+"' "); 
			sql.append("AND A.SUBJECT_ID =B.SUBJECT_ID "); 
			sql.append("ORDER BY A.SUBJECT_ID");			
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				AssignTeacherBO oAssignTeacherSubjectBO = new AssignTeacherBO();
				oAssignTeacherSubjectBO.setSubjectID(oRs.getString(1));
				oAssignTeacherSubjectBO.setSubjectName(oRs.getString(2));
				tempList.add(oAssignTeacherSubjectBO);				
			}
			oAssignTeacherBO.setSubjectList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignTeacherBO;
	}

	
	public AssignTeacherBO assignTeacher(String teacherID,String classID,String  subjectID) {
		
		AssignTeacherBO oAssignTeacherBO = new AssignTeacherBO();
		con = odDbConnection.loadConnection();
		CallableStatement cst = null;
		try {					
			
			Statement stmt = con.createStatement();
			cst = con.prepareCall("{CALL HR.ASSIGN_TEACH_CLAS_SUB(?,?,?,?)}");
			cst.setString(1, teacherID);
			cst.setString(2, classID);
			cst.setString(3, subjectID);
			cst.registerOutParameter(4, java.sql.Types.VARCHAR);
			
		
			try {
				cst.execute();
				oAssignTeacherBO.setErrorMessage(cst.getString(4));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignTeacherBO;
	}
	
	public AssignTeacherBO loadAssignedTeacherData() throws Exception {
		AssignTeacherBO oAssignTeacherBO = new AssignTeacherBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT A.SUB_CLASS_TEACH_ID,");
			sql.append("A.TEACHER_ID,");
			sql.append("B.TEACHER_NAME,");
			sql.append("A.SUBJECT_ID,");
			sql.append("C.SUBJECT_NAME,");
			sql.append("A.CLASS_ID,");
			sql.append("D.CLASS_NAME "); 
		    sql.append("FROM HR.SUBJECT_CLAS_TEACHER_MAP A,");
			sql.append("HR.TEACHERS B,");
			sql.append("HR.SUBJECTS C,");
			sql.append("HR.CLASSES D ");
			sql.append("WHERE A.TEACHER_ID =B.TEACHER_ID "); 
			sql.append("AND A.SUBJECT_ID = C.SUBJECT_ID ");
			sql.append("AND A.CLASS_ID = D.CLASS_ID  ");	
			sql.append("ORDER BY A.CLASS_ID,A.SUBJECT_ID, A.TEACHER_ID ");	
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				AssignTeacherBO oAssignTeacherListBO = new AssignTeacherBO();
				oAssignTeacherListBO.setAssignTeacherID(oRs.getString(1));
				oAssignTeacherListBO.setTeacherID(oRs.getString(2));
				oAssignTeacherListBO.setTeacherName(oRs.getString(3));
				oAssignTeacherListBO.setSubjectID(oRs.getString(4));
				oAssignTeacherListBO.setSubjectName(oRs.getString(5));
				oAssignTeacherListBO.setClassID(oRs.getString(6));
				oAssignTeacherListBO.setClassName(oRs.getString(7));	
				tempList.add(oAssignTeacherListBO);				
			}
			oAssignTeacherBO.setAssignedTeacherList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignTeacherBO;
	}


}
