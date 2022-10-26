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
<%--    String uId = "";--%>
<%--    if (session.getAttribute("SESSION_ID") != null) {--%>
<%--        uId = (String) session.getAttribute("SESSION_ID");--%>
<%--    } else {--%>
<%--        response.sendRedirect("../non-login/login.jsp");--%>
<%--    }--%>
<%--%>--%>

<%@ include file="loginFilter.jsp"%>

<main>
    <h1>LOGOUT</h1>
    <div>Hello! "<%=uId%>"</div>
    <script>
        const isLogout = confirm("Logout ?");
        if (isLogout) {
            location.href = "../DoLogoutServlet";
        } else {
            location.href = "../index.jsp";
        }
    </script>
</main>

<footer class="main__nav__next">
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>
