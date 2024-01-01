<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
<header>
    <a class="underlineHover" href="index">E Banking</a>
</header>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Sign In </h2>
        <!-- Login Form -->
        <form  action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <input type="text" id="email" class="fadeIn second" name="email" placeholder="email">
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>
        <div id="formFooter">
            <a class="underlineHover" href="registration">Sign up</a>
        </div>
    </div>
</div>

</body>
</html>
