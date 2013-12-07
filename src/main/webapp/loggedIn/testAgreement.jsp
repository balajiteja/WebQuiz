
<%@ include file="/Taglib/taglibs.jsp" %>


<head>
<title>Test</title>
</head>
<style>


.button {
  position: relative;
  display: inline-block;
  vertical-align: top;
  height: 36px;
  line-height: 35px;
  padding: 0 20px;
  font-size: 13px;
  color: white;
  text-align: center;
  text-decoration: none;
  text-shadow: 0 -1px rgba(0, 0, 0, 0.4);
  background-clip: padding-box;
  border: 1px solid;
  border-radius: 2px;
  cursor: pointer;
  -webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.1), inset 0 0 0 1px rgba(255, 255, 255, 0.08), 0 1px 2px rgba(0, 0, 0, 0.25);
  box-shadow: inset 0 1px rgba(255, 255, 255, 0.1), inset 0 0 0 1px rgba(255, 255, 255, 0.08), 0 1px 2px rgba(0, 0, 0, 0.25);
}
.button:before {
  content: '';
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  pointer-events: none;
  background-image: -webkit-radial-gradient(center top, farthest-corner, rgba(255, 255, 255, 0.08), rgba(255, 255, 255, 0));
  background-image: -moz-radial-gradient(center top, farthest-corner, rgba(255, 255, 255, 0.08), rgba(255, 255, 255, 0));
  background-image: -o-radial-gradient(center top, farthest-corner, rgba(255, 255, 255, 0.08), rgba(255, 255, 255, 0));
  background-image: radial-gradient(center top, farthest-corner, rgba(255, 255, 255, 0.08), rgba(255, 255, 255, 0));
}
.button:hover:before {
  background-image: -webkit-radial-gradient(farthest-corner, rgba(255, 255, 255, 0.18), rgba(255, 255, 255, 0.03));
  background-image: -moz-radial-gradient(farthest-corner, rgba(255, 255, 255, 0.18), rgba(255, 255, 255, 0.03));
  background-image: -o-radial-gradient(farthest-corner, rgba(255, 255, 255, 0.18), rgba(255, 255, 255, 0.03));
  background-image: radial-gradient(farthest-corner, rgba(255, 255, 255, 0.18), rgba(255, 255, 255, 0.03));
}
.button:active {
  -webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.2);
  box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.2);
}
.button:active:before {
  content: none;
}

.button-gray {
  background: #47494f;
  border-color: #2f3034 #2f3034 #232427;
  background-image: -webkit-linear-gradient(top, #55585f, #47494f 66%, #3d3f44);
  background-image: -moz-linear-gradient(top, #55585f, #47494f 66%, #3d3f44);
  background-image: -o-linear-gradient(top, #55585f, #47494f 66%, #3d3f44);
  background-image: linear-gradient(to bottom, #55585f, #47494f 66%, #3d3f44);
}
.button-gray:active {
  background: #47494f;
  border-color: #232427 #2f3034 #2f3034;
}

</style>

<script>  
   
   function showProceed() {  
	      document.getElementById("cont").style.visibility=(document.formex.check.checked) ? "visible":"hidden";  
	}  
	   
</script>  

<iframe src="agreementDoc.txt" width="900" height="400">
</iframe>
<form name="formex">
	<input type="checkbox" name="check" onclick="showProceed()"/> I agree to the terms and conditions
</form>
	
    <a href="<s:url action="testAction"/>" id="cont"  style="visibility:hidden" class="button button-gray">Proceed</a>
 
  
 



