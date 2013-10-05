<%@ include file="/Taglib/taglibs.jsp" %>

<head>
    <title>Login</title>
    
</head>

<s:fielderror/>
<s:form action="loginAction" method="post" >
    <p>
	<s:textfield name="userId" label="userId"/>
	<s:password name="password" label="password"/>
    <s:reset id="reset" class="button" value="Clear"/>
    <s:submit id="login" class="button" value="Login"/>
    <s:checkbox name="rememberMe" id="rememberMe"/>
    </p>
</s:form>


<script type="text/javascript">
    $('#userId').focus();
</script>
