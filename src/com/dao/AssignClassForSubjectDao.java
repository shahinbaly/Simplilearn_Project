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
import com.bo.AssignClassForSubjectBO;

public class AssignClassForSubjectDao {

	DbConnection odDbConnection = new DbConnection();
	Connection con = null;

	public AssignClassForSubjectBO loadClassListData() throws Exception {
		AssignClassForSubjectBO oAssignClassForSubjectBO = new AssignClassForSubjectBO();
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
			oAssignClassForSubjectBO.setClassIDList(classIDList);
			oAssignClassForSubjectBO.setClassIDNameList(classIDNameList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignClassForSubjectBO;
	}
	public AssignClassForSubjectBO loadSubjectData() throws Exception {
		AssignClassForSubjectBO oAssignClassForSubjectBO = new AssignClassForSubjectBO();
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
				AssignClassForSubjectBO oAssignClassForSubjectSubjectBO = new AssignClassForSubjectBO();
				oAssignClassForSubjectSubjectBO.setSubjectID(oRs.getString(1));
				oAssignClassForSubjectSubjectBO.setSubjectName(oRs.getString(2));
				tempList.add(oAssignClassForSubjectSubjectBO);				
			}
			oAssignClassForSubjectBO.setSubjectList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignClassForSubjectBO;
	}

	
	public AssignClassForSubjectBO assignSubject(String classID,String subjectID) {
		AssignClassForSubjectBO oAssignClassForSubjectBO = new AssignClassForSubjectBO();
		
		con = odDbConnection.loadConnection();
		//AssignClassForSubjectBO oAssignClassForSubjectListBO = new AssignClassForSubjectBO();			
		try {
			//for(int i = 0;i<subjectList.size();i++) {
				
			Statement stmt = con.createStatement();
			CallableStatement cst = null;
			
				//oAssignClassForSubjectListBO =(AssignClassForSubjectBO) subjectList.get(i);
				cst = con.prepareCall("{CALL HR.ASSIGN_CLASS_SUBJECT(?,?,?)}");
				cst.setString(1, classID);
				cst.setString(2, subjectID);
				cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			
			try {
				cst.execute();
				oAssignClassForSubjectBO.setErrorMessage(cst.getString(3));
			} catch (Exception e) {
				e.printStackTrace();
			}
		// }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignClassForSubjectBO;
	}
	public AssignClassForSubjectBO loadClassSubjectData() throws Exception {
		AssignClassForSubjectBO oAssignClassForSubjectBO = new AssignClassForSubjectBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT A.SUB_CLASS_ID,A.CLASS_ID ,C.CLASS_NAME,A.SUBJECT_ID,B.SUBJECT_NAME "); 
		    sql.append("FROM HR.SUBJECT_CLAS_MAP  A,"); 
			sql.append("HR.SUBJECTS B,"); 
			sql.append("HR.CLASSES C "); 
			sql.append("where A.SUBJECT_ID = B.SUBJECT_ID "); 
			sql.append("AND A.CLASS_ID = C.CLASS_ID "); 
			sql.append("ORDER BY A.CLASS_ID,A.SUBJECT_ID"); 
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				AssignClassForSubjectBO oAssignClassForClassSubjectBO = new AssignClassForSubjectBO();
				oAssignClassForClassSubjectBO.setSubjectClassID(oRs.getString(1));
				oAssignClassForClassSubjectBO.setClassID(oRs.getString(2));
				oAssignClassForClassSubjectBO.setClassName(oRs.getString(3));
				oAssignClassForClassSubjectBO.setSubjectID(oRs.getString(4));
				oAssignClassForClassSubjectBO.setSubjectName(oRs.getString(5));	
				tempList.add(oAssignClassForClassSubjectBO);				
			}
			oAssignClassForSubjectBO.setClassSubjectList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignClassForSubjectBO;
	}
	public AssignClassForSubjectBO showListClassSubjectData(String classID) throws Exception {
		AssignClassForSubjectBO oAssignClassForSubjectBO = new AssignClassForSubjectBO();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT  A.SUBJECT_ID,B.SUBJECT_NAME "); 
			sql.append("FROM HR.SUBJECT_CLAS_MAP  A,"); 
			sql.append("HR.SUBJECTS B "); 
			sql.append("WHERE A.SUBJECT_ID = B.SUBJECT_ID "); 
			sql.append("AND A.CLASS_ID = '"+classID+"' "); 
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
					AssignClassForSubjectBO oAssignClassForSubjectSubjectBO = new AssignClassForSubjectBO();
					oAssignClassForSubjectSubjectBO.setSubjectID(oRs.getString(1));
					oAssignClassForSubjectSubjectBO.setSubjectName(oRs.getString(2));
					tempList.add(oAssignClassForSubjectSubjectBO);				
				}
				oAssignClassForSubjectBO.setSubjectList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oAssignClassForSubjectBO;
	}


}
