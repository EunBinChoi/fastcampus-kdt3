<%@ page import="me.java.util.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<header>
    <jsp:include page="../layout/header.jsp"/>
</header>


<%--<%--%>
<%--    String uId = "";--%>
<%--    if (session.getAttribute("SESSION_ID") != null) {--%>
<%--        uId = (String) session.getAttribute("SESSION_ID");--%>
<%--    } else {--%>
<%--        response.sendRedirect("../non-login/login.jsp");--%>
<%--    }--%>
<%--%>--%>

<%@ include file="loginFilter.jsp"%>


<%

    if (session.getAttribute("cookie") != null) {
        if (session.getAttribute("cookie") == Status.SUCCESS) {
%>
<script>alert("Cookie Delete Success!")</script>
<%

} else if (session.getAttribute("cookie") == Status.FAIL) {

%>
<script>alert("Cookie Delete Fail!")</script>
<%
        }
        session.removeAttribute("cookie");
    }
%>



<main>
    <h1>COOKIE PAGE</h1>
    <div>
        <form id="login__form" method="post" action="../DoCookieServlet">
            <div>Check Cookie Name to Delete.</div>
            <%

                Cookie[] cookies = request.getCookies();

                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName() != null) {
            %>
            <div class="form__list">
                <input type="checkbox" id="cookie" name="cookie" value="<%=cookie.getName()%>"/>
                <label><%=cookie.getName()%>: <%=cookie.getValue()%></label>
            </div>

            <%
                        }
                    }
                }

            %>
            <input id="submit" type="submit" name="submit" value="Submit">
        </form>
    </div>
</main>


<footer class="main__nav__next">
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>
