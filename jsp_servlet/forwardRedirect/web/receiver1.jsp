<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, phone.Phone" %>
<%
    request.setCharacterEncoding("UTF-8");

    String msg = "";
    if (request.getParameter("msg") != null) {
        msg = request.getParameter("msg");
    }

    String phoneStr = "";
    if (request.getParameter("phone") != null) {
        phoneStr = request.getParameter("phone");
    }

%>

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

<main>
    <h1>RECEIVER 1</h1>
    <div>
        <p>REQUEST MESSAGE: <%=msg%>
        </p>
        <p>RECEIVER PHONE NUMBER: <%=phoneStr%>
        </p>
    </div>

    <form method="post">
        <fieldset>
            <legend>It is not the department in charge.<br/> May I connect you to the department in charge?</legend>

            <div>
                <input type="radio" id="yes" name="answer" value="yes" checked>
                <label for="yes">YES (Forward) </label>
            </div>
            <div>
                <input type="radio" id="no" name="answer" value="no">
                <label for="no">NO (Redirect)</label>
            </div>
            <div>
                <input type="hidden" id="msg" name="msg" value="<%=msg%>">
            </div>
            <div>
                <input type="hidden" id="phoneStr" name="phoneStr" value="<%=phoneStr%>">
            </div>
            <div>
                <input type="submit" name="submit" value="Submit">
            </div>
        </fieldset>
    </form>

    <%
        if (request.getParameter("answer") != null) {
            if (request.getParameter("answer").equals("yes")) {
                %>
                <jsp:forward page="receiver2.jsp">
                    <jsp:param name="isForward" value="true"/>
                </jsp:forward>
            <%
            } else {
                response.sendRedirect("request.jsp?redirect=yes");
            }
        }
    %>



</main>

<footer class="main__nav__next">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
