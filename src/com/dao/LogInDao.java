package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dbcon.DbConnection;
import com.bean.LogInBean;

public class LogInDao {

	DbConnection odDbConnection = new DbConnection();
	Connection con = null;

	
	public LogInBean doLogIn(String userName, String password) {
		LogInBean oLogInBean = new LogInBean();
		con = odDbConnection.loadConnection();
		try {
			Statement stmt = con.createStatement();
			CallableStatement cst = con.prepareCall("{CALL HR.LOGIN_ADMIN(?,?,?,?)}");
			cst.setString(1, userName);
			cst.setString(2, password);
			cst.registerOutParameter(3, java.sql.Types.INTEGER);
			cst.registerOutParameter(4, java.sql.Types.VARCHAR);
			try {
				cst.execute();
				oLogInBean.setErrorCode("" + cst.getInt(3));
				oLogInBean.setErrorMessage(cst.getString(4));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return oLogInBean;
	}
	

	public LogInBean getTotalSubject() throws SQLException {
		LogInBean oLogInBean = new LogInBean();
		con = odDbConnection.loadConnection();
		Statement oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		try {
			
			sql = new StringBuffer();
			sql.append("SELECT COUNT(*) FROM HR.SUBJECTS");
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				oLogInBean.setTotalSubject(oRs.getString(1));
					}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return oLogInBean;
	}
	
	
	public LogInBean getTotalClass() throws SQLException {
		LogInBean oLogInBean = new LogInBean();
		con = odDbConnection.loadConnection();
		Statement oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		try {
			
			sql = new StringBuffer();
			sql.append("SELECT COUNT(*) FROM HR.CLASSES");
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				oLogInBean.setTotalClass(oRs.getString(1));
					}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return oLogInBean;
	}
	
	
	public LogInBean getTotalTeacher() throws SQLException {
		LogInBean oLogInBean = new LogInBean();
		con = odDbConnection.loadConnection();
		Statement oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		try {
			
			sql = new StringBuffer();
			sql.append("SELECT COUNT(*) FROM HR.TEACHERS");
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {				
				oLogInBean.setTotalTeacher(oRs.getString(1));
					}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return oLogInBean;
	}
	
	public LogInBean getTotalStudent() throws SQLException {
		LogInBean oLogInBean = new LogInBean();
		con = odDbConnection.loadConnection();
		Statement oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		try {
			
			sql = new StringBuffer();
			sql.append("SELECT COUNT(*) FROM HR.STUDENTS");
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {				
				oLogInBean.setTotalStudent(oRs.getString(1));
					}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return oLogInBean;
	}

}
