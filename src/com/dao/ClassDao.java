package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbcon.DbConnection;
import com.bean.ClassBean;


public class ClassDao {

	DbConnection odDbConnection = new DbConnection();
	Connection con = null;

	
	public ClassBean addClass(String classID, String className) {
		ClassBean oClassBean = new ClassBean();
		con = odDbConnection.loadConnection();
		try {
			Statement stmt = con.createStatement();
			CallableStatement cst = con.prepareCall("{CALL HR.ADD_CLASS(?,?,?)}");
			cst.setString(1, classID);
			cst.setString(2, className);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			try {
				cst.execute();
				oClassBean.setErrorMessage(cst.getString(3));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return oClassBean;
	}
	
	public ClassBean loadClassData() throws Exception {
		ClassBean oClassBean = new ClassBean();
		Statement oStmt = null;
		con = odDbConnection.loadConnection();
		oStmt = con.createStatement();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList tempList = new ArrayList();
		try {
			sql = new StringBuffer();
			sql.append("SELECT CLASS_ID,");
			sql.append("CLASS_NAME "); 
		    sql.append("FROM HR.CLASSES  ");
			sql.append("ORDER BY CLASS_ID");			
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				ClassBean oClassListBean = new ClassBean();
				oClassListBean.setClassID(oRs.getString(1));
				oClassListBean.setClassName(oRs.getString(2));				
				tempList.add(oClassListBean);				
			}
			oClassBean.setClassList(tempList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oClassBean;
	}


}
