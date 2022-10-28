<%@ page import="me.java.util.Status" %>
<%@ page import="java.io.IOException" %>
<%@ page import="me.java.session.SessionMgr" %>
<%@ page import="me.java.cookie.CookieMgr" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../layout/header.jsp"/>
</header>


<%--<%--%>
<%--    if (session.getAttribute("SESSION_ID") != null) {--%>
<%--        response.sendRedirect("../index.jsp");--%>
<%--    }--%>

<%--%>--%>

<%@ include file="nonLoginFilter.jsp"%>

<%
    // 자동 로그인
    SessionMgr sessionMgr = SessionMgr.getInstance();
    CookieMgr cookieMgr = CookieMgr.getInstance();

    String uId = cookieMgr.get(request, "COOKIE_ID");
    String autoLogin = cookieMgr.get(request, "AUTO_LOGIN");

    if (autoLogin != null) {
        if (autoLogin.equals("true")) {
            sessionMgr.create(session, uId);
            response.sendRedirect("../index.jsp");
        }
    }
%>

<%

    if (session.getAttribute("login") != null) {
        if (session.getAttribute("login") == Status.FAIL) {
%>
<script>alert("Login Fail!")</script>
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

<%

    if (session.getAttribute("withdraw") != null) {

        if (session.getAttribute("withdraw") == Status.SUCCESS) {

%>
<script>alert("Membership Cancellation Success!")</script>
<%
        }
        session.removeAttribute("withdraw");
    }
%>


<main>
    <h1>LOGIN</h1>
    <div>
        <form id="login__form" method="post" action="../DoLoginServlet">
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
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>
