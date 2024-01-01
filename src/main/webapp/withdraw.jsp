<%@ page import="com.sadhin.ebanking.dto.UserDetail" %>
<%@ page import="com.sadhin.ebanking.dto.BalanceDetail" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.sadhin.ebanking.service.TransactionService" %>
<%@ page import="java.math.RoundingMode" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12/31/2023
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>withdraw</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
<header>
    <a class="underlineHover" href="dashboard">E Banking</a>
</header>
<%
    UserDetail userDetail = (UserDetail) request.getSession().getAttribute("userDetail");
    BalanceDetail balanceDetail = new TransactionService().getBalanceDetail(userDetail.getUserId());
    BigDecimal withdrawable = new BigDecimal("0.00");
    if (balanceDetail.getBalance().compareTo(new BigDecimal("100.00")) > 0 ){
        withdrawable = balanceDetail.getBalance().subtract(new BigDecimal("100.00")).setScale(2, RoundingMode.HALF_UP);
    }
%>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <h2 class="active"> Withdraw </h2><p>  </p>
        <a class="underlineHover" >Withdraw Balance  :  <%=withdrawable%>  <%=balanceDetail.getCurrency()%></a><p>  </p>

        <form  action="${pageContext.request.contextPath}/WithdrawServlet" method="post">
            <input type="number" id="amount" class="fadeIn second" name="amount" placeholder="amount" min="0" max="<%=withdrawable%>" step="0.01">
            <input type="submit" class="fadeIn fourth" value="Withdraw">
        </form>

        <div id="formFooter">
            <a class="underlineHover" href="balance">Balance</a><p>  </p>
            <a class="underlineHover" href="deposit">Deposit</a><p>  </p>
            <a class="underlineHover" href="#">Transaction History</a>
        </div>
    </div>
</div>

</body>
</html>
