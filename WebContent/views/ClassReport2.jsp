<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/jstl-core.tld" prefix="core"%>
<%@ page import="com.bo.ClassReportBO"%>
<!DOCTYPE html>
<html>
<head>
<title>Class Report</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/style.css" type="text/css">
<script language="javascript" type="text/javascript">

	function loadSubject(f){
		document.classReportBean.classID.value = document.getElementById("classID").value;
		f.action="/LearnersAcademy/viewClassReport.do";
		f.submit();
	}
	function doCancelAssign(f){
		f.action="/LearnersAcademy/classReport.do";
		f.submit();
	}
	
</script>
<style>

 .tableFixHead2 {      
  	 table-layout: auto;
 	 border-collapse: collapse;
}
.tableFixHead2 thead th {	  
	position: sticky;	
	/*top: 0;	*/	
}
.tableFixHead2 tbody {
     /* display: block;	  
      overflow: auto;*/
	  width: 100%;
      height: 600px;
	 
 }
 .tableFixHead2 thead tr {
      /*display: block;*/
	  width:100%;
	  
 }
 .tableFixHead2 th{
	  background-color:#808080;
	  border: 1px solid #000;
 }
 .tableFixHead2  td {
      border: 1px solid #000;
 }
</style>
</head>
<body>
<html:form action="/classReport" style="margin: 0">
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
            </ul>
          </div>
        </div></td>
      <td width="70%" valign="top"><table width="100%">      
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4" align="center"><h2>Class Report</h2></td>
          </tr>
          <tr>
            <td colspan="4" align="center" style="color: red"><%out.print(session.getAttribute("errorMessage"));%></td>
          </tr>          
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="20%"><label  class="labelL">Class : </label></td>
            <td width="60%"><html:select property="classID" styleId="classID" styleClass="selectBox" onchange="loadSubject(classReportBean)">
                <html:option value="">
                Please Select
                </html:option>
                <html:options property="classIDList"  labelProperty="classIDNameList" />
              </html:select></td>
            <td width="10%">&nbsp;</td>
          </tr>
           <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td align="center"> <button type="button" value="cancelsubject" name="cancelsubject"
									style="width: 45%"  onClick="doCancelAssign(classReportBean)">Cancel</button></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
         <tr>
            <td>&nbsp;</td>
            <td colspan="3" valign="top" align="center">
            <div>
            <table cellpadding="0" cellspacing="0" width="90%" style="border:1px #000000 solid">
              <thead style="background-color:#808080;border:1px solid #000;position: sticky;">
                <tr  style="background-color:#808080;border:1px solid #000;position: sticky;">
                  <th>#</th>                
                  <th align="left">Class</th>
                  <th align="left">Subject</th>
                  <th align="left">Teacher</th>
                  <th align="left">Student</th>
                </tr>
              </thead>
     		  <tbody>
                <core:forEach var="bo" items="${classReportBean.classReportList}" varStatus="varSt">
                  <tr>
                    <td align="center"><core:out value="${varSt.count}" /></td>
                    <td align="left"><core:out value="${bo.className}"/></td>
                    <td align="left"><core:out value="${bo.subjectName}"/></td>
                    <td align="left"><core:out value="${bo.teacherName}"/></td>
                    <td align="left"><core:out value="${bo.studentName}"/></td>
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
