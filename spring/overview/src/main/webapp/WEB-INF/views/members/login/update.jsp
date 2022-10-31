<%@ page import="org.example.overview.utils.Status" %>
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
    showMessage(request, response, "update", Status.FAIL);
%>

<main>
    <h1>UPDATE</h1>
    <div>Hello! ${uId}</div>


    <div>
        <form method="post" action="/members/private/rev/${uId}">

            <div class="form__list">
                <label for="uPw">CURRENT PASSWORD: </label>
                <input type="password" id="uPw" name="uPw" placeholder="INPUT YOUR PASSWORD" required/>
            </div>


            <div class="form__list">
                <label for="uNewPw">NEW PASSWORD: </label>
                <input type="password" id="uNewPw" name="uNewPw" placeholder="INPUT NEW PASSWORD"
                       pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}" required/>
            </div>

            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
