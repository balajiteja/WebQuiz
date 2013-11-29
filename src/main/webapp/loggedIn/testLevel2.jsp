<%@page import="com.webq.db.RetrieveDbInfo"%>
<%@page import="com.webq.beans.User"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Map.Entry" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.webq.beans.Question"%>
<%@page import="com.webq.beans.QuestionsCollection"%>
<%@ include file="/Taglib/taglibs.jsp" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test level 1</title>
<link rel="stylesheet" href="<s:url value='/styles/test.css'/>" type="text/css" media="all">
<script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
	
  $(window).blur(function(){
	document.formex.action='testAction.action'; 
	document.getElementById('statusVal').value = "tried_to_cheat";
	document.formex.submit();
  });
});
</script>
<script>
	var questions= new Array();
	var qi = 0;
	var score = 0;
	var firstQuestion = true;
	var posMark = 3;
	var negMark = 1;
	var count = 150;
	var testCompl = false;
	var levelId = 2;
	var skippedQuestionID = new Array();
	var m = 0;
	var k = 0;
	var flag = false;
	var total = 0;
	
	function populateQ(){

	<% 
	
	QuestionsCollection qc = (QuestionsCollection) session.getAttribute("questions");
	ArrayList<Question> q = qc.getQuestions();
	Integer sc = new Integer(0);
	
	%>
	var j=0;
	<%
	    for (int i = 0; i < q.size(); i++) {
	%>
			questions[j] = function(){
			var question = {};
			question.qDesc="<%=q.get(i).getQuestionDescription()%>";
			question.options = ["<%=q.get(i).getOption1()%>","<%=q.get(i).getOption2()%>","<%=q.get(i).getOption3()%>","<%=q.get(i).getOption4()%>"];
			question.answer = "<%=q.get(i).getAnswer()%>";
			question.answered = "";
			question.attempted = false;
			return question;
			}();
			j++;
		
	<%	}
	%>
	document.getElementById("testSec").style.visibility = "visible";
	document.getElementById("poplt").style.visibility = "hidden";
	countDown();
	showQuestion();
	}

function showQuestion(){
	var ansd = true;
	if(!firstQuestion)
	{
		document.getElementById("resultsfunction").innerHTML = "checking";
		if(flag && total==10)
			{
			ansd=evaluateSkippedQuestion();
			if(ansd)
				{
			clearError();
			clearRadio();
			displaySkippedQuestion();
				}
			}
		else
			{
			total++;
			ansd = evaluate();
			}
		
	}
	if(ansd){
		
			clearError();
			clearRadio();
			if(qi>=questions.length ){
				displaySkippedQuestion();
			}
			updateQuestionNo();
			updateScore();
			updateQuestion();
			firstQuestion = false;
	}
}

function displaySkippedQuestion(){
	flag=true;
	document.getElementById("resultsfunction").innerHTML = "Reached";
	$('input[name=skip]').hide();
	var ansd = true;
	//ansd = evaluateSkippedQuestion();
	if(ansd){
		
			clearError();
			clearRadio();
			if(m>0)
				{
				qi=skippedQuestionID[m-1];
				document.getElementById("resultsfunction").innerHTML = qi;
				m--;
				updateQuestionNo();
				updateScore();
				updateQuestion();
				firstQuestion = false;
				}
			else{
				showResults();
			}
	}
}
function showSkipQuestion(){
	flag = true;
	document.getElementById("resultsfunction").innerHTML = "Skipped";
				if(skippedQuestionID.length>0 && qi>=questions.length-1)
					{
						total++;
						skippedQuestionID[m]=qi;
						m++;
						qi= skippedQuestionID[m-1];
						displaySkippedQuestion();
						firstQuestion=false;
					}
				else if(qi<questions.length)
					{
						total++;
						skippedQuestionID[m]=qi;
						m++;
						clearRadio();
						qi=qi+1;
						updateQuestionNo();
						updateScore();
						updateQuestion();
						firstQuestion = false;
					}
		
		
	//}
}

