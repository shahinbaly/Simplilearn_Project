<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.bean.LogInBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learner's Academy</title>
<style>
Body {
	font-family: Calibri, Helvetica, sans-serif;
background-color: #6abade;/*#A9DFBF*/
}
button {
	background-color:#A9DFBF;/* #4CAF50;*/
	width: 100%;
	color: green;
	padding: 15px;
	margin: 10px 0px;
	border: none;
	cursor: pointer;
}
form {
	/* border: 3px solid #0B5345; */
}
input[type=text], input[type=password] {
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 2px solid green;
	box-sizing: border-box;
}
button:hover {
	opacity: 0.7;
}
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	margin: 10px 5px;
}
.container {
	/*padding: 25px;*/
	background-color: #23463f;
}
h1 {
	font-family: Arial;
	font-size: 30px;
	text-align: center;  
    color: #277582;  
    padding: 20px;  
}
h2 {
	font-size: 34px;
	color: #FFF;
}
label{  
    color: #08ffd1;  
    font-size: 17px;  
}  
#page-background {position:absolute; 
				  top:0; 
				  left:0; 
				  right:0;
				  
				  z-index:-1;
				 
				  }

</style>
<script language="javascript" type="text/javascript">

	function doLogIn(f){
		f.action="/LearnersAcademy/adminLogIn.do";
		f.submit();
	}
	
	
</script>
</head>
<body>
<center>
  <h1> Learner's Academy</h1>
</center>
<html:form action="/logIn" style="margin: 0">
 <div id="page-background">
<img src="views/images/HomePage-Background_2.jpg"  max-width="100%" height="100%"   alt="Welcome To Learners Academy" align="middle">
</div>
  <table style="width:100%;border:0;height:100%" cellpadding="0" cellspacing="0">
    <tr>
      <td width="30%">&nbsp;</td>
      <td width="40%" rowspan="6" align="center" valign="middle"><table class="container" width="100%">
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
        <!-- <tr>
            <td colspan="4" align="center"><h2> Admin Login Form </h2></td>
          </tr>  -->
          <tr>
            <td colspan="4" align="center" style="color:red">
            <%out.print(session.getAttribute("errorMessage"));%>
            </td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="20%"><label style="text-align:left" class="labelL">Username : </label></td>
            <td width="60%"><input type="text" placeholder="Enter Username" id="username" name="username" required ></td>
            <td width="10%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><label class="labelL">Password : </label></td>
            <td><input type="password" placeholder="Enter Password" id="password" name="password" required></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td align="center"><button type="button" value="Login" name="Login" onClick="doLogIn(logInBean)">Login</button></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="4">&nbsp;</td>
          </tr>
        </table></td>
      <td width="30%">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
</html:form>
</body>
</html>