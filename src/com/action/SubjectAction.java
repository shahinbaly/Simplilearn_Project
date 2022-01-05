package com.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.SubjectBean;
import com.dao.SubjectDao;

public class SubjectAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SubjectBean oSubjectBean = (SubjectBean) form;
		SubjectDao oSubjectDao = new SubjectDao();
		String sActionPath = "";
		sActionPath = mapping.getPath();
		HttpSession session = request.getSession(true);
		String sSuccessAction = "success";
		String sFailureAction = "failure";
		String sFatalErrorAction = "fatalError";
		String sSuccess = sFatalErrorAction;

		if (sActionPath.equals("/subjectInformation")) {
			clearMessage(oSubjectBean);
			oSubjectBean.setSubjectID("");
			oSubjectBean.setSubjectName("");
			session.setAttribute("errorMessage", oSubjectBean.getErrorMessage());
			oSubjectBean = oSubjectDao.loadSubjectData();
			session.setAttribute("oSubjectBeanSubjectList", oSubjectBean);
			sSuccess = sSuccessAction;

		} else if (sActionPath.equals("/addSubject")) {
			clearMessage(oSubjectBean);
			oSubjectBean = oSubjectDao.addSubject(oSubjectBean.getSubjectID(), oSubjectBean.getSubjectName());
			session.setAttribute("errorMessage", oSubjectBean.getErrorMessage());
			oSubjectBean = oSubjectDao.loadSubjectData();
			session.setAttribute("oSubjectBeanSubjectList", oSubjectBean);
			oSubjectBean.setSubjectID("");
			oSubjectBean.setSubjectName("");
			sSuccess = sSuccessAction;

		}
		return mapping.findForward(sSuccess);
	}
	private void clearMessage(SubjectBean oSubjectBean) {
		oSubjectBean.setErrorCode("");
		oSubjectBean.setErrorMessage("");
	}

}
