<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- Formatting 태그를 사용하기 위해서는 반드시 필요한 자원 URL과 prefix를 tablib에 선언 --%>

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
    <h1>FORMAT TAGS</h1>

    <%-- ko 국가코드, kr 언어코드 (국제 표준화 기구 (iso에서 정함)) --%>
<%--    <fmt:setLocale value="ko_kr"/>--%>
    <fmt:setLocale value="en_us"/>
    <fmt:requestEncoding value="UTF-8"/>

    <%-- core 태그 set으로 변수 num 선언  --%>
    <c:set var="num" value="123456789"/>
    <div><c:out value="${num}"></c:out></div>

    <%-- number 타입으로 num 값 출력 --%>
    <div>숫자 : <fmt:formatNumber value="${num}" type="number"/></div>

    <%-- percent 타입으로 num 값 출력
    세자리 단위로 ',' (콤마)의 사용여부를
    groupingUsed 속성에 true/false 설정 (기본값 true)  --%>
    <div>퍼센트 : <fmt:formatNumber value="${num}" type="percent" groupingUsed="true"/></div>

    <%-- currency (통화) 타입으로 num 값 출력
    통화의 심볼은 $로 설정 --%>
    <div>달러 : <fmt:formatNumber value="${num}" type="currency" currencySymbol="$"/></div>

    <%-- 정수 자리와 실수 4자리로 지정한 패턴 (pattern)으로 num값 출력 --%>
    <div>패턴 : <fmt:formatNumber value="${num}" pattern="0.0000" groupingUsed="false"/></div>
    <div>패턴 : <fmt:formatNumber value="${num}" pattern="#.####" groupingUsed="false"/></div>

    <%-- 실수값을 정수부분만 파싱하여 변수로 선언  --%>
    <fmt:parseNumber var="i" integerOnly="true" value="123.456"/>
    <div>실수를 제외한 정수 : <c:out value="${i}"/></div>

    <%--
        숫자->문자열: format 태그를 사용하여 변수 num을 숫자, 통화, 퍼센트, 패턴 등 원하는 형식의 문자열로 출력
        문자열->숫자: parseNumber 태그를 이용하여 123.456의 값을 원하는 문자열 형태로 출력
     --%>

    <ul class="main__nav__next">
        <li>👉🏻<a href="formatTagsProperty.jsp"><b>formatTagsDate.jsp 예제로 이동</b></a></li>
    </ul>
</main>

<footer class="main__nav__next">
    <jsp:include page="../footer.jsp"/>
</footer>
</body>
</html>
