
<%@ include file="/Taglib/taglibs.jsp" %>


<head>
<title>Test</title>
</head>

<script>  
   function logout() {
      document.forms[0].action='logoutAction.action';  
      document.forms[0].submit();  
   }  
   function submitSuccess() {  
      document.forms[0].action='testAction.action';  
      document.forms[0].submit();  
   }  
   function showProceed() {  
	      document.getElementById("cont").style.visibility=(document.formex.check.checked) ? "visible":"hidden";  
	}  
	   
</script>  
<body>

<iframe class="result_output" width="400" >
<div id="myDiv"><h2>Test Agreement and Acknowledgement. </h2></div>
</iframe>

<s:form name="formex">
	<s:checkbox name="check" onclick="showProceed()" >I agree to the terms and conditions</s:checkbox>
	<s:submit id="cont" value="proceed" onclick="submitSuccess()" cssStyle="visibility:hidden"/>
</s:form>

<button type="button" onclick="logout()">logout</button> 
</body>   
  
 



