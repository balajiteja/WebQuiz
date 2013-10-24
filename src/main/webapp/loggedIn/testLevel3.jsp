<%@page import="com.WebQ.beans.User"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.WebQ.beans.Question"%>
<%@page import="com.WebQ.beans.QuestionsCollection"%>
<%@ include file="/Taglib/taglibs.jsp" %>
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
	var posMark = 1;
	var negMark = 0;
	var count = 100;
	var testCompl = false;
	var levelId = 3;
	
	function populateQ(){

	<% 
	User u = (User)session.getAttribute("user");
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
		ansd = evaluate();
	}
	if(ansd){
		clearError();
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

</script>
</head>
<body>



<div id="questions"></div>
<div id="error"></div>
<div id="result"></div>

<button id="poplt" onclick="populateQ()">Start Test</button> 

<div id="testSec" style="visibility:hidden">
	<table border="1" width="500px" bgcolor="white" cellspacing="0" cellpadding="0">
		<tr>
			<td width="100%">
			
				<form name="form1">
				<table border="0" width="800px" cellspacing="2" cellpadding="2">
						<tr>
							<td>Score</td>
							<td>Questions</td>
							<td>radio</td>
							<td>Previous Result</td>
							<td>Time</td>
		
						</tr>
						<tr>
							<td><div id="score"></div></td>
							<td><div id="noOfQ"></div></td>
							<td><div id="rad"></div></td>
							<td><div id="resultsfunction"></div></td>
							<td><div id="time"></div></td>
		
						</tr>
				</table>
				<b>Select Correct Answer</b>
					<table border="0" width="800px" cellspacing="2" cellpadding="2">
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

<s:form name="formex" action="testLevel1" method="post">
	<s:hidden id="levelId" name="levelId"/>
	<s:hidden id="scoreVal" name="score"/>
	<s:submit id="finish"  style="visibility:hidden" value="finish"/>
</s:form>

</body>
</html>