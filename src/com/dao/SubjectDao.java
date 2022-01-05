package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.Subject;

import com.dbcon.DbConnection;
import com.bean.SubjectBean;

public class SubjectDao {

	DbConnection odDbConnection = new DbConnection();
	Connection con = null;
	
	public SubjectBean loadSubjectData() throws Exception {
		SubjectBean oSubjectBean = new SubjectBean();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT  SUBJECT_ID, SUBJECT_NAME FROM  HR.SUBJECTS ORDER BY SUBJECT_ID"); 
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				SubjectBean oAssignTeacherSubjectBO = new SubjectBean();
				oAssignTeacherSubjectBO.setSubjectID(oRs.getString(1));
				oAssignTeacherSubjectBO.setSubjectName(oRs.getString(2));
				tempList.add(oAssignTeacherSubjectBO);				
			}
			oSubjectBean.setSubjectList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oSubjectBean;
	}

	
	public SubjectBean addSubject(String subjectID, String subjectName) {
		SubjectBean oSubjectBean = new SubjectBean();
		con = odDbConnection.loadConnection();
		try {
			Statement stmt = con.createStatement();
			CallableStatement cst = con.prepareCall("{CALL HR.ADD_SUBJECT(?,?,?)}");
			cst.setString(1, subjectID);
			cst.setString(2, subjectName);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			try {
				cst.execute();
				oSubjectBean.setErrorMessage(cst.getString(3));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return oSubjectBean;
	}

}
