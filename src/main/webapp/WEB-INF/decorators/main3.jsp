<!DOCTYPE html>
<%@ include file="/Taglib/taglibs.jsp" %>
<html lang="en">
<head>
<title><decorator:title default="Struts Starter"/></title>
<meta charset="utf-8">
<meta name="description" content="Place your description here">
<meta name="keywords" content="put, your, keyword, here">
<meta name="author" content="Templates.com - website templates provider">
<link rel="stylesheet" href="<s:url value='/styles/reset.css'/>" type="text/css" media="all">
<link rel="stylesheet" href="<s:url value='/styles/style.css'/>" type="text/css" media="all">
<link href="<s:url value='/struts/niftycorners/niftyCorners.css'/>" rel="stylesheet" type="text/css"/>
<link href="<s:url value='/struts/niftycorners/niftyPrint.css'/>" rel="stylesheet" type="text/css" media="print"/>
<script type="text/javascript" src="<s:url value='/struts/niftycorners/nifty.js'/>"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_300.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript">
    window.onload = function(){
        if(!NiftyCheck()) {
            return;
        }
        // perform niftycorners rounding
        // eg.
        // Rounded("blockquote","tr bl","#ECF1F9","#CDFFAA","smooth border #88D84F");
    }
</script>
<decorator:head/>
</head>
<body id="page1">
<div class="wrap">
   <!-- header -->
   <header>
      <div class="container">
         <!-- TOP NAVIGATION -->
            <%@ include file="/WEB-INF/decorators/topNav3.jsp" %>
      </div>
   </header>
   <div class="container">
      <decorator:body/>
   </div>
</div>
<!-- footer -->
<footer>
   <div class="container">
      <div class="inside">
         <div class="wrapper">
            <div class="fleft">Software Engineering <span> SE 6387</span></div>
            <div class="aligncenter"><a href="http://www.utdallas.edu/">The University of Texas at Dallas </a> designed by Teja<br>
               800 W. Campbell Road, Richardson, Texas 75080-3021</div>
         </div>
      </div>
   </div>
</footer>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>
