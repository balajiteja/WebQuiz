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
<h1><a href="#"></a></h1>
         <nav>
            <ul>
               <li><a href="<s:url action="home"/>" class="m1">HOME</a></li>
               <li><a href="<s:url action="login"/>" class="m2">LOGIN</a></li>
               <li><a href="<s:url action="register"/>" class="m3">REGISTER</a></li>
               <li><a href="<s:url action="projectInfo"/>" class="m4">PROJECT INFO</a></li>
               <li><a href="<s:url action="contact"/>" class="m5">CONTACT</a></li>
            </ul>
         </nav>
         <form action="" id="search-form">
            <fieldset>
            <div class="rowElem">
               <input type="text">
               <a href="#" onClick="document.getElementById('search-form').submit()">Search</a></div>
            </fieldset>
         </form>
