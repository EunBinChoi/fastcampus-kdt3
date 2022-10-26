<%@ page import="me.java.session.SessionMgr" %>
<%@ page import="java.io.File" %>
<%@ page import="me.java.file.FilePost" %>
<%@ page import="java.util.List" %>
<%@ page import="me.java.file.FileInfo" %>
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

    FilePost filePost = null;
    if (session.getAttribute("filePost") != null) {
        filePost = (FilePost) session.getAttribute("filePost");
    }

    String userId = filePost.getUserId();
    String title = filePost.getTitle();
    List<FileInfo> fileList = filePost.getFiles();
    System.out.println("fileList = " + fileList);

    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        System.out.println(e.getMessage());
    }

%>
<main>
    <h1>File View</h1>
    <div>
        <p>User - <%=userId%></p>
        <p>Title - <%=title%></p>
    </div>
    <div class="file__list">
        <%
            for(int i = 0; i < fileList.size(); i++) {
                if (fileList.get(i).getFileName() == null) continue;
                if (fileList.get(i).getFileType().contains("image")) {
                    %>
                    <div style="margin: 10px">
                        <img alt="image" src="<%=fileList.get(i).getFileLocation()%>" height="100px">
                        <p><a href="<%=fileList.get(i).getFileLocation()%>" download>DOWNLOAD</a></p>
                    </div>
                    <%
                    }
                    else {
                    %>
                    <div style="margin: 10px">
                        <iframe src="<%=fileList.get(i).getFileLocation()%>" height="100px" width="350px"/>
                    </div>
                    <%
                }
            }
        %>

    </div>
</main>


<footer>
    <jsp:include page="../layout/footer.jsp"/>
</footer>
</body>
</html>
