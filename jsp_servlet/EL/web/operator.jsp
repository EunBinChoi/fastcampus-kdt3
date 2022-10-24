<%@ page import="java.util.List" %>
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

<%
    // pageContext 저장소에 각각 J, S, P 값을 저장
    pageContext.setAttribute("J", 31);
    pageContext.setAttribute("S", 8);
    pageContext.setAttribute("P", 21);

    /*
     * setParameter(String, String)
     * 쿼리 스트링이나 사용자 요청에 따른 파라미터 값은 모두 문자열로 저장
     * 파라미터 외의 다른 객체를 페이지 저장소에 저장할 경우에는 setAttribute 이용
     * */

    /*
     * setAttribute(String, Object)
     * 파라미터 외의 다른 객체를 페이지 저장소에 저장할 경우
     * */

%>

<%
    // pageContext 저장소에 배열 저장
    List<String> stringList = List.of("JSP", "Servlet", "Spring");
    pageContext.setAttribute("stringList", stringList);

%>

<main>
    <h1>EL OPERATOR</h1>

    <div>
        <fieldset>
            <legend>값 확인</legend>
            <p>J: <b>${J}</b> | S: <b>${S}</b> | P: <b>${P}</b></p>
        </fieldset>
    </div>
    <div class="operator__list">
        <fieldset>
            <legend>산술 연산자</legend>
            <p><code>&#36;{J + S}</code>: <b>${J + S}</b><p/>
            <p><code>&#36;{J - S}</code>: <b>${J - S}</b><p/>
            <p><code>&#36;{J * S}</code>: <b>${J * S}</b><p/>
            <p><code>&#36;{J / S}</code>: <b>${J / S}</b><p/>
            <p><code>&#36;{J % S}</code>: <b>${J % S}</b><p/>
            <p><code>&#36;{J / S}</code>: <b>${J div S}</b><p/>
            <p><code>&#36;{J % S}</code>: <b>${J mod S}</b><p/>
        </fieldset>

        <fieldset>
            <legend>비교 연산자</legend>
            <p><code>&#36;{J < S}</code>: <b>${J lt S}</b><p/>
            <p><code>&#36;{J > S}</code>: <b>${J gt S}</b><p/>
            <p><code>&#36;{S <= P}</code>: <b>${S le P}</b><p/>
            <p><code>&#36;{S >= P}</code>: <b>${S ge P}</b><p/>
            <p><code>&#36;{(10*10) == 100}</code>: <b>${(10*10) eq 100}</b><p/>
            <p><code>&#36;{(10*10) != 100}</code>: <b>${(10*10) ne 100}</b><p/>
            <br/>
            <p><code>&#36;{J < S}</code>: <b>${J < S}</b><p/>
            <p><code>&#36;{J > S}</code>: <b>${J > S}</b><p/>
            <p><code>&#36;{S <= P}</code>: <b>${S <= P}</b><p/>
            <p><code>&#36;{S >= P}</code>: <b>${S >= P}</b><p/>
            <p><code>&#36;{(10*10) == 100}</code>: <b>${(10*10) == 100}</b><p/>
            <p><code>&#36;{(10*10) != 100}</code>: <b>${(10*10) != 100}</b><p/>
        </fieldset>

        <fieldset>
            <legend>논리 및 조건 연산자</legend>
            <p><code>&#36;{J > P && P < S}</code>: <b>${J > P and P < S}</b><p/>
            <p><code>&#36;{J > P || P < S}</code>: <b>${J > P or P < S}</b><p/>
            <p><code>&#36;{!(J == P)}</code>: <b>${not(J == P)}</b><p/>
            <br/>
            <p><code>&#36;{J > P && P < S}</code>: <b>${J > P && P < S}</b><p/>
            <p><code>&#36;{J > P || P < S}</code>: <b>${J > P || P < S}</b><p/>
            <p><code>&#36;{!(J == P)}</code>: <b>${!(J == P)}</b><p/>
            <br/>
            <p><code>&#36;{(J == S)? "T" : "F"}</code>: <b>${(J == S) ? "T" : "F"}</b><p/>
        </fieldset>

        <fieldset>
            <legend>empty</legend>
            <ul>
                <li><a href="operator.jsp?name=JSP">operator.jsp?name=JSP</a></li>
                <li><a href="operator.jsp">operator.jsp</a></li>
            </ul>
            <br/>

            <%-- param.name이 null일 경우 true, null이 아닐 경우는 false --%>
            <p><code>&#36;{empty param.name}</code>: <b>${empty param.name}</b><p/>
            <p><code>&#36;{param.name}</code>: <b>${param.name}</b><p/>
        </fieldset>

        <fieldset>
            <legend>array</legend>
            <p>${pageScope.stringList[0]}<p/>
            <p>${pageScope.stringList[1]}<p/>
            <p>${pageScope.stringList[2]}<p/>
            <p>${pageScope.stringList.size()}<p/>
        </fieldset>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
