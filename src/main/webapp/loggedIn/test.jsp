
<%@ include file="/Taglib/taglibs.jsp" %>


<head>
<title>Test</title>
</head>

<script>  
   function submitInput() {
	  document.
      document.forms[0].action='/testAction';  
      document.forms[0].submit();  
   }  
   function submitSuccess() {  
      document.forms[0].action='/testAction';  
      document.forms[0].submit();  
   }  
</script>  
   
Test Starts here  
   
<s:form>  
   <s:submit value="input" onclick="submitInput()"/>  
   <s:submit value="success" onclick="submitSuccess()"/>  
</s:form>


