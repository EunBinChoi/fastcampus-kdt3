<%@ page import="util.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<%

    if (session.getAttribute("login") != null) {
        if (session.getAttribute("login") == Status.FAIL) {
%>
            <script>alert("Login Fail!")</script>
<%
            session.removeAttribute("login");

        }
    }
%>

<%

    if (session.getAttribute("signup") != null) {

        if(session.getAttribute("signup") == Status.SUCCESS) {

%>
            <script>alert("Sign Up Success!")</script>
<%
        }
        session.removeAttribute("signup");
    }
%>


<main>
    <h1>LOGIN</h1>
    <div>
        <form method="post" action="./DoLoginServlet">
            <div class="form__list">
                <label for="uId">ID: </label>
                <%-- key-value (name-value)   --%>
                <input type="text" id="uId" name="uId" placeholder="INPUT YOUR ID" required/>
            </div>

            <div class="form__list">
                <label for="uPw">PASSWORD: </label>
                <input type="password" id="uPw" name="uPw" placeholder="INPUT YOUR PASSWORD" required/>
            </div>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
