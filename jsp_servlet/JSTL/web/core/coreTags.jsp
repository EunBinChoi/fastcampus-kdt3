<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Core 태그를 사용하기 위해서는 반드시 필요한 자원 URL과 prefix를 tablib에 선언 --%>

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
    <h1>CORE TAGS</h1>

    <div class="tag__list">
        <fieldset>
            <%-- c:set 선언된 변수들은 scope에 따라 저장소에 선언이 되기 때문에 getAttribute() 함수나 EL 문법으로 가지고 와야 함 --%>
            <legend>JSP 표현식으로 값 설정</legend>
            <p><c:set var="str3" value="str3" scope="page"/></p>
            <p><c:set var="str4" value="str4" scope="session"/></p>
        </fieldset>

        <fieldset>
            <%
                // 스크립트릿에서 문자열 str1, str2 각각 선언
                String str1 = "string";
                String str2 = null;
            %>
            <%-- jsp 페이지에 선언된 str1 출력, 만약 해당하는 값이 null이면 default값 출력 --%>
            <legend>JSP 표현식으로 값 출력</legend>
            <p>str1: <c:out value="<%=str1%>" default="default"/></p>
            <p>str2: <c:out value="<%=str2%>" default="default"/></p>

            <%-- str3, str4는 각각 page scope, session scope 객체에 살고 있는 변수이기 때문에 local 변수로 출력 불가능함 --%>
            <%--        <p>str3: <c:out value="<%=str3%>" default="default"/></p>--%>
            <%--        <p>str4: <c:out value="<%=str4%>" default="default"/></p>--%>
        </fieldset>

        <fieldset>
            <legend>EL 표현식으로 값 출력</legend>
            <p>str1: <c:out value="${str1}" default="default"/></p>
            <p>str2: <c:out value="${str2}" default="default"/></p>
            <p>str3: <c:out value="${str3}" default="default"/></p>
            <p>str4: <c:out value="${str4}" default="default"/></p>
        </fieldset>
    </div>

    <div class="tag__list">
        <fieldset>
            <%-- session에 저장한 str4를 제거 --%>
            <legend>str4 제거</legend>
            <p><c:remove var="str4"/></p>
        </fieldset>

        <fieldset>
            <%-- EL 문법으로 출력 (str4는 제거되서 보이지 않음 (빈 문자열 출력)) --%>
            <legend>str4 제거 후 출력 (EL 문법)</legend>
            <p>${str3}'s ${str4} ...</p>

            <%-- EL --%>
            <p>${pageScope.str3}</p>
            <p>${sessionScope.str4}</p>
        </fieldset>

        <fieldset>
            <%-- String s에 page 저장소에서 str3 가져옴 --%>
            <legend>str4 제거 후 출력 (JSP 문법)</legend>
            <%
                String s3 = (String) pageContext.getAttribute("str3");
                String s4 = (String) session.getAttribute("str4"); // null
            %>

            <p><b><%=s3%></b></p>
            <p><b><%=s4%></b></p>
        </fieldset>
    </div>


    <form method="get" action="coreTagsIf.jsp">
        <fieldset class="color__fieldset">
            <legend>FAVORITE COLOR</legend>
            <div class="form__list">
                <label for="uName">NAME</label>
                <input type="text" id="uName" name="uName" size="10">
            </div>

            <div class="form__list">
                <label for="color">COLOR</label>
                <select id="color" name="color">
                    <option value="red" selected>RED</option>
                    <option value="orange">ORANGE</option>
                    <option value="yellow">YELLOW</option>
                    <option value="green">GREEN</option>
                    <option value="blue">BLUE</option>
                    <option value="purple">PURPLE</option>
                </select>
            </div>
            <input type="submit" name="submit" value="Submit">
        </fieldset>
    </form>

</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
