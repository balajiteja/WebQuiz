<%@page import="com.WebQ.beans.User"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.WebQ.beans.Question"%>
<%@page import="com.WebQ.beans.QuestionsCollection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test level 1</title>
<script>
	var questions= new Array();
	var qi = 0;
	var score=0;
	var firstQuestion = true;
	
	function populateQ(){

	<% 
	User u = (User)session.getAttribute("user");
	QuestionsCollection qc = (QuestionsCollection) session.getAttribute("questions");
	ArrayList<Question> q = qc.getQuestions();
	Integer sc = (Integer)session.getAttribute(u.getUserId()+1); 
	%>
	var j=0;
	<%
	    for (int i = 0; i < q.size(); i++) {
	%>
			questions[j] = function(){
			var question = {};
			question.qDesc="<%=q.get(i).getQuestionDescription()%>";
			question.option1 = "<%=q.get(i).getOption1()%>";
			question.option2 = "<%=q.get(i).getOption2()%>";
			question.option3 = "<%=q.get(i).getOption3()%>";
			question.option4 = "<%=q.get(i).getOption4()%>";
			question.answer = "<%=q.get(i).getAnswer()%>";
			question.answered = "";
			return question;
			}();
			j++;
		
	<%	}
	%>
	document.getElementById("testSec").style.visibility = "visible";
	document.getElementById("poplt").style.visibility = "hidden";
	showQuestion();
	}

	function showQuestion(){
	var ansd = true;
	if(!firstQuestion)
	{
		ansd = evaluate();
	}
	if(ansd){
		clearRadio();
		updateQuestionNo();
		if(qi>=questions.length){
			
			showResults();
			return;
		}
		updateScore();
		updateQuestion();
		firstQuestion = false;
	}
}

function updateQuestionNo(){
	document.getElementById("noOfQ").innerHTML= "questions: "+(qi+1)+"/"+(questions.length);
}

function updateQuestion(){
	document.getElementById("questionDesc").innerHTML= questions[qi].qDesc+(qi+1).toString() ;
	document.getElementById("option1").innerHTML= questions[qi].option1;
	document.getElementById("option2").innerHTML= questions[qi].option2 ;
	document.getElementById("option3").innerHTML= questions[qi].option3 ;
	document.getElementById("option4").innerHTML= questions[qi].option4 ;
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
		alert("choose an option");
		return false;
	 }
	 if(rValue==questions[qi].answer){
	 score=score+1;
	 }
	if(rValue==1){
	 questions[qi].answered= questions[qi].option1;
	}
	else if(rValue==2){
		 questions[qi].answered= questions[qi].option2;
		}
	else if(rValue==3){
		 questions[qi].answered= questions[qi].option3;
		}
	else if(rValue==4){
		 questions[qi].answered= questions[qi].option4;
		}
		qi=qi+1;
	 return true;
}

function showResults(){
		document.getElementById("testSec").style.visibility = "hidden";
		document.getElementById("finish").style.visibility = "visible";
		document.getElementById("status").style.visibility = "hidden";
		
		var result = document.getElementById("result");
		var div3 = document.createElement("h1");
	   	div3.innerHTML= 'your Score: ' + score+'</br>';
	    result.appendChild(div3);
	
	for(var k=0;k<questions.length;k++){
		var div1 = document.createElement("h1"); 
		div1.innerHTML = k+ ' Question: ' + questions[k].qDesc+'</br>';
	    result.appendChild(div1);
	    
	    var div2 = document.createElement("h2");
	   	div2.innerHTML= k+ ' Correct answer: ' + questions[k].answer+'</br>';
	    result.appendChild(div2);
	    
	    var div3 = document.createElement("h3");
	   	div3.innerHTML= k+ ' Your answer: ' + questions[k].answered+'</br>';
	    result.appendChild(div3);
	}
}



</script>
</head>
<body>
<div id="status">
Score: <div id="score"></div>
Questions: <div id="noOfQ"></div>
radio: <div id="rad"></div>
results function<div id="resultsfunction"></div>
Debugging :<div id="test"></div>
</div>
<div id="result"></div>

<button id="poplt" onclick="populateQ()">Start Test</button> 




<div id="testSec" style="visibility: hidden;">
	<table border="1" bgcolor="white" cellspacing="0" cellpadding="0">
		<tr>
			<td width="100%">
			
				<form name="form1">
				
				<b>Select Correct Answer</b>
					<table border="0" width="500px" cellspacing="2" cellpadding="4">
						<tr>
							<td width="50%">Question:</td>
						</tr>
	
						<tr>
							<td><div id="questionDesc"></div></td>
						</tr>
						
						<tr>
							<td>1: <input  type="radio" id="r1" name="a" value= "1" /></td>
							<td><div id="option1"></div></td>
						</tr> 
		
						<tr>
							<td>2: <input  type="radio" id="r2" name="a" value="2" /></td>
							<td><div id="option2"></div></td>
						</tr>
						
						<tr>
							<td>3: <input  type="radio" id="r3" name="a" value="3" /></td>
							<td><div id="option3"></div></td>
						</tr>
						
						<tr>
							<td>4: <input  type="radio" id="r4" name="a" value="4" /></td>
							<td><div id="option4"></div></td>
						</tr>
						
						<tr>
							<td><center><input type="button" value="next" name="next" onclick="showQuestion()"></center></td>
						</tr>
					</table>
				
				</form>
			</td>
		</tr>
	</table>

</div>

<button id="finish" style="visibility:hidden" onclick="showResults()">Finish</button>

</body>
</html>