function updateQuestionNo(){
	document.getElementById("noOfQ").innerHTML= "questions: "+(qi+1)+"/"+(questions.length);
}

function createQuestionTable(){
	var qTable = document.createElement("table");
	
}

function updateQuestion(){
	document.getElementById("questionDesc").innerHTML= (qi+1)+":"+questions[qi].qDesc.toString() ;
	for(var o=0;o<questions[qi].options.length;o++){
	document.getElementById("option"+(o+1)).innerHTML= questions[qi].options[o];
	}
}
function updateScore(){
		document.getElementById("score").innerHTML= score ;
}

function clearRadio(){
	document.getElementById("r1").checked=false;
	document.getElementById("r2").checked=false;
	document.getElementById("r3").checked=false;
	document.getElementById("r4").checked=false;
}

function evaluateSkippedQuestion(){

	var radios = document.getElementsByName('a');
	var rValue = "notchosen";	
	for (var i = 0, length = radios.length; i < length; i++) {
	    if (radios[i].checked) {
	        rValue = radios[i].value;
	        break;
	    }
	}
	document.getElementById("rad").innerHTML = rValue;
	 if(rValue=="notchosen"){
		clearError();
		showError("please select an option");
		alert("please select an option");
		return false;
	 }
	 if(questions[qi].options[rValue-1]==questions[qi].answer || rValue== parseInt(questions[qi].answer)){
		 document.getElementById("resultsfunction").innerHTML = "Correct";
	 	score=score + posMark;
	 }
	 else{
		 document.getElementById("resultsfunction").innerHTML = "Incorrect";
		 if(score-negMark >= 0){
		 score = score - negMark;
		 }
	 }
	 questions[qi].answered= questions[qi].options[rValue-1];
	 questions[qi].attempted = true;
	 return true;
}

function evaluate(){

	var radios = document.getElementsByName('a');
	var rValue = "notchosen";	
	for (var i = 0, length = radios.length; i < length; i++) {
	    if (radios[i].checked) {
	        rValue = radios[i].value;
	        break;
	    }
	}
	document.getElementById("rad").innerHTML = rValue;
	 if(rValue=="notchosen"){
		clearError();
		showError("please select an option");
		alert("please select an option");
		return false;
	 }
	 if(questions[qi].options[rValue-1]==questions[qi].answer || rValue== parseInt(questions[qi].answer)){
		 document.getElementById("resultsfunction").innerHTML = "Correct";
	 	score=score + posMark;
	 }
	 else{
		 document.getElementById("resultsfunction").innerHTML = "Incorrect";
		 if(score-negMark >= 0){
		 score = score - negMark;
		 }
	 }
	 questions[qi].answered= questions[qi].options[rValue-1];
	 questions[qi].attempted = true;
	 qi=qi+1;
	 return true;
}

function showError(message){
	var errorDiv = document.getElementById("error");
	var error = document.createElement("h1");
	error.innerHTML = message;
	errorDiv.appendChild(error);
}

function clearError(){
	var errorDiv = document.getElementById("error");
	errorDiv.innerHTML = "";
}

function showResults(){
		document.getElementById("testSec").style.visibility = "hidden";
		document.getElementById("finish").style.visibility = "visible";
		document.getElementById('scoreVal').value = parseInt(score);
		document.getElementById('levelId').value = parseInt(levelId);
		
		var result = document.getElementById("result");
		var div3 = document.createElement("h2");
		testCompl = true;
	   	div3.innerHTML= 'Your Score: ' + score+'</br>';
	    result.appendChild(div3);
	
	for(var k=0;k<questions.length;k++){
		if(questions[k].attempted){
			var div1 = document.createElement("h2");
			var index = k+1;
			div1.innerHTML = index+ ' Question: ' + questions[k].qDesc+'</br>';
		    result.appendChild(div1);
		    
		    var div2 = document.createElement("p");
		    var ans = questions[k].answer;
		    if(parseInt(ans)==1||parseInt(ans)==2||parseInt(ans)==3||parseInt(ans)==4){
			   	div2.innerHTML= ' Correct answer: ' + questions[k].options[parseInt(ans)-1]+'</br>';
		    }
		    else{
		   	div2.innerHTML= ' Correct answer: ' + questions[k].answer+'</br>';
		    }
		    result.appendChild(div2);
		    
		    var div3 = document.createElement("p");
		   	div3.innerHTML= ' Your answer: ' + questions[k].answered+'</br>';
		    result.appendChild(div3);
		}
	}
}

