<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- Functions 태그를 사용하기 위해서는 반드시 필요한 자원 URL과 prefix를 tablib에 선언 --%>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../header.jsp"/>
</header>

<main>
    <h1>FUNCTIONS TAGS</h1>

    <div class="func__tag__list">
        <fieldset>
            <legend>Core 태그로 값 설정</legend>
            <c:set var="str" value="JSP :: Java Server Page"/>
            <p>str : <b>${str}</b></p>
        </fieldset>

        <fieldset>
            <legend>length</legend>
            <p>length : <b>${fn:length(str)}</b></p>
        </fieldset>

        <fieldset>
            <legend>substring</legend>
            <p>substring : <b>${fn:substring(str,0,8)}</b></p>
            <p>substringAfter : <b>${fn:substringAfter(str,"JSP")}</b></p>
            <p>substringBefore : <b>${fn:substringBefore(str,"Page")}</b></p>
        </fieldset>
    </div>

    <div class="func__tag__list">
        <fieldset>
            <legend>toUpperCase / toLowerCase</legend>
            <p>toUpperCase : <b>${fn:toUpperCase(str)}</b></p>
            <p>toLowerCase : <b>${fn:toLowerCase(str)}</b></p>
        </fieldset>


        <fieldset>
            <legend>replace</legend>
            <p>replace : <b>${fn:replace(str,"JSP","Android")}</b></p>
        </fieldset>

        <fieldset>
            <legend>indexOf</legend>
            <p>indexOf : <b>${fn:indexOf(str,"the")}</b></p>
        </fieldset>
    </div>

    <div class="func__tag__list">
        <fieldset>
            <legend>startsWith / endsWith</legend>
            <p>startsWith : <b>${fn:startsWith(str,"JSP")}</b></p>
            <p>endsWith : <b>${fn:endsWith(str,"JSP")}</b></p>
        </fieldset>

        <fieldset>
            <legend>contains / containsIgnoreCase</legend>
            <p>contains : <b>${fn:contains(str,"jsp")}</b></p>
            <p>containsIgnoreCase : <b>${fn:containsIgnoreCase(str,"jsp")}</b></p>
        </fieldset>

        <fieldset>
            <legend>trim</legend>
            <p>trim : ***<b>${fn:trim("   Hello!!!! JSP!!!!!   ")}</b>***</p>
        </fieldset>


        <%-- JSP :: Java Server Page
        String[] arr = JSP,::,Java,Server,Page
        "JSP&&::&&Java&&Server&&Page"   --%>
        <fieldset>
            <legend>split / join</legend>
            <c:set var="arr" value="${fn:split(str,' ')}"/>
            <p>join : <b>${fn:join(arr,"&&")}</b></p>
        </fieldset>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
