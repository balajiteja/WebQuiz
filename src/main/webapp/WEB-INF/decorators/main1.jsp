<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/Taglib/taglibs.jsp" %>

<html lang="en">
<head>
	<title><decorator:title default="Struts Starter"/></title>
    <link href="<s:url value='/styles/main.css'/>" rel="stylesheet" type="text/css" media="all"/>
    <link href="<s:url value='/struts/niftycorners/niftyCorners.css'/>" rel="stylesheet" type="text/css"/>
    <link href="<s:url value='/struts/niftycorners/niftyPrint.css'/>" rel="stylesheet" type="text/css" media="print"/>
    <script language="JavaScript" type="text/javascript" src="<s:url value='/struts/niftycorners/nifty.js'/>"></script>
	<script language="JavaScript" type="text/javascript">
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
<body id="page-home">
    <div id="page">
    	<!-- HEADER -->
        <%@ include file="/WEB-INF/decorators/header.jsp" %>
        <!-- MAIN CONTENT -->
        <div id="content" class="clearfix">
			<!-- MAIN CONTENT GOES HERE -->
            <div id="main">
            	<decorator:body/>
                <hr />
            </div>
			<!-- SUB CONTENT -->
            <%@ include file="/WEB-INF/decorators/sub.jsp" %>
            <!-- LEFT NAGIVATION  -->
            <!--  <%@ include file="/WEB-INF/decorators/leftNav.jsp" %> -->  
            <!-- TOP NAVIGATION -->
            <%@ include file="/WEB-INF/decorators/topNav.jsp" %>
        </div>
        <%@ include file="/WEB-INF/decorators/footer.jsp" %>
    </div>
    
    <div id="extra1">&nbsp;</div>
    <div id="extra2">&nbsp;</div>
</body>
</html>
