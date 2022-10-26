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
<%
    String title = "";
    if (request.getParameter("title") != null) {
        title = request.getParameter("title");
    }

    String numFile = "";
    if (request.getParameter("numFile") != null) {
        numFile = request.getParameter("numFile");
    }

%>
<main>
    <h1>File Select</h1>
    <div>
        <p>Hello! "<%=uId%>"</p>
        <p>Please complete the form to upload your file 👇🏻</p>
    </div>
    <%
        if (numFile.equals("")) {
    %>
    <div>

        <form method="post">
            <div class="form__list">
                <label for="title">TITLE</label>
                <input type="text" id="title" name="title" required>
            </div>

            <div class="form__list">
                <label for="numFile">FILE</label>
                <input type="number" id="numFile" name="numFile"  min="1" max="5" required>
            </div>
            <input type="submit" value="upload">
        </form>
    </div>
    <%
        } else {
    %>
    <div>
        <p>Title: <%=title%></p>
        <p>Selected Number of File: <%=numFile%></p>
    </div>

    <div>

        <form method="post" enctype="multipart/form-data" accept-charset="UTF-8" action="../DoMultiFileUploadServlet">
            <div class="form__list">
                <input type="hidden" name="title" value="<%=title%>">
            </div>

            <div class="form__list">
                <label for="file">FILE</label>

                    <%
                        for (int i = 0; i < Integer.parseInt(numFile); i++) {
                    %>
                        <div class="form__list" style="margin: 5px">
                            <input type="file" id="file" name="selectFile<%=i%>">
                        </div>
                    <%
                        }
                    %>
            </div>
            <input type="submit" value="upload">

        </form>
    </div>
    <%
        }
    %>
</main>


<footer>
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>
