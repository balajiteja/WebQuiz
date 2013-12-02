<%@ include file="/Taglib/taglibs.jsp" %>

<head>
    <title>Login</title>
<style type="text/css">
  .login {
    margin: 50px auto;
    padding: 18px 20px;
    width: 200px;
    background: radial-gradient(farthest-corner, grey, black
        ) repeat scroll 0% 0% padding-box rgb(63, 101, 183);
    border-width: 1px;
    border-style: solid;
    border-color: rgb(23, 43, 78) rgb(23, 43, 78) rgb(20, 38, 71);
    -moz-border-top-colors: none;
    -moz-border-right-colors: none;
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    border-image: none;
    border-radius: 5px;
    box-shadow: 0px 1px rgba(255, 255, 255, 0.3) inset, 0px 0px 1px 1px rgba(255, 255, 255, 0.1) inset, 0px 2px 10px rgba(0, 0, 0, 0.5);
}
.login > h1 {
    margin-bottom: 20px;
    font-size: 16px;
    font-weight: bold;
    color: white;
    text-align: center;
    text-shadow: 0px -1px rgba(0, 0, 0, 0.4);
}
.login-input:focus {
    outline: 0px none;
    background-color: rgb(50, 72, 109);
    box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3) inset, 0px 0px 4px 1px rgba(255, 255, 255, 0.6);
}
.login-input {
    display: block;
    width: 90%;
    height: 37px;
    margin-bottom: 20px;
    padding: 0px 9px;
    color: white;
    text-shadow: 0px 1px black;
    background: linear-gradient(to bottom, rgba(0, 0, 0, 0.35), rgba(0, 0, 0, 0.2) 20%, transparent) repeat scroll 0% 0% grey;
    border-width: 1px;
    border-style: solid;
    border-right: 1px solid rgb(21, 36, 59);
    border-color: rgb(13, 24, 39) rgb(21, 36, 59) rgb(21, 36, 59);
    -moz-border-top-colors: none;
    -moz-border-right-colors: none;
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    border-image: none;
    border-radius: 4px;
    box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3) inset, 0px 1px rgba(255, 255, 255, 0.2);
}
input, textarea, select, label {
    font-family: inherit;
    font-size: 12px;
    -moz-box-sizing: border-box;
}
.login-submit {
    display: block;
    width: 100%;
    height: 37px;
    margin-bottom: 15px;
    font-size: 14px;
    font-weight: bold;
    color: rgb(41, 71, 121);
    text-align: center;
    text-shadow: 0px 1px rgba(255, 255, 255, 0.3);
    background: linear-gradient(to bottom, grey, white) repeat scroll 0% 0% padding-box rgb(173, 203, 250);
    border-width: 1px;
    border-style: solid;
    border-color: rgb(40, 68, 115) rgb(40, 68, 115) rgb(34, 59, 102);
    -moz-border-top-colors: none;
    -moz-border-right-colors: none;
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    border-image: none;
    border-radius: 4px;
    cursor: pointer;
    box-shadow: 0px 1px rgba(255, 255, 255, 0.5) inset, 0px 0px 7px rgba(255, 255, 255, 0.4) inset, 0px 1px 1px rgba(0, 0, 0, 0.15);
}
input, textarea, select, label {
    font-family: inherit;
    font-size: 12px;
    -moz-box-sizing: border-box;
}
    </style>
<script>  
   function login() {
      document.forms[0].action='loginAction.action';  
      document.forms[0].submit();  
   }
</script>
</head>

<form action="loginAction.action" class="login" method="post">
    <h1>Login</h1>
    <input type="text" name="userId" class="login-input" placeholder="Email Address" autofocus>
    <input type="password" name="password" class="login-input" placeholder="Password">
    <input type="submit" value="Login" class="login-submit" onclick="login()">
    <input type="reset" class="login-submit">
    <p class="login-help"></p>
</form>
