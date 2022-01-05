package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bo.ClassReportBO;
import com.bo.ClassReportBO;
import com.bo.ClassReportBO;
import com.dbcon.DbConnection;

public class ClassReportDao {

	DbConnection odDbConnection = new DbConnection();
	Connection con = null;
	
	public ClassReportBO loadClassListData() throws Exception {
		ClassReportBO oClassReportBO = new ClassReportBO();
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
			oClassReportBO.setClassIDList(classIDList);
			oClassReportBO.setClassIDNameList(classIDNameList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oClassReportBO;
	}
	public ClassReportBO loadClassReportData() throws Exception {
		ClassReportBO oClassReportBO = new ClassReportBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT A.CLASS_ID,B.CLASS_NAME,"); 
			sql.append("E.ID,E.STUDENT_NAME,");
			sql.append("A.TEACHER_ID,C.TEACHER_NAME ,"); 
			sql.append("A.SUBJECT_ID ,D.SUBJECT_NAME  ");  
			sql.append("FROM HR.SUBJECT_CLAS_TEACHER_MAP A,");
			sql.append("HR.CLASSES B,");
			sql.append("HR.TEACHERS C,");
			sql.append("HR.SUBJECTS D,");
			sql.append("HR.STUDENTS E  "); 
			sql.append("WHERE A.CLASS_ID = B.CLASS_ID    "); 
			sql.append("AND A.TEACHER_ID = C.TEACHER_ID  "); 
			sql.append("AND A.SUBJECT_ID = D.SUBJECT_ID  ");
			sql.append("AND A.CLASS_ID = E.CLASS  ");	
			sql.append("ORDER BY  A.CLASS_ID,A.SUBJECT_ID,A.TEACHER_ID   ");		
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				ClassReportBO oClassReportListBO = new ClassReportBO();
				oClassReportListBO.setClassID(oRs.getString(1));
				oClassReportListBO.setClassName(oRs.getString(2));
				oClassReportListBO.setStudentID(oRs.getString(3));
				oClassReportListBO.setStudentName(oRs.getString(4));
				oClassReportListBO.setTeacherID(oRs.getString(5));
				oClassReportListBO.setTeacherName(oRs.getString(6));
				oClassReportListBO.setSubjectID(oRs.getString(7));
				oClassReportListBO.setSubjectName(oRs.getString(8));
				tempList.add(oClassReportListBO);				
			}
			oClassReportBO.setClassReportList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oClassReportBO;
	}
	public ClassReportBO showClassReportDataForClass(String classID) throws Exception {
		ClassReportBO oClassReportBO = new ClassReportBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT A.CLASS_ID,B.CLASS_NAME,"); 
			sql.append("A.TEACHER_ID,C.TEACHER_NAME ,"); 
			sql.append("A.SUBJECT_ID ,D.SUBJECT_NAME  ");  
			sql.append("FROM HR.SUBJECT_CLAS_TEACHER_MAP A,");
			sql.append("HR.CLASSES B,");
			sql.append("HR.TEACHERS C,");
			sql.append("HR.SUBJECTS D ");
			sql.append("WHERE A.CLASS_ID = B.CLASS_ID    "); 
			sql.append("AND A.TEACHER_ID = C.TEACHER_ID  "); 
			sql.append("AND A.SUBJECT_ID = D.SUBJECT_ID  ");
			sql.append("AND A.CLASS_ID ='"+classID+"' ");	
			sql.append("ORDER BY  A.CLASS_ID,A.SUBJECT_ID,A.TEACHER_ID   ");		
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				ClassReportBO oClassReportListBO = new ClassReportBO();
				oClassReportListBO.setClassID(oRs.getString(1));
				oClassReportListBO.setClassName(oRs.getString(2));
				oClassReportListBO.setTeacherID(oRs.getString(3));
				oClassReportListBO.setTeacherName(oRs.getString(4));
				oClassReportListBO.setSubjectID(oRs.getString(5));
				oClassReportListBO.setSubjectName(oRs.getString(6));
				tempList.add(oClassReportListBO);				
			}
			oClassReportBO.setClassReportList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oClassReportBO;
	}

	public ClassReportBO showStudentDataForClass(String classID) throws Exception {
		ClassReportBO oClassReportBO = new ClassReportBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT ID,STUDENT_NAME   "); 
			sql.append("FROM HR.STUDENTS ");
			sql.append("WHERE CLASS ='"+classID+"' ");	
			sql.append("ORDER BY  ID   ");		
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				ClassReportBO oClassReportSubjectListBO = new ClassReportBO();
				oClassReportSubjectListBO.setStudentID(oRs.getString(1));
				oClassReportSubjectListBO.setStudentName(oRs.getString(2));
				tempList.add(oClassReportSubjectListBO);				
			}
			oClassReportBO.setStudentList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oClassReportBO;
	}

	
	
}
