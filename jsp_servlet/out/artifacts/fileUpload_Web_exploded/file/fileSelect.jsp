<%@ page import="me.java.session.SessionMgr" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 10/26/22
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
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

<%@ include file="../login/loginFilter.jsp" %>
<main>
    <h1>File Select</h1>
    <div>
        <p>Hello! "<%=uId%>"</p>
        <p>Please complete the form to upload your file 👇🏻</p>
    </div>
    <div>
        <form method="post" enctype="multipart/form-data" accept-charset="UTF-8" action="../DoFileUploadServlet">
            <div class="form__list">
                <label for="title">TITLE</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form__list">
                <label for="file">FILE</label>
                <input type="file" id="file" name="file" required>
            </div>
            <input type="submit" value="upload">
        </form>
    </div>
</main>


<footer>
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>
