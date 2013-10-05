
<%@ include file="/Taglib/taglibs.jsp" %>


<head>
<title>Welcome to Online quiz</title>
</head>
<s:form action="logoutAction" method="post">
<s:div>
	<h4>Hello <s:property value="#session['user'].userId"/></h4><br/>
	<s:submit id="logoutAction" class="button" value="logout"/>
</s:div>
</s:form>
</body>
</html>