
<%@ include file="/Taglib/taglibs.jsp" %>


<head>
<title>Test</title>
</head>

<script>  
   function submitInput() {
	  
      document.forms[0].action='logoutAction.action';  
      document.forms[0].submit();  
   }  
   function submitSuccess() {  
      document.forms[0].action='/testAction.action';  
      document.forms[0].submit();  
   }  
</script>  
   
Test Starts here  
   
<s:form>  
   <s:submit value="input" onclick="submitInput()"/>  
   <s:submit value="success" onclick="submitSuccess()"/>  
</s:form>

<s:form action="logoutAction" method="post">
		<s:submit action="logoutAction" method="post" id="logoutAction" class="button" value="logout"/>
</s:form>


