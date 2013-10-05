
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
   
...  
   
<html:form>  
   <html:button value="input" onclick="submitInput()"/>  
   <html:button value="success" onclick="submitSuccess()"/>  
</html:form>


