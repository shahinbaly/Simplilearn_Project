<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.bean.LogInBean"%>
<!DOCTYPE html>
<html>
<title>Menu</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	list-style: none;
	text-decoration: none;
	font-family: arial
}
Body {
	/*background-color: #A9DFBF;*/
}
.wrapper {
	position: relative
}
.sidebar {
	position: fixed;
	width: 350px;
	height: 100%;
	background: #0B5345;
	padding: 10px 0
}
.wrapper .sidebar ul li {
	padding: 15px
}
.wrapper .sidebar ul li a {
	color: /*#bdb8d7*/#FFFFFF;
	display: block
}
.wrapper .sidebar ul li a .fas {
	width: 25px !important
}
.wrapper .sidebar ul li a .far {
	width: 25px !important
}
.wrapper .sidebar ul li:hover {
	background: #73C6B6;
	color: #000000;
}
.wrapper .sidebar ul li a:hover {
	color: #000000;
	text-decoration: none
}
.myproject {
	margin-top: 25px;
	color: #ffffffa8;
	font-size: 14px;
	margin-bottom: 0
}
.userProfile {
	position: absolute;
	bottom: 0;
	left: 5%;
	display: flex
}
.userProfile a {
	width: 20px;
	background: #4527A0;
	color: #bdb8d7;
	text-decoration: none;
	font-size: 15px
}
.userProfile a:hover {
	color: #fff;
	background: #4527A0
}
.userProfile p {
	color: #fff;
	padding: 0 15px 0 15px
}
.userProfile .xyz, .mnp {
	padding-top: 60%;
	line-height: 30px;
	font-size: 25px !important
}
.notification1 {
	display: flex
}
.notification1 .number1 {
	font-size: 15px;
	display: block;
	padding-left: 100px;
	color: #fff
}
.notification2 {
	display: flex
}
.notification2 .number2 {
	font-size: 15px;
	display: block;
	padding-left: 85px;
	color: #fff
}
h1 {
	font-family: Tempus Sans ITC;
	font-size: 34px;
	color: #FFF;
	text-align: center;
}
h2 {
	font-size: 48px;
	color: #000;
	text-align: center;
	background-color: #D0ECE7;
	height: 150px;
	vertical-align: central;
}
.labelL {
	font-size: 16px;
	color: #FFF;
}
.contextHead {
	font-size: 28px;
	font-family: Tempus Sans ITC;
	font-weight: bold;
	color: #23463f !important;
	background-color: #A9DFBF !important;
	text-align: center;
}

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
<html:form action="/adminLogIn" style="margin: 0">
 <div id="page-background">
<img src="views/images/dashboard.jpg"    alt="Welcome To Learners Academy" align="middle">
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
      <td width="70%" valign="top" height="100%"><table style="width:100%;border:0;height:100%" cellpadding="0" cellspacing="0">
          <tr>
            <td colspan="5">&nbsp;</td>
          </tr>
          <tr>
            <td width="6%" height="188">&nbsp;</td>
            <td width="39%"><table style="width:100%;border:0;height:100%" cellpadding="0" cellspacing="0">
                <tr>
                  <td class="contextHead">Total Subject</td>
                </tr>
                <tr valign="top">
                  <td><h2> <br/>
                      <%out.print(session.getAttribute("subjectTotal"));%>
                    </h2></td>
                </tr>
              </table></td>
            <td width="10%">&nbsp;</td>
            <td width="40%"><table style="width:100%;border:0;height:100%" cellpadding="0" cellspacing="0">
                <tr>
                  <td class="contextHead">Total Teacher</td>
                </tr>
                <tr valign="top">
                  <td>
                    <h2><br/>
                      <%out.print(session.getAttribute("teacherTotal"));%>
                    </h2></td>
                </tr>
              </table></td>
            <td width="5%">&nbsp;</td>
          </tr>
          <tr>
            <td width="6%" height="33">&nbsp;</td>
            <td width="39%">&nbsp;</td>
            <td width="10%">&nbsp;</td>
            <td width="40%">&nbsp;</td>
            <td width="5%">&nbsp;</td>
          </tr>
          <tr>
            <td width="6%" height="181">&nbsp;</td>
            <td width="39%"><table style="width:100%;border:0;height:100%" cellpadding="0" cellspacing="0">
                <tr>
                  <td class="contextHead">Total Class</td>
                </tr>
                <tr valign="top">
                  <td><h2><br/>
                      <%out.print(session.getAttribute("classTotal"));%>
                    </h2></td>
                </tr>
              </table></td>
            <td width="10%">&nbsp;</td>
            <td width="40%"><table style="width:100%;border:0;height:100%" cellpadding="0" cellspacing="0">
                <tr>
                  <td class="contextHead">Total Student</td>
                </tr>
                <tr valign="top">
                  <td>
                    <h2><br/>
                      <%out.print(session.getAttribute("studentTotal"));%>
                    </h2></td>
                </tr>
              </table></td>
            <td width="5%">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="5">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="5">&nbsp;</td>
          </tr>
        </table></td>
    </tr>
  </table>
</html:form>
</body>
</html>
