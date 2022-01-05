<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/jstl-core.tld" prefix="core"%>
<%@ page import="com.bean.SubjectBean"%>
<!DOCTYPE html>
<html>
<head>
<title>Subject Entry Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/style.css" type="text/css">
<script language="javascript" type="text/javascript">

	function doSaveSubject(f){
		if(document.getElementById("subjectID").value == ""){
			alert("Subject ID Required");
				
		}
		else if(document.getElementById("subjectName").value == ""){
			alert("Subject Name Required");
		}
		else{
			f.action="/LearnersAcademy/addSubject.do";
			f.submit();
		}
	}
	function doCancelSubject(f){
		f.action="/LearnersAcademy/subjectInformation.do";
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
<html:form action="/subjectInformation" style="margin: 0">
 <div id="page-background">
<img src="views/images/classImage.jpg"    alt="Welcome To Learners Academy" align="middle">
</div>  
  <table style="width:100%;border:0;height:90%" cellpadding="0" cellspacing="0">
    <tr>
      <td width="30%" valign="top"><div class="wrapper d-flex">
          <div class="sidebar">
            <h1> Learner's Academy</h1>
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
            <td colspan="4" align="center"><h2>Subject Entry Form</h2></td>
          </tr>
          <tr>
            <td colspan="4" align="center" style="color: red"><%out.print(session.getAttribute("errorMessage"));%></td>
          </tr>
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="20%"><label  class="labelL">Subject ID : </label></td>
            <td width="60%"><input type="text" 	placeholder="Enter Subject ID" id="subjectID" name="subjectID" required></td>
            <td width="10%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><label >Subject Name : </label></td>
            <td><input type="text" placeholder="Enter Subject Name" id="subjectName" name="subjectName" required></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td align="center"><button type="submit" value="savesubject"
									name="savesubject" style="width: 45%" onClick="doSaveSubject(subjectBean)">Save</button>
              <button type="button" value="cancelsubject" name="cancelsubject"
									style="width: 45%"  onClick="doCancelSubject(subjectBean)">Cancel</button></td>
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
                  <th>Subject ID</th>
                  <th align="left">Subject Name</th>
                </tr>
              </thead>
     		  <tbody>
                <core:forEach var="bo" items="${sessionScope['oSubjectBeanSubjectList'].subjectList}" varStatus="varSt">
                  <tr>
                    <td align="center"><core:out value="${varSt.count}" /></td>
                    <td align="center"><core:out value="${bo.subjectID}"/></td>
                    <td align="left"><core:out value="${bo.subjectName}"/></td>
                  </tr>
                </core:forEach>
              </tbody>
            </table>
             </div></td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
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
