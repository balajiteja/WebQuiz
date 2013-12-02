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
<h1><a href="#">Student's site</a></h1>
         <nav style="width: 100%">
            <ul>
               <li><a href="#" class="m1">QUIZ</a></li>
               <li style="float: right"><a href="<s:url action="logoutAction"/>" class="m2">LOGOUT</a></li>
            </ul>
         </nav>
         

