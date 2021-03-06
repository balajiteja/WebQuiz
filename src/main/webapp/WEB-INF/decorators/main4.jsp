<!DOCTYPE html>
<%@ include file="/Taglib/taglibs.jsp" %>
<html>
<head>
<style type="text/css">
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed,
figure, figcaption, footer, header, hgroup,
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
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

body {
  line-height: 1;
}

ol, ul {
  list-style: none;
}

blockquote, q {
  quotes: none;
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

.about {
  margin: 70px auto 40px;
  padding: 8px;
  width: 800px;
  font: 10px/18px 'Lucida Grande', Arial, sans-serif;
  color: #bbb;
  text-align: center;
  text-shadow: 0 -1px rgba(0, 0, 0, 0.3);
  background: #383838;
  background: rgba(34, 34, 34, 0.8);
  border-radius: 4px;
  background-image: -webkit-linear-gradient(top, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.3));
  background-image: -moz-linear-gradient(top, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.3));
  background-image: -o-linear-gradient(top, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.3));
  background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.3));
  -webkit-box-shadow: inset 0 0 0 1px rgba(0, 0, 0, 0.2), 0 0 6px rgba(0, 0, 0, 0.4);
  box-shadow: inset 0 0 0 1px rgba(0, 0, 0, 0.2), 0 0 6px rgba(0, 0, 0, 0.4);
}
.about a {
  color: #eee;
  text-decoration: none;
  border-radius: 2px;
  -webkit-transition: background 0.1s;
  -moz-transition: background 0.1s;
  -o-transition: background 0.1s;
  transition: background 0.1s;
}
.about a:hover {
  text-decoration: none;
  background: #555;
  background: rgba(255, 255, 255, 0.15);
}

.about-links {
  height: 30px;
}
.about-links > a {
  width: 50%;
  line-height: 30px;
  font-size: 12px;
}

.about-author {
  margin-top: 5px;
}
.about-author > a {
  padding: 1px 3px;
  margin: 0 -1px;
}

body {
  font: 12px/20px 'Lucida Grande', Verdana, sans-serif;
  color: #404040;
  background: #eee;
}

.widget {
  position: relative;
  margin: 50px auto;
  width: 800px;
  background: white;
  border: 1px solid #ccc;
  border-radius: 4px;
  -webkit-box-shadow: 0 0 8px rgba(0, 0, 0, 0.07);
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.07);
}

.widget-tabs {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  padding: 9px 12px 0;
  text-align: left;
  direction: rtl;
  background: #f5f5f5;
  border-bottom: 1px solid #ddd;
  border-radius: 3px 3px 0 0;
}

.widget-tab,
.widget-list:target:first-of-type ~ .widget-tabs > .widget-tab:first-child ~ .widget-tab,
.widget-list:target:nth-of-type(2) ~ .widget-tabs > .widget-tab:nth-child(2) ~ .widget-tab,
.widget-list:target:last-of-type ~ .widget-tabs > .widget-tab:last-child ~ .widget-tab {
  position: relative;
  display: inline-block;
  vertical-align: top;
  margin-top: 3px;
  line-height: 36px;
  font-weight: normal;
  color: #999;
  background: #fcfcfc;
  border: solid #ddd;
  border-width: 1px 1px 0;
  border-radius: 5px 5px 0 0;
  /* Reset %active-widget-tab */
  padding-bottom: 0;
  bottom: auto;
}
.widget-tab > .widget-tab-link,
.widget-list:target:first-of-type ~ .widget-tabs > .widget-tab:first-child ~ .widget-tab > .widget-tab-link,
.widget-list:target:nth-of-type(2) ~ .widget-tabs > .widget-tab:nth-child(2) ~ .widget-tab > .widget-tab-link,
.widget-list:target:last-of-type ~ .widget-tabs > .widget-tab:last-child ~ .widget-tab > .widget-tab-link {
  margin: 0;
  border-top: 0;
}

.widget-tab + .widget-tab {
  margin-right: -1px;
}

.widget-tab:last-child,
.widget-list:target:first-of-type ~ .widget-tabs > .widget-tab:first-child,
.widget-list:target:nth-of-type(2) ~ .widget-tabs > .widget-tab:nth-child(2),
.widget-list:target:last-of-type ~ .widget-tabs > .widget-tab:last-child {
  bottom: -1px;
  margin-top: 0;
  padding-bottom: 2px;
  line-height: 34px;
  font-weight: bold;
  color: #555;
  background: white;
  border-top: 0;
}
.widget-tab:last-child > .widget-tab-link,
.widget-list:target:first-of-type ~ .widget-tabs > .widget-tab:first-child > .widget-tab-link,
.widget-list:target:nth-of-type(2) ~ .widget-tabs > .widget-tab:nth-child(2) > .widget-tab-link,
.widget-list:target:last-of-type ~ .widget-tabs > .widget-tab:last-child > .widget-tab-link {
  margin: 0 -1px;
  border-top: 4px solid #4cc8f1;
}

/* Deactivate the default tab when a preceding tab is activated. */
.widget-tab-link {
  display: block;
  min-width: 60px;
  padding: 0 15px;
  color: inherit;
  text-align: center;
  text-decoration: none;
  border-radius: 4px 4px 0 0;
}

.widget-list {
  margin:40px;
  display: none;
  padding-top: 50px;
  margin:
}
.widget-list > li + li {
  border-top: 1px solid #e8e8e8;
}
.widget-list:last-of-type {
  display: block;
}
.widget-list:target {
  display: block;
  margin: 40px;
}
.widget-list:target ~ .widget-list {
  display: none;
}

.widget-list-link {
  display: block;
  line-height: 18px;
  padding: 10px 12px;
  font-weight: bold;
  color: #555;
  text-decoration: none;
  cursor: pointer;
}
.widget-list-link:hover {
  background: #f7f7f7;
}
li:last-child > .widget-list-link {
  border-radius: 0 0 3px 3px;
}
.widget-list-link > img {
  float: left;
  width: 32px;
  height: 32px;
  margin: 2px 12px 0 0;
}
.widget-list-link > span {
  display: block;
  font-size: 11px;
  font-weight: normal;
  color: #999;
}

</style>
<script>  
   function home() {
      document.forms[0].action='home.action';  
      document.forms[0].submit();  
   }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="widget">
    <ol class="widget-list" id="home">
      <decorator:body/>
    </ol>

    <ul class="widget-tabs">
      <li class="widget-tab">
        <a href="#home" class="widget-tab-link">home</a>
      <li class="widget-tab">
        <a href="#" class="widget-tab-link">login</a>
      <li class="widget-tab">
        <a href="#" class="widget-tab-link">register</a>
    </ul>
  </div>
  
	<div class="about">
	    <p class="about-links">
	      <a href="http://www.utdallas.edu" target="_parent">University of Texas at Dallas</a>
	    </p>
	    <p class="about-author">
	      &copy; 2013 <a href="#" target="_blank">Quiz</a> -
	      <a href="#" target="_blank">Team Incredibles</a><br>
	      Developed by <a href="#" target="_blank">Teja</a>
	    </p>
  	</div>
</body>
</html>