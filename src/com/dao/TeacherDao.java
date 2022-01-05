package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbcon.DbConnection;
import com.bean.TeacherBean;

public class TeacherDao {

	DbConnection odDbConnection = new DbConnection();
	Connection con = null;
	
	public TeacherBean loadTeacherData() throws Exception {
		TeacherBean oTeacherBean = new TeacherBean();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT TEACHER_ID, TEACHER_NAME FROM HR.TEACHERS ORDER BY  TEACHER_ID"); 
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				TeacherBean oAssignTeacherTeacherBO = new TeacherBean();
				oAssignTeacherTeacherBO.setTeacherID(oRs.getString(1));
				oAssignTeacherTeacherBO.setTeacherName(oRs.getString(2));
				tempList.add(oAssignTeacherTeacherBO);				
			}
			oTeacherBean.setTeacherList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oTeacherBean;
	}


	
	public TeacherBean addTeacher(String teacherID, String teacherName) {
		TeacherBean oTeacherBean = new TeacherBean();
		con = odDbConnection.loadConnection();
		try {
			Statement stmt = con.createStatement();
			CallableStatement cst = con.prepareCall("{CALL HR.ADD_TEACHERS(?,?,?)}");
			cst.setString(1, teacherID);
			cst.setString(2, teacherName);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			try {
				cst.execute();
				oTeacherBean.setErrorMessage(cst.getString(3));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return oTeacherBean;
	}

}
