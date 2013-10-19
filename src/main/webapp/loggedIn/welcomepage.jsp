
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
	
	WebApplicationContext context = WebApplicationContextUtils
	.getRequiredWebApplicationContext(ServletActionContext
		.getServletContext());

	RetrieveDbInfo retrieveDbInfo = (RetrieveDbInfo) context.getBean("retrieveDbInfo");
	User u = (User)session.getAttribute("user");
	session.setAttribute("user", retrieveDbInfo.getUser(u.getUserId()));
	
	
	
	
	%>
	
</script>
<title>Welcome to Online quiz</title>
</head>

<s:form action="logoutAction" method="post">
	<s:div>
		<h4>Hello <s:property value="#session['user'].userId"/> !</h4>
		<p>logged in time: <%=session.getAttribute("context") %></p>
		<table>
			<tr>
				<td>First Name</td>
				<td></td>
				<td><s:property value="#session['user'].firstName"/></td>
				</tr>
				<tr>
				<td>Last Name</td>
				<td></td>
				<td><s:property value="#session['user'].lastName"/></td>
				</tr>
				<tr>
				<td>Email Id</td>
				<td></td>
				<td><s:property value="#session['user'].emailId"/></td>
				</tr>
				<tr>
				<td>Status</td>
				<td></td>
				<td>
				<s:if test="%{#session['user'].status=='null'}">
				You havent attempted the test yet.
				</s:if>	
				<s:else>
				<s:property value="#session['user'].status"/>
				</s:else>
				</td>
				</tr>
				<tr>
				<td>Total Score</td>
				<td></td>
				<td><s:property value="#session['user'].totalScore"/></td>
			</tr>
		</table>
	</s:div>
		<s:submit action="logoutAction" method="post" id="logoutAction" class="button" value="logout"/>
</s:form>

<!--<s:set name="webFramework" value="framework"/>-->
 
<s:if test="%{#session['user'].status==null}">
	<s:a action="testAgreement">Start Level 1</s:a>
</s:if>
<s:elseif test="%{#session['user'].status=='null'}">
    <s:a action="testAgreement">Start Level 1</s:a>
</s:elseif>
<s:elseif test="%{#session['user'].status=='NULL'}">
    <s:a action="testAgreement">Start level 1</s:a>
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_one_completed'}">
    <s:a action="testAgreement">Start level 2</s:a>
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_two_completed'}">
    <s:a action="testAgreement">Start level 3</s:a>
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_three_completed'}">
    Level three completed and you have passed the quiz
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_one_started'}">
    Level one started but not completed contact the admin to take the test
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_two_started'}">
    Level two started but not completed contact the admin to take the test
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_three_started'}">
    Level three started but not completed contact the admin to take the test
</s:elseif>
<s:elseif test="%{#session['user'].status=='tried_to_cheat'}">
    tried to cheat contact the admin to take the test
</s:elseif>
<s:else>
    default
</s:else>

