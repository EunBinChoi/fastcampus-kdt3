<%@ page import="org.example.overview.utils.Status" %>
<%@ page import="org.example.overview.cookies.CookieMgr" %>
<%@ page import="java.util.Arrays" %>
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
    showMessage(request, response, "cookie", Status.SUCCESS);
    showMessage(request, response, "cookie", Status.FAIL);
%>


<main>
    <h1>COOKIE PAGE</h1>
    <div>Hello! ${uId}</div>

    <div>Check Cookie Name to Delete.</div>
    <form method="post" action="/members/cookies/rm">
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
</main>


<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
