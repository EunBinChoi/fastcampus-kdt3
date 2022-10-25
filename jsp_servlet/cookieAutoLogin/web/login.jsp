<%@ page import="util.Status" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<%
    if (session.getAttribute("SESSION_ID") != null) {
        response.sendRedirect("./index.jsp");
    }

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName() != null) {
                if (cookie.getName().equals("AUTO_LOGIN")) {
                    String value = cookie.getValue();
                    if (value.equals("true")) {
%>
<script>
    location.href = "./DoAutoLoginServlet";
</script>
<%
                    }
                }
            }
        }
    }
%>



<%

    if (session.getAttribute("login") != null) {
        if (session.getAttribute("login") == Status.FAIL) {
%>
<script>alert("Login Fail!")</script>
<%

} else if (session.getAttribute("login") == Status.NULL) {

%>
<script>alert("Sign Up First.")</script>
<%
        }
        session.removeAttribute("login");
    }
%>

<%

    if (session.getAttribute("signup") != null) {

        if (session.getAttribute("signup") == Status.SUCCESS) {

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
        <form id="login__form" method="post" action="./DoLoginServlet">
            <div class="form__list">
                <label for="uId">ID: </label>
                <%-- key-value (name-value)   --%>
                <input type="text" id="uId" name="uId" placeholder="INPUT YOUR ID" required/>
            </div>

            <div class="form__list">
                <label for="uPw">PASSWORD: </label>
                <input type="password" id="uPw" name="uPw" placeholder="INPUT YOUR PASSWORD" required/>
            </div>

            <div class="checkbox__form">
                <label for="save">AUTO LOGIN: </label>
                <input id="save" type="checkbox" name="save"/>
            </div>
            <input id="submit" type="submit" name="submit" value="Submit">
        </form>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
