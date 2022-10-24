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
    if (session.getAttribute("uId") != null) {
        uId = (String) session.getAttribute("uId");
    } else {
        response.sendRedirect("./login.jsp");
    }
%>


<main>
    <h1>LOGOUT</h1>
    <div>Hello! "<%=uId%>"</div>
    <script>
        const val = confirm("Logout?");
        if (val) {
            location.href = "./DoLogoutServlet";
        } else {
            location.href = "./index.jsp";
        }
    </script>
</main>

<footer class="main__nav__next">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
