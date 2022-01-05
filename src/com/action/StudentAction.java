package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.StudentBean;
import com.bo.StudentBO;
import com.dao.StudentDao;

public class StudentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StudentBean oStudentBean = (StudentBean) form;
		StudentDao oStudentDao = new StudentDao();
		StudentBO oStudentBO = new StudentBO();
		String sActionPath = "";
		sActionPath = mapping.getPath();
		HttpSession session = request.getSession(true);
		String sSuccessAction = "success";
		String sFailureAction = "failure";
		String sFatalErrorAction = "fatalError";
		String sSuccess = sFatalErrorAction;

		if (sActionPath.equals("/studentformation")) {
			clearMessage(oStudentBean);
			oStudentBean.setStudentID("");
			oStudentBean.setStudentName("");
			oStudentBean.setClassID("");
			oStudentBean.setClassName("");
			session.setAttribute("errorMessage", oStudentBean.getErrorMessage());
			oStudentBO = oStudentDao.onloadListData();
			oStudentBean.setClassIDList(oStudentBO.getClassIDList());
			oStudentBean.setClassIDNameList(oStudentBO.getClassIDNameList());
			oStudentBO =oStudentDao.loadStudentData();
			session.setAttribute("oStudentDataBO", oStudentBO);
			sSuccess = sSuccessAction;
	
		} 
		else if (sActionPath.equals("/addStudent")) {
			clearMessage(oStudentBean);
			oStudentBO = oStudentDao.addStudent(oStudentBean.getStudentID(), oStudentBean.getStudentName(), oStudentBean.getClassID());
			session.setAttribute("errorMessage", oStudentBO.getErrorMessage());
			oStudentBO =oStudentDao.loadStudentData();
			session.setAttribute("oStudentDataBO", oStudentBO);
			oStudentBean.setStudentID("");
			oStudentBean.setStudentName("");
			oStudentBean.setClassID("");
			oStudentBean.setClassName("");
			sSuccess = sSuccessAction;
		}
		return mapping.findForward(sSuccess);
	}
	private void clearMessage(StudentBean oStudentBean) {
		oStudentBean.setErrorCode("");
		oStudentBean.setErrorMessage("");
	}

}
