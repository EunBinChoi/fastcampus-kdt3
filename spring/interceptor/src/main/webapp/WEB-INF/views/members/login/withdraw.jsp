<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../../layout/header.jsp"/>
</header>


<%@include file="../../messages/showMessage.jsp"%>
<%
    showMessage(request, response, "withdraw", Status.FAIL);
%>

<main>
    <h1>WITHDRAW</h1>
    <div>Hello! ${uId}</div>

    <div>
        <h3>Notice for deleting your information.</h3>
        <p>Please read the introduction for membership cancellation.</p>
    </div>
    <form id="login__form" method="post" action="/members/private/rm/${uId}">

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
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
