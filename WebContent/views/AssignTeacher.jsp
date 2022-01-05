<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/jstl-core.tld" prefix="core"%>
<%@ page import="com.bo.AssignTeacherBO"%>
<!DOCTYPE html>
<html>
<head>
<title>Teacher Assign to Class</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/style.css" type="text/css">
<script language="javascript" type="text/javascript">



	function assignTeacher(f){
		if(document.getElementById("teacherID").value == ""){
			alert("Teacher Name Required");
				
		}
		else if(document.getElementById("classID").value == ""){
			alert("Classs Required");
				
		}
		else if(document.getElementById("subjectID").value == ""){
			alert("Subject Required");
		}
		else{
		
			f.action="/LearnersAcademy/addTeacherForClassSubject.do";
			f.submit();
		}
	}
	function loadSubject(f){
		document.assignTeacherBean.classID.value = document.getElementById("classID").value;
		f.action="/LearnersAcademy/loadSubjectForClass.do";
		f.submit();
	}
	function doCancelAssign(f){
		f.action="/LearnersAcademy/assignTeacher.do";
		f.submit();
	}
	function doAssignSubject(f,elem){
		f.action="/LearnersAcademy/addTeacherForClassSubject.do?subjectID="+elem.value;
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
<html:form action="/assignTeacher" style="margin: 0">
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
            <td colspan="4" align="center"><h2>Assign Teacher for Classes Entry Form</h2></td>
          </tr>
          <tr>
            <td colspan="4" align="center" style="color: red"><%out.print(session.getAttribute("errorMessage"));%></td>
          </tr>
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="20%"><label  class="labelL">Teacher : </label></td>
            <td width="60%"><html:select property="teacherID" styleId="teacherID" styleClass="selectBox">
                <html:option value="">
                Please Select
                </html:option>
                <html:options property="teacherIDList"  labelProperty="teacherIDNameList" />
              </html:select></td>
            <td width="10%">&nbsp;</td>
          </tr>
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="20%"><label  class="labelL">Class : </label></td>
            <td width="60%"><html:select property="classID" styleId="classID" styleClass="selectBox" onchange="loadSubject(assignTeacherBean)">
                <html:option value="">
                Please Select
                </html:option>
                <html:options property="classIDList"  labelProperty="classIDNameList" />
              </html:select></td>
            <td width="10%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td valign="top"><label >Subject : </label></td>
            <td width="60%">
             <core:forEach var="bo" items="${assignTeacherBean.subjectList}" varStatus="varSt">
                  <html:checkbox property="subjectID" value="${bo.subjectID}" indexed="true" styleId="subjectID"
                   onclick="doAssignSubject(assignTeacherBean,this)"/>&nbsp;<core:out value="${bo.subjectName}"/>
                  <br/>
             </core:forEach>
            </td>
            <td>&nbsp;</td>
          </tr>
           <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td align="center"> <button type="button" value="cancelsubject" name="cancelsubject"
									style="width: 45%"  onClick="doCancelAssign(assignTeacherBean)">Cancel</button></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
         <tr>
            <td>&nbsp;</td>
            <td colspan="3" valign="top" align="center">
            <div class="tableFixHead">
            <table cellpadding="0" cellspacing="0" width="75%">
              <thead>
                <tr>
                  <th>Serial No</th>
                  <th>Teacher</th>
                  <th>Class</th>
                  <th>Subject</th>
                </tr>
              </thead>
     		  <tbody>
                <core:forEach var="bo" items="${assignTeacherBean.assignedTeacherList}" varStatus="varSt">
                  <tr>
                    <td align="center"><core:out value="${varSt.count}" /></td>
                    <td align="left"><core:out value="${bo.teacherName}"/></td>
                    <td align="left"><core:out value="${bo.className}"/></td>
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
