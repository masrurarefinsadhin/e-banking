<%@ page import="com.sadhin.ebanking.dto.UserDetail" %>
<%@ page import="com.sadhin.ebanking.dto.BalanceDetail" %>
<%@ page import="com.sadhin.ebanking.service.TransactionService" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.math.RoundingMode" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 12/31/2023
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>balance</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
<header>
    <a class="underlineHover" href="dashboard">E Banking</a>
</header>
<%
    UserDetail userDetail = (UserDetail) request.getSession().getAttribute("userDetail");
    BalanceDetail balanceDetail = new TransactionService().getBalanceDetail(userDetail.getUserId());
    BigDecimal balance = balanceDetail.getBalance().setScale(2, RoundingMode.HALF_UP);
    BigDecimal withdrawable = new BigDecimal("0.00");
    if (balanceDetail.getBalance().compareTo(new BigDecimal("100.00")) > 0 ){
        withdrawable = balanceDetail.getBalance().subtract(new BigDecimal("100.00")).setScale(2, RoundingMode.HALF_UP);
    }
%>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Balance </h2><p>  </p>
        <a class="underlineHover" >Total Balance  :  <%=balance%>  <%=balanceDetail.getCurrency()%></a><p>  </p>
        <a class="underlineHover" >Withdraw able Balance  :    <%=withdrawable%></a><p>  </p>

        <div id="formFooter">
            <a class="underlineHover" href="deposit">Deposit</a><p>  </p>
            <a class="underlineHover" href="withdraw">Withdraw</a><p>  </p>
            <a class="underlineHover" href="#">Transaction History</a>
        </div>
    </div>
</div>

</body>
</html>
