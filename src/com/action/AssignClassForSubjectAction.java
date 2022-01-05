package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.AssignClassForSubjectBean;
import com.bo.AssignClassForSubjectBO;
import com.dao.AssignClassForSubjectDao;

public class AssignClassForSubjectAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AssignClassForSubjectBean oAssignClassForSubjectBean = (AssignClassForSubjectBean) form;
		AssignClassForSubjectDao oAssignClassForSubjectDao = new AssignClassForSubjectDao();
		AssignClassForSubjectBO oAssignClassForSubjectBO = new AssignClassForSubjectBO();
		String sActionPath = "";
		sActionPath = mapping.getPath();
		HttpSession session = request.getSession(true);
		String sSuccessAction = "success";
		String sFailureAction = "failure";
		String sFatalErrorAction = "fatalError";
		String sSuccess = sFatalErrorAction;
		if (sActionPath.equals("/assignClassForSubject")) {
			clearMessage(oAssignClassForSubjectBean);
			oAssignClassForSubjectBean.setSubjectID("");
			oAssignClassForSubjectBean.setSubjectName("");
			oAssignClassForSubjectBean.setClassID("");
			oAssignClassForSubjectBean.setClassName("");
			
			
			oAssignClassForSubjectBO = oAssignClassForSubjectDao.loadClassSubjectData();
			session.setAttribute("oAssignClassForSubjectClassBO", oAssignClassForSubjectBO);
			
			
			
			session.setAttribute("errorMessage", oAssignClassForSubjectBean.getErrorMessage());
			oAssignClassForSubjectBO = oAssignClassForSubjectDao.loadClassListData();
			oAssignClassForSubjectBean.setClassIDList(oAssignClassForSubjectBO.getClassIDList());
			oAssignClassForSubjectBean.setClassIDNameList(oAssignClassForSubjectBO.getClassIDNameList());
			
			oAssignClassForSubjectBO =oAssignClassForSubjectDao.loadSubjectData();
			oAssignClassForSubjectBean.setSubjectList(oAssignClassForSubjectBO.getSubjectList());
			session.setAttribute("oAssignClassForSubjectSubjectBO", oAssignClassForSubjectBO);
			sSuccess = sSuccessAction;
	
		} 
		else if (sActionPath.equals("/addClassForSubject")) {
			clearMessage(oAssignClassForSubjectBean);
			oAssignClassForSubjectBO = oAssignClassForSubjectDao.assignSubject(oAssignClassForSubjectBean.getClassID(), oAssignClassForSubjectBean.getSubjectID());
			session.setAttribute("errorMessage", oAssignClassForSubjectBO.getErrorMessage());
			oAssignClassForSubjectBO = oAssignClassForSubjectDao.loadClassSubjectData();
			session.setAttribute("oAssignClassForSubjectClassBO", oAssignClassForSubjectBO);
			sSuccess = sSuccessAction;
		}
		else if (sActionPath.equals("/showListClassForSubject")) {
			clearMessage(oAssignClassForSubjectBean);
		//	oAssignClassForSubjectBO =oAssignClassForSubjectDao.showListClassSubjectData(oAssignClassForSubjectBean.getClassID());
		//	oAssignClassForSubjectBean.setSubjectList(oAssignClassForSubjectBO.getSubjectList());
		//	session.setAttribute("oAssignClassForSubjectSubjectBO", oAssignClassForSubjectBO);
			
			oAssignClassForSubjectBO = oAssignClassForSubjectDao.loadClassSubjectData();
			session.setAttribute("oAssignClassForSubjectClassBO", oAssignClassForSubjectBO);
			sSuccess = sSuccessAction;
		}
		return mapping.findForward(sSuccess);
	}
	private void clearMessage(AssignClassForSubjectBean oAssignClassForSubjectBean) {
		oAssignClassForSubjectBean.setErrorCode("");
		oAssignClassForSubjectBean.setErrorMessage("");
	}

}
