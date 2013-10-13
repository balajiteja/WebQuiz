<%@ include file="/Taglib/taglibs.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>top Navigation</title>
<script>
function loadHome()
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("main").innerHTML=xmlhttp.responseText;
    }
  }
	xmlhttp.open("POST","home.jsp",true);
	xmlhttp.send();
}


</script>
</head>

<div id="nav">
	  <div class="wrapper">
          <ul class="clearfix">
               <li><s:a action="home">HOME</s:a></li>
               <li><s:a action="login">LOGIN</s:a></li>
               <li><s:a action="register">REGISTER</s:a></li>
               <li><s:a action="projectInfo">PROJECT INFO</s:a></li>
               <li><s:a action="team">TEAM</s:a></li>
               <li><s:a action="contact">CONTACT</s:a></li>
          </ul>
	  </div>
  <hr />
</div>