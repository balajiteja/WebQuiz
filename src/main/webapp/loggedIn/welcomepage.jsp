
<%@ include file="/Taglib/taglibs.jsp" %>


<head>
<script type="text/javascript">

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
				<td>Score</td>
				<td></td>
				<td><s:property value="#session['user'].score"/></td>
			</tr>
		</table>
	</s:div>
		<s:submit action="logoutAction" method="post" id="logoutAction" class="button" value="logout"/>
</s:form>
<s:a action="startTest">Start Test</s:a>

