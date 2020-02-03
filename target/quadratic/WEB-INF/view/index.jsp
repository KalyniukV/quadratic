<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Quadratic</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
    <c:if test="${alert != null}">
       <script>window.onload = function(){alert('${alert}');};</script>
    </c:if>
<h2>ax&sup2; + bx + c = 0</h2>
<div>
    <form name="calculation" method="post">
        <input input type="number" required="required" step="0.01" name="valA" placeholder="a (не дорінює нулю)" />
        <input input type="number" required="required" step="0.01" name="valB" placeholder="b" />
        <input input type="number" required="required" step="0.01" name="valC" placeholder="c" />
        <button type="submit">Розрахувати</button>
    </form>
</div>

<table id="result">
    <tr>
        <th>№</th>
        <th>a</th>
        <th>b</th>
        <th>c</th>
        <th>результат</th>
    </tr>
    <c:forEach items="${equations}" var="equation">
        <tr>
            <td>${equation.id}</td>
            <td>${equation.valA}</td>
            <td>${equation.valB}</td>
            <td>${equation.valC}</td>
            <td>
                <c:choose>
                    <c:when test="${equation.resX2 != null}">x1 = ${equation.resX1}, x2 = ${equation.resX2}</c:when>
                    <c:otherwise>x = ${equation.resX1}</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>