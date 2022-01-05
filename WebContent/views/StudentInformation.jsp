<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/jstl-core.tld" prefix="core"%>
<%@ page import="com.bean.StudentBean"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Entry Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/style.css" type="text/css">
<script language="javascript" type="text/javascript">



	function doSaveStudent(f){
		if(document.getElementById("studentID").value == ""){
			alert("Student ID Required");
				
		}
		else if(document.getElementById("studentName").value == ""){
			alert("Student Name Required");
		}
		else if(document.getElementById("classID").value == ""){
			alert("Class Required");
		}
		else{
		
			f.action="/LearnersAcademy/addStudent.do";
			f.submit();
		}
	}
	function doCancelStudent(f){
		f.action="/LearnersAcademy/studentformation.do";
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
<html:form action="/studentformation" style="margin: 0">
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
            <td colspan="4" align="center"><h2>Student Information Entry Form</h2></td>
          </tr>
          <tr>
            <td colspan="4" align="center" style="color: red"><%out.print(session.getAttribute("errorMessage"));%></td>
          </tr>
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="20%"><label  class="labelL">Student ID : </label></td>
            <td width="60%"><input type="text" 	placeholder="Enter Student ID" id="studentID" name="studentID" required></td>
            <td width="10%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><label >Student Name : </label></td>
            <td width="60%"><input type="text" 	placeholder="Enter Student Name" id="studentName" name="studentName" required></td>
            <td>&nbsp;</td>
          </tr>
           <tr>
            <td>&nbsp;</td>
            <td><label >Class : </label></td>
            <td ><html:select property="classID" styleId="classID" styleClass="selectBox">
                <html:option value="">
                Please Select
                </html:option>
                <html:options property="classIDList"  labelProperty="classIDNameList" />
              </html:select></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td align="center"><button type="submit" value="savesubject"
									name="savesubject" style="width: 45%" onClick="doSaveStudent(studentBean)">Save</button>
              <button type="button" value="cancelsubject" name="cancelsubject"
									style="width: 45%"  onClick="doCancelStudent(studentBean)">Cancel</button></td>
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
                  <th>Student ID</th>
                  <th>Student Name</th>
                  <th>Class Name</th>
                </tr>
              </thead>
     		  <tbody>
                <core:forEach var="bo" items="${sessionScope['oStudentDataBO'].studentList}" varStatus="varSt">
                  <tr>
                    <td align="center"><core:out value="${bo.studentID}"/></td>
                    <td align="left"><core:out value="${bo.studentName}"/></td>
                    <td align="center"><core:out value="${bo.className}"/></td>
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
