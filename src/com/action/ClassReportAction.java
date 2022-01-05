package com.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.ClassReportBean;
import com.bo.ClassReportBO;
import com.dao.ClassReportDao;

public class ClassReportAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ClassReportBean oClassReportBean = (ClassReportBean) form;
		ClassReportDao oClassReportDao = new ClassReportDao();
		ClassReportBO oClassReportBO = new ClassReportBO();
		String sActionPath = "";
		sActionPath = mapping.getPath();
		HttpSession session = request.getSession(true);
		String sSuccessAction = "success";
		String sFailureAction = "failure";
		String sFatalErrorAction = "fatalError";
		String sSuccess = sFatalErrorAction;

		if (sActionPath.equals("/classReport")) {
			clearMessage(oClassReportBean);
			oClassReportBean.setClassID("");
			session.setAttribute("errorMessage", oClassReportBean.getErrorMessage());
			oClassReportBO = oClassReportDao.loadClassListData();
			oClassReportBean.setClassIDList(oClassReportBO.getClassIDList());
			oClassReportBean.setClassIDNameList(oClassReportBO.getClassIDNameList());
			session.setAttribute("gsClass", "Select Class to view Details.");
			ArrayList atempList = new ArrayList();
			
			oClassReportBean.setClassReportList(atempList);				
			oClassReportBean.setStudentList(atempList);
			sSuccess = sSuccessAction;

		} 
		else if (sActionPath.equals("/viewClassReport")) {
			clearMessage(oClassReportBean);
			session.setAttribute("gsClass","CLASS :  "+ oClassReportBean.getClassID());
			oClassReportBO = oClassReportDao.showClassReportDataForClass(oClassReportBean.getClassID());
			oClassReportBean.setClassReportList(oClassReportBO.getClassReportList());
			
			oClassReportBO = oClassReportDao.showStudentDataForClass(oClassReportBean.getClassID());
			oClassReportBean.setStudentList(oClassReportBO.getStudentList());
			sSuccess = sSuccessAction;

		}
		return mapping.findForward(sSuccess);
	}
	private void clearMessage(ClassReportBean oClassReportBean) {
		oClassReportBean.setErrorCode("");
		oClassReportBean.setErrorMessage("");
	}

}
