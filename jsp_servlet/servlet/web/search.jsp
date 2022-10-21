<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<main>
    <div class="search">
        <form action="./DoSearchServlet" method="get">
            <label for="search-box">Search ⌨️</label>
            <input type="text" id="search-box" name="search" placeholder="search...">
        </form>
    </div>
</main>
<div></div>
<div></div>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
