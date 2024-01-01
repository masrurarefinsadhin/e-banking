<%@ page import="com.sadhin.ebanking.dto.UserDetail" %>
<%@ page import="javax.jws.soap.SOAPBinding" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12/31/2023
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
<header>
    <a class="underlineHover" href="dashboard">E Banking</a>
</header>
<%
    UserDetail userDetail  = (UserDetail) session.getAttribute("userDetail");
%>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <a class="underlineHover" > Name  :   <%=userDetail.getName()%></a><p>  </p>
        <a class="underlineHover" > Account Number  :   <%=userDetail.getUserId()%></a><p>  </p>
        <a class="underlineHover" > Email  :   <%=userDetail.getEmail()%></a><p>  </p>
        <a class="underlineHover" > phone  :   <%=userDetail.getPhone()%></a><p>  </p>

    <div id="formFooter">
        <a class="underlineHover " href="balance">Balance</a><p>  </p>
        <a class="underlineHover" href="deposit">Deposit</a><p>  </p>
        <a class="underlineHover" href="withdraw">Withdraw</a><p>  </p>
        <a class="underlineHover" href="#">Transaction History</a>
    </div>
    </div>
</div>


</body>
</html>
