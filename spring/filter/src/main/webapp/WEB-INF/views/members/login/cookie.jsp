<%@ page import="org.example.overview.utils.Status" %>
<%@ page import="org.example.overview.cookies.CookieMgr" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SPRING</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" onload="this.media='all'">
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

<script>


    function deleteCookies() {

        $.ajax({
            type: "delete",
            url: "/members/cookies",
            data: JSON.stringify(
                {"cookie1": $("#cookie1").val(), "cookie2": $("#cookie2").val(), "cookie3": $("#cookie3").val()}),
            contentType: "application/json; charset=utf8",
            dataType: "json",


            success: (data, statusText, jqXHR) => {
                console.log("success");
            },
            error: (jqXHR, textStatus, errorThrown) => {
                console.log("error");
            }
        });
    }

</script>



<main>
    <h1>COOKIE PAGE</h1>
    <div>Hello! ${uId}</div>

    <div>Check Cookie Name to Delete.</div>
    <form>
        <%

            Cookie[] cookies = request.getCookies();

            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName() != null) {
                    %>

                    <div class="form__list">
                        <input type="checkbox" id="cookie" name="cookie" + <%=i + 1%> value="<%=cookies[i].getName()%>"/>
                        <label><%=cookies[i].getName()%>: <%=cookies[i].getValue()%></label>
                    </div>

                    <%
                }
            }

        %>
        <input id="submit" type="button" name="submit" value="Submit" onclick="deleteCookies()">
    </form>
</main>


<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
