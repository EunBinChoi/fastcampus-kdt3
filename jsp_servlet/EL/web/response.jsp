<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("UTF-8");
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
    <h1>RESPONSE</h1>
    <div>
        <p>ID: ${param.uId}</p>
        <p>PASSWORD: ${param.uPw}</p>
        <fieldset>
            <legend>HOBBY</legend>
            <p>${paramValues.hobby[0]}</p>
            <p>${paramValues.hobby[1]}</p>
            <p>${paramValues.hobby[2]}</p>
            <p>${paramValues.hobby[3]}</p>
            <p>${paramValues.hobby[4]}</p>
        </fieldset>
    </div>
    <div>
        <p>ID: ${param["uId"]}</p>
        <p>PASSWORD: ${param["uPw"]}</p>
        <fieldset>
            <legend>HOBBY</legend>
            <p>${paramValues["hobby"][0]}</p>
            <p>${paramValues["hobby"][1]}</p>
            <p>${paramValues["hobby"][2]}</p>
            <p>${paramValues["hobby"][3]}</p>
            <p>${paramValues["hobby"][4]}</p>
        </fieldset>
    </div>
    <div>
        <%
            String uId = "";
            if (request.getParameter("uId") != null) {
                uId = request.getParameter("uId");
            }

            String uPw = "";
            if (request.getParameter("uPw") != null) {
                uPw = request.getParameter("uPw");
            }

            String[] hobbies = null;
            if (request.getParameterValues("hobby") != null) {
                hobbies = request.getParameterValues("hobby");
            }
        %>
        <p>ID: <%=uId%></p>
        <p>PASSWORD: <%=uPw%></p>
        <fieldset>
            <legend>HOBBY</legend>
            <%
                for (String hobby: hobbies) {
                    out.println("<p>" + hobby + "</p>");
                }
            %>
        </fieldset>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
