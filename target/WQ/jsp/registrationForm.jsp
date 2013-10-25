<%@ include file="/Taglib/taglibs.jsp"%>

<head>
    <title>Registration Form</title>
</head>

<p>Please fill in user's information below:</p>

<s:fielderror/>
<s:form action="registrationAction" method="post" >
    <p>
	<s:textfield name="userId" label="desired userId"/>
	<s:password name="password" label="password"/>
	<s:password name="password2" label="Confirm password"/>
	<s:textfield name="firstName" label="First Name"/>
	<s:textfield name="lastName" label="Last Name"/>
	<s:textfield name="emailId" label="email"/>
    <s:reset id="reset" class="button" value="Clear"/>
    <s:submit id="save" class="button" value="Save"/>
    </p>
</s:form>

<script type="text/javascript">
    $('#userId').focus();
</script>

