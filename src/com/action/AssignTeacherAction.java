package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.AssignTeacherBean;
import com.bo.AssignTeacherBO;
import com.dao.AssignTeacherDao;

public class AssignTeacherAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AssignTeacherBean oAssignTeacherBean = (AssignTeacherBean) form;
		AssignTeacherDao oAssignTeacherDao = new AssignTeacherDao();
		AssignTeacherBO oAssignTeacherBO = new AssignTeacherBO();
		String sActionPath = "";
		sActionPath = mapping.getPath();
		HttpSession session = request.getSession(true);
		String sSuccessAction = "success";
		String sFailureAction = "failure";
		String sFatalErrorAction = "fatalError";
		String sSuccess = sFatalErrorAction;
		
		if (sActionPath.equals("/assignTeacher")) {
			clearMessage(oAssignTeacherBean);
			oAssignTeacherBean.setTeacherID("");
			oAssignTeacherBean.setTeacherName("");
			oAssignTeacherBean.setSubjectID("");
			oAssignTeacherBean.setSubjectName("");
			oAssignTeacherBean.setClassID("");
			oAssignTeacherBean.setClassName("");
			session.setAttribute("errorMessage", oAssignTeacherBean.getErrorMessage());
			
			oAssignTeacherBO = oAssignTeacherDao.loadAssignedTeacherData();
			oAssignTeacherBean.setAssignedTeacherList(oAssignTeacherBO.getAssignedTeacherList());
			
			oAssignTeacherBO = oAssignTeacherDao.loadTeacherListData();
			oAssignTeacherBean.setTeacherIDList(oAssignTeacherBO.getTeacherIDList());
			oAssignTeacherBean.setTeacherIDNameList(oAssignTeacherBO.getTeacherIDNameList());
			
			oAssignTeacherBO = oAssignTeacherDao.loadClassListData();
			oAssignTeacherBean.setClassIDList(oAssignTeacherBO.getClassIDList());
			oAssignTeacherBean.setClassIDNameList(oAssignTeacherBO.getClassIDNameList());
			
			oAssignTeacherBO =oAssignTeacherDao.loadSubjectData();
			oAssignTeacherBean.setSubjectList(oAssignTeacherBO.getSubjectList());
			sSuccess = sSuccessAction;
	
		} 
		else if (sActionPath.equals("/loadSubjectForClass")) {
			clearMessage(oAssignTeacherBean);
			oAssignTeacherBO = oAssignTeacherDao.loadClassSubjectData(oAssignTeacherBean.getClassID());
			oAssignTeacherBean.setSubjectList(oAssignTeacherBO.getSubjectList());
			
			oAssignTeacherBO = oAssignTeacherDao.loadAssignedTeacherData();
			oAssignTeacherBean.setAssignedTeacherList(oAssignTeacherBO.getAssignedTeacherList());
			sSuccess = sSuccessAction;
		}

		else if (sActionPath.equals("/addTeacherForClassSubject")) {
			clearMessage(oAssignTeacherBean);
			
			oAssignTeacherBO = oAssignTeacherDao.assignTeacher(
					oAssignTeacherBean.getTeacherID(), 
					oAssignTeacherBean.getClassID(),
					oAssignTeacherBean.getSubjectID());
			session.setAttribute("errorMessage", oAssignTeacherBO.getErrorMessage());
			
			oAssignTeacherBO = oAssignTeacherDao.loadAssignedTeacherData();
			oAssignTeacherBean.setAssignedTeacherList(oAssignTeacherBO.getAssignedTeacherList());
			sSuccess = sSuccessAction;
		}
		return mapping.findForward(sSuccess);
	}
	private void clearMessage(AssignTeacherBean oAssignTeacherBean) {
		oAssignTeacherBean.setErrorCode("");
		oAssignTeacherBean.setErrorMessage("");
	}

}
