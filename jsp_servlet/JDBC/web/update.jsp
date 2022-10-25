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

    if (session.getAttribute("update") != null) {

        if (session.getAttribute("update") == Status.FAIL) {

%>
<script>alert("Member Information Update Fail!")</script>
<%
        }
        session.removeAttribute("update");
    }
%>



<main>
    <h1>UPDATE</h1>
    <div>
        <form method="post" action="./DoUpdateServlet">
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
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
