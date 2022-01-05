package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bean.LogInBean;
import com.dao.LogInDao;

public class LogInAction extends Action{
	@Override
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		LogInBean oLogInBean = (LogInBean) form;
		LogInDao oLogInDao = new LogInDao();
		String sActionPath = "";
		sActionPath = mapping.getPath();
		HttpSession session = request.getSession(true);
		String sSuccessAction = "success";
		String sFailureAction = "failure";
		String sFatalErrorAction = "fatalError";
		String sSuccess = sFatalErrorAction;
		
		if (sActionPath.equals("/logIn")) {
			clearMessage(oLogInBean);
			session.setAttribute("errorMessage", oLogInBean.getErrorMessage());
			sSuccess = sSuccessAction;					
			
		}
		else if (sActionPath.equals("/adminLogIn")) {
			clearMessage(oLogInBean);
			session.setAttribute("classTotal", null);		
			session.setAttribute("teacherTotal", null);
			session.setAttribute("subjectTotal", null);
			oLogInBean = oLogInDao.doLogIn(oLogInBean.getUsername(), oLogInBean.getPassword());			
			if (oLogInBean.getErrorCode().equals("0")) {
				oLogInBean = oLogInDao.getTotalClass();
				session.setAttribute("classTotal", oLogInBean.getTotalClass());
				
				oLogInBean = oLogInDao.getTotalTeacher();
				session.setAttribute("teacherTotal", oLogInBean.getTotalTeacher());
				
				oLogInBean = oLogInDao.getTotalSubject();
				session.setAttribute("subjectTotal", oLogInBean.getTotalSubject());
				
				oLogInBean = oLogInDao.getTotalStudent();
				session.setAttribute("studentTotal", oLogInBean.getTotalStudent());
				oLogInBean.setUsername(""); 
				oLogInBean.setPassword("");
				
				sSuccess = sSuccessAction;				
			}
			else if (oLogInBean.getErrorCode().equals("1")) {
				session.setAttribute("errorMessage", oLogInBean.getErrorMessage());
				sSuccess = sFailureAction;
			}
			else {
				clearMessage(oLogInBean);
				sSuccess = sFatalErrorAction;				
			}		
			
		}
		return mapping.findForward(sSuccess);
	    }
	
	private void clearMessage(LogInBean oLogInBean) {
		oLogInBean.setErrorCode("");
		oLogInBean.setErrorMessage("");
		
	}

	

}
