package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.TeacherBean;
import com.dao.TeacherDao;

public class TeacherAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TeacherBean oTeacherBean = (TeacherBean) form;
		TeacherDao oTeacherDao = new TeacherDao();
		String sActionPath = "";
		sActionPath = mapping.getPath();
		HttpSession session = request.getSession(true);
		String sSuccessAction = "success";
		String sFailureAction = "failure";
		String sFatalErrorAction = "fatalError";
		String sSuccess = sFatalErrorAction;

		if (sActionPath.equals("/teahcerInformation")) {
			clearMessage(oTeacherBean);
			oTeacherBean.setTeacherID("");
			oTeacherBean.setTeacherName("");
			session.setAttribute("errorMessage", oTeacherBean.getErrorMessage());
			oTeacherBean = oTeacherDao.loadTeacherData();
			session.setAttribute("oTeacherDataBean", oTeacherBean);
			sSuccess = sSuccessAction;

		} else if (sActionPath.equals("/addTeahcer")) {
			clearMessage(oTeacherBean);
			oTeacherBean = oTeacherDao.addTeacher(oTeacherBean.getTeacherID(), oTeacherBean.getTeacherName());
			session.setAttribute("errorMessage", oTeacherBean.getErrorMessage());
			oTeacherBean = oTeacherDao.loadTeacherData();
			session.setAttribute("oTeacherDataBean", oTeacherBean);
			oTeacherBean.setTeacherID("");
			oTeacherBean.setTeacherName("");
			sSuccess = sSuccessAction;

		}
		return mapping.findForward(sSuccess);
	}
	private void clearMessage(TeacherBean oTeacherBean) {
		oTeacherBean.setErrorCode("");
		oTeacherBean.setErrorMessage("");
	}

}
