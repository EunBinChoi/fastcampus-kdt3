<%@ page import="me.web.util.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<%
    String uId = "";
    if (session.getAttribute("SESSION_ID") != null) {
        uId = (String) session.getAttribute("SESSION_ID");
    } else {
        response.sendRedirect("./login.jsp");
    }
%>

<%

    if (session.getAttribute("withdraw") != null) {

        if (session.getAttribute("withdraw") == Status.FAIL) {

%>
<script>alert("Membership Cancellation Fail!")</script>
<%
        }
        session.removeAttribute("withdraw");
    }
%>


<main>
    <h1>WITHDRAW</h1>
    <div>
        <h3>Notice for deleting your information.</h3>
        <p>Please read the introduction for membership cancellation.</p>
    </div>
    <form id="login__form" method="post" action="./DoWithdrawServlet">

        <div class="form__list">
            <label for="uPw">PASSWORD: </label>
            <input type="password" id="uPw" name="uPw" placeholder="INPUT YOUR PASSWORD" required/>
        </div>

        <div class="checkbox__form">
            <label for="agree" style="color: darkred">check if you want to really delete your info.</label>
            <input type="checkbox" id="agree" name="agree" value="yes">
        </div>
        <input id="submit" type="submit" name="submit" value="Submit">
    </form>
</main>

<footer class="main__nav__next">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
