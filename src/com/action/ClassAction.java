package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.ClassBean;
import com.dao.ClassDao;

public class ClassAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ClassBean oClassBean = (ClassBean) form;
		ClassDao oClassDao = new ClassDao();
		String sActionPath = "";
		sActionPath = mapping.getPath();
		HttpSession session = request.getSession(true);
		String sSuccessAction = "success";
		String sFailureAction = "failure";
		String sFatalErrorAction = "fatalError";
		String sSuccess = sFatalErrorAction;

		if (sActionPath.equals("/classInformation")) {
			clearMessage(oClassBean);
			oClassBean.setClassID("");
			oClassBean.setClassName("");
			session.setAttribute("errorMessage", oClassBean.getErrorMessage());
			
			oClassBean = oClassDao.loadClassData();
			session.setAttribute("oClassBean", oClassBean);
			sSuccess = sSuccessAction;

		} else if (sActionPath.equals("/addClass")) {
			clearMessage(oClassBean);
			oClassBean = oClassDao.addClass(oClassBean.getClassID(), oClassBean.getClassName());
			session.setAttribute("errorMessage", oClassBean.getErrorMessage());
			oClassBean = oClassDao.loadClassData();
			session.setAttribute("oClassBean", oClassBean);
			oClassBean.setClassID("");
			oClassBean.setClassName("");
			sSuccess = sSuccessAction;

		}
		return mapping.findForward(sSuccess);
	}
	private void clearMessage(ClassBean oClassBean) {
		oClassBean.setErrorCode("");
		oClassBean.setErrorMessage("");
	}

}
