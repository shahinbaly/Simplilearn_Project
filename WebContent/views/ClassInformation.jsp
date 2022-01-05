<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/jstl-core.tld" prefix="core"%>
<%@ page import="com.bean.ClassBean"%>
<!DOCTYPE html>
<html>
<head>
<title>Class Entry Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/style.css" type="text/css">
<script language="javascript" type="text/javascript">
	function doSaveClass(f) {
		if (document.getElementById("classID").value == "") {
			alert("Class ID Required");

		} else if (document.getElementById("className").value == "") {
			alert("Class Name Required");
		} else {
			f.action = "/LearnersAcademy/addClass.do";
			f.submit();
		}
	}
	function doCancelClass(f) {
		f.action = "/LearnersAcademy/classInformation.do";
		f.submit();
	}
</script>
<style type="text/css">
#page-background {position:absolute; 
				  top:0; 
				  left:0; 
				  right:0;
				  height:100%;
				 width:100%;
				  z-index:-1;
				 opacity: 0.5;
				  }
</style>
</head>
<body>
<html:form action="/classInformation" style="margin: 0">
 <div id="page-background">
<img src="views/images/classImage.jpg"    alt="Welcome To Learners Academy" align="middle">
</div>  
  <table style="width: 100%; border: 0; height: 90%" cellpadding="0"
			cellspacing="0">
    <tr>
      <td width="30%" valign="top"><div class="wrapper d-flex">
          <div class="sidebar">
            <h1>Learner's Academy</h1>
            <p>&nbsp;</p>
            <ul>
              <li><a href="/LearnersAcademy/adminLogIn.do"><i class="fas fa-home"></i>Dashboard</a></li>
              <li><a href="/LearnersAcademy/subjectInformation.do"><i class="fas fa-home"></i>Subject Information</a></li>
              <li><a href="/LearnersAcademy/classInformation.do"><i class="fas fa-users"></i>Class Information</a></li>
              <li><a href="/LearnersAcademy/teahcerInformation.do">Teacher Information</a></li>
              <li><a href="/LearnersAcademy/studentformation.do">Student Information</a></li>
              <li><a href="/LearnersAcademy/assignClassForSubject.do">Assign Classes for Subject</a></li>
              <li><a href="/LearnersAcademy/assignTeacher.do">Assign Teacher</a></li>
              <li><a href="/LearnersAcademy/classReport.do">Class Report</a></li>
              <li><a href="/LearnersAcademy/logIn.do">Logout</a></li>
            </ul>
          </div>
        </div></td>
      <td width="70%" valign="top"><table width="100%"> 
        
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4" align="center"><h2>Class Entry Form</h2></td>
          </tr>
          <tr>
            <td colspan="4" align="center" style="color: red"><%
									out.print(session.getAttribute("errorMessage"));
								%></td>
          </tr>
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="20%"><label class="labelL">Class ID : </label></td>
            <td width="60%"><input type="text"
								placeholder="Enter Class ID" id="classID" name="classID"
								required></td>
            <td width="10%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><label>Class Name : </label></td>
            <td><input type="text" placeholder="Enter Class Name"
								id="className" name="className" required></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td align="center"><button type="submit" value="savesubject"
									name="savesubject" style="width: 45%"
									onClick="doSaveClass(classBean)">Save</button>
              <button type="button" value="cancelsubject" name="cancelsubject"
									style="width: 45%" onClick="doCancelClass(classBean)">Cancel</button></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
         <tr>
            <td>&nbsp;</td>
            <td colspan="3" valign="top" align="center">
            <div class="tableFixHead">
            <table cellpadding="0" cellspacing="0">
              <thead>
                <tr>
                  <th>Serial No</th>
                  <th>Class ID</th>
                  <th align="left">Class Name</th>
                </tr>
              </thead>
     		  <tbody>
                <core:forEach var="bo" items="${sessionScope['oClassBean'].classList}" varStatus="varSt">
                  <tr>
                    <td align="center"><core:out value="${varSt.count}" /></td>
                    <td align="center"><core:out value="${bo.classID}"/></td>
                    <td align="left"><core:out value="${bo.className}"/></td>
                  </tr>
                </core:forEach>
              </tbody>
            </table>
             </div></td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
        </table></td>
    </tr>
  </table>
</html:form>
</body>
</html>
