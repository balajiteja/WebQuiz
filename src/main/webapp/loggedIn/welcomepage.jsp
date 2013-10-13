
<%@ include file="/Taglib/taglibs.jsp" %>


<head>
<script type="text/javascript">
	window.location.hash="no-back-button";
	window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
	window.onhashchange=function(){window.location.hash="no-back-button";}

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
				<td>Score</td>
				<td></td>
				<td><s:property value="#session['user'].score"/></td>
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
    Level three completed
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_one_started'}">
    Level one started but not completed
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_two_started'}">
    Level two started but not completed
</s:elseif>
<s:elseif test="%{#session['user'].status=='level_three_started'}">
    Level three started but not completed
</s:elseif>
<s:elseif test="%{#session['user'].status=='tried_to_cheat'}">
    tried to cheat
</s:elseif>
<s:else>
    default
</s:else>

