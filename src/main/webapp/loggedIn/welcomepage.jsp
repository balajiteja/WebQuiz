
<%@page import="com.webq.beans.User"%>
<%@ include file="/Taglib/taglibs.jsp" %>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.webq.db.RetrieveDbInfo" %>
<head>
<style type="text/css">

div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, section
{
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
}

article, aside, details, figcaption, figure,
footer, header, hgroup, menu, nav, section {
  display: block;
}



blockquote:before, blockquote:after,
q:before, q:after {
  content: '';
  content: none;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
}

body {
  font: 13px/20px 'Lucida Grande', Verdana, sans-serif;
  color: #404040;
 
}

.tasks {
  margin: 50px auto;
  width: 500px;
  background: white;
  border: 1px solid #cdd3d7;
  border-radius: 4px;
  -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
}

.tasks-header {
  position: relative;
  line-height: 24px;
  padding: 7px 15px;
  color: #5d6b6c;
  text-shadow: 0 1px rgba(255, 255, 255, 0.7);
  background: #f0f1f2;
  border-bottom: 1px solid #d1d1d1;
  border-radius: 3px 3px 0 0;
  background-image: -webkit-linear-gradient(top, #f5f7fd, #e6eaec);
  background-image: -moz-linear-gradient(top, #f5f7fd, #e6eaec);
  background-image: -o-linear-gradient(top, #f5f7fd, #e6eaec);
  background-image: linear-gradient(to bottom, #f5f7fd, #e6eaec);
  -webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.5), 0 1px rgba(0, 0, 0, 0.03);
  box-shadow: inset 0 1px rgba(255, 255, 255, 0.5), 0 1px rgba(0, 0, 0, 0.03);
}

.tasks-title {
  line-height: inherit;
  font-size: 14px;
  font-weight: bold;
  color: inherit;
}

.tasks-lists {
  position: absolute;
  top: 50%;
  right: 10px;
  margin-top: -11px;
  padding: 10px 4px;
  width: 19px;
  height: 3px;
  font: 0/0 serif;
  text-shadow: none;
  color: transparent;
}
.tasks-lists:before {
  content: '';
  display: block;
  height: 3px;
  background: #8c959d;
  border-radius: 1px;
  -webkit-box-shadow: 0 6px #8c959d, 0 -6px #8c959d;
  box-shadow: 0 6px #8c959d, 0 -6px #8c959d;
}

.tasks-list-item {
  display: block;
  line-height: 24px;
  padding: 12px 15px;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.tasks-list-item + .tasks-list-item {
  border-top: 1px solid #f0f2f3;
}

.tasks-list-cb {
  display: none;
}

.tasks-list-mark {
  position: relative;
  display: inline-block;
  vertical-align: top;
  margin-right: 12px;
  width: 20px;
  height: 20px;
  border: 2px solid #c4cbd2;
  border-radius: 12px;
}
.tasks-list-mark:before {
  content: '';
  display: none;
  position: absolute;
  top: 50%;
  left: 50%;
  margin: -5px 0 0 -6px;
  height: 4px;
  width: 8px;
  border: solid #39ca74;
  border-width: 0 0 4px 4px;
  -webkit-transform: rotate(-45deg);
  -moz-transform: rotate(-45deg);
  -ms-transform: rotate(-45deg);
  -o-transform: rotate(-45deg);
  transform: rotate(-45deg);
}
.tasks-list-cb:checked ~ .tasks-list-mark {
  border-color: #39ca74;
}
.tasks-list-cb:checked ~ .tasks-list-mark:before {
  display: block;
}

.tasks-list-desc {
  font-weight: bold;
  color: #8a9a9b;
}
.tasks-list-cb:checked ~ .tasks-list-desc {
  color: #34bf6e;
  text-decoration: line-through;
}


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
<script type="text/javascript" src="js/security.js"></script>
<script type="text/javascript">
	<%
	WebApplicationContext context = WebApplicationContextUtils
	.getRequiredWebApplicationContext(ServletActionContext
		.getServletContext());

	RetrieveDbInfo retrieveDbInfo = (RetrieveDbInfo) context.getBean("retrieveDbInfo");
	User u = (User)session.getAttribute("user");
	session.setAttribute("user", retrieveDbInfo.getUser(u.getUserId()));
	%>
	
	
	
	
</script>
<title>Welcome to Online quiz</title>
</head>
<section class="tasks">
    <header class="tasks-header" style=" width:470px; text-align: center;">
      <h2 class="tasks-title">Hello <s:property value="#session['user'].userId"/> !</h2>
    </header>
    <fieldset class="tasks-list">
      <label class="tasks-list-item">
        <span class="tasks-list-desc">First Name: <s:property value="#session['user'].firstName"/></span>
      </label>
      <label class="tasks-list-item">
        <span class="tasks-list-desc">Last Name: <s:property value="#session['user'].lastName"/></span>
      </label>
      <label class="tasks-list-item">
        <span class="tasks-list-desc">Email ID: <s:property value="#session['user'].emailId"/></span>
      </label>
      <label class="tasks-list-item">
        <span class="tasks-list-desc">Status : <s:if test="%{#session['user'].status=='null'}">
				You didnt complete level one
				</s:if>	
				<s:else>
				<s:property value="#session['user'].status"/>
				</s:else>
		</span>
      </label>
      <label class="tasks-list-item">
        <span class="tasks-list-desc">Total Score : <s:property value="#session['user'].totalScore"/></span>
      </label>
      <label class="tasks-list-item">
        <span class="tasks-list-desc">Test Level : 
			        	<s:if test="%{#session['user'].status==null}">
				You can give level 2 only if you score 20 or above points in this
				<s:a action="testAgreement">Start Level 1</s:a>
			</s:if>
			<s:elseif test="%{#session['user'].status=='null'}">
				You can give level 2 only if you score 20 or above points in this
			    <s:a action="testAgreement">Start Level 1</s:a>
			</s:elseif>
			<s:elseif test="%{#session['user'].status=='NULL'}">
			    <s:a action="testAgreement">Start level 1</s:a>
			</s:elseif>
			<s:elseif test="%{#session['user'].status=='level_one_completed'}">
				You can give level 3 only if you score 20 or above points in this
			    <s:a action="testAgreement">Start level 2</s:a>
			</s:elseif>
			<s:elseif test="%{#session['user'].status=='level_two_completed'}">
				You can complete this module only if you score 25 or above in this level
			    <s:a action="testAgreement">Start level 3</s:a>
			</s:elseif>
			<s:elseif test="%{#session['user'].status=='level_three_completed'}">
			    Level three completed and you have passed the quiz
			</s:elseif>
			<s:elseif test="%{#session['user'].status=='level_one_started'}">
			    Level one started but not completed contact the admin to take the test
			</s:elseif>
			<s:elseif test="%{#session['user'].status=='level_two_started'}">
			    Level two started but not completed contact the admin to take the test
			</s:elseif>
			<s:elseif test="%{#session['user'].status=='level_three_started'}">
			    Level three started but not completed contact the admin to take the test
			</s:elseif>
			<s:elseif test="%{#session['user'].status=='tried_to_cheat'}">
			    tried to cheat contact the admin to take the test
			</s:elseif>
			<s:else>
			    default
			</s:else>
			        	
        </span>
      </label>
    </fieldset>
  </section>
  
