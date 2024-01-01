<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12/31/2023
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
<header>
    <a class="underlineHover" href="dashboard">E Banking</a>
</header>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Sign Up </h2>
        <!-- Login Form -->
        <form  action="${pageContext.request.contextPath}/RegistrationServlet" method="post">
            <input type="text" id="name" class="fadeIn second" name="name" placeholder="name">
            <input type="text" id="email" class="fadeIn second" name="email" placeholder="email">
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="text" id="mobileNumber" class="fadeIn third" name="mobileNumber" placeholder="mobileNumber">

            <input type="submit" class="fadeIn fourth" value="Register">
        </form>
        <div id="formFooter">
            <a class="underlineHover" href="index">Sign In</a>
        </div>
    </div>
</div>

</body>
</html>