function logout() {
	
    document.forms[0].action='logoutAction.action';  
    document.forms[0].submit();  
 } 
 
function finish() {
    document.forms[0].action='testLevel1.action';  
    document.forms[0].submit();  
 } 


function countDown(){
 if (count <=0){ 
	  showResults();
 }else{ 
	 if(count<=10){
		 document.getElementById("time").style.color="red";
	 }
	  count--;  
	  days = parseInt(count / 86400);
	  count = count % 86400;
	   
	  hours = parseInt(count / 3600);
	  count = count % 3600;
	   
	  minutes = parseInt(count / 60);
	  seconds = parseInt(count % 60);
	   
	  // format countdown string + set tag value
	  document.getElementById("time").innerHTML = hours + "h, "
	  + minutes + "m, " + seconds + "s"; 
	  if(!testCompl){
	  setTimeout("countDown()", 1000)  ;
	  }
 }  
}  

var window_focus;
$(document).ready(function(){
	$(window).focus(function() {
	    window_focus = true;
	});
	$(window).blur(function() {
		document.formex.action='testAction.action'; 
		document.getElementById('statusVal').value = "tried_to_cheat";
		document.formex.submit();
	    });
});

</script>

</head>

<body>

<div id="questions"></div>
<div id="error"></div>
<div id="result"></div>

<div id="poplt">
Do not reload or switch tabs. It will be considered as cheating.
<button onclick="populateQ()">Start Test</button> 
</div>

<div id="testSec" style="visibility:hidden">
	<table>
		<tr>
			<td>
				<table>
					<tr>
						<th>Score</th>
						<th>Questions</th>
						<th>radio</th>
						<th>Previous Result</th>
						<th>Time</th>
	
					</tr>
					<tr>
						<td><div id="score"></div></td>
						<td><div id="noOfQ"></div></td>
						<td><div id="rad"></div></td>
						<td><div id="resultsfunction"></div></td>
						<td><div id="time"></div></td>
	
					</tr>
				</table>
				<table>
					<tr>
						<td>Question:</td>
					</tr>

					<tr>
						<td width="100%"><div id="questionDesc"></div></td>
					</tr>
				</table>
				<table>	
					<tr>
						<td><input  type="radio" id="r1" name="a" value= "1" /></td>
						<td><div id="option1"></div></td>
					</tr> 
	
					<tr>
						<td><input  type="radio" id="r2" name="a" value="2" /></td>
						<td><div id="option2"></div></td>
					</tr>
					
					<tr>
						<td><input  type="radio" id="r3" name="a" value="3" /></td>
						<td><div id="option3"></div></td>
					</tr>
					
					<tr>
						<td><input  type="radio" id="r4" name="a" value="4" /></td>
						<td><div id="option4"></div></td>
					</tr>
					
				</table>
		<tr>
			<td><input type="button" value="next" name="next" onclick="showQuestion()"></td>
			<td><input type="button" value="skip" name="skip" onclick="showSkipQuestion()"></td>
		</tr>
	</table>

</div>

<s:form name="formex" action="testLevel1" method="post">
	<s:hidden id="levelId" name="levelId"/>
	<s:hidden id="scoreVal" name="score"/>
	<s:hidden id="statusVal" name="statusTest"/>
	<s:submit id="finish"  style="visibility:hidden" value="finish"/>
</s:form>

</body>
</html>