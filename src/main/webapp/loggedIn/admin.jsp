
<%@page import="com.WebQ.beans.Question"%>
<%@page import="com.WebQ.beans.User"%>
<%@ include file="/Taglib/taglibs.jsp" %>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.WebQ.db.RetrieveDbInfo" %>
<head>
<script type="text/javascript" src="js/security.js"></script>
<script type="text/javascript">
	<%
	User u = (User)session.getAttribute("admin");
	String result = (String)session.getAttribute("add");
	%>
	document.getElementById("admin").innerHTML = "<%=u.getUserId().toString()%>";
	document.getElementById("result").innerHTML = "<%=result%>";
	function addUser(){
		document.forms[0].action='adminAction.action';  
	    document.forms[0].submit();
	}

</script>
<title>Admin Page</title>
</head>
<h1>ADMIN</h1>
<h1>Add Question</h1>
<div id="admin">ADMIN PAGE</div>
<div id="result"></div>
<form method="post" action="admin">
	<table>
	<tr>
	<td>levelId: </td>
	<td><input type="text" name="levelId"/></td>
	</tr>
	<tr>
	<td>QuestionId:</td>
	<td> <input type="text" name="questionId"/></td>
	</tr>
	<tr>
	<td>Question Description</td>
	<td><input type="text" name="questionDescription"/></td>
	</tr>
	<tr>
	<td>Option 1</td>
	<td><input type="text" name="option1" /></td>
	</tr>
	<tr>
	<td>Option 2</td>
	<td><input type="text" name="option2" /></td>
	</tr>
	<tr>
	<td>Option 3</td>
	<td><input type="text" name="option3" /></td>
	</tr>
	<tr>
	<td>Option 4</td>
	<td><input type="text" name="option4" /></td>
	</tr>
	<tr>
	<td>Answer</td>
	<td><input type="text" name="answer" /></td>
	</tr>
    <tr>
    <td><button type="reset" id="reset" class="button" value="Clear">reset</button></td>
    </tr>
    <tr>
    <td><button type="submit" onclick="addUser()" id="save" class="button" value="Save">save</button></td>
    </tr>
    </table>
</form>