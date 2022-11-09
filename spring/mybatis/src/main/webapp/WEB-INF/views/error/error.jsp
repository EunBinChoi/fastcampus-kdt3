<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>SPRING</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<header><jsp:include page="../layout/header.jsp"/></header>
<main>
    <h1>Error - ${exception}</h1>
    <p>Failed URL: ${url}</p>
</main>
<footer><jsp:include page="../layout/footer.jsp"/></footer>
</body>
</html>