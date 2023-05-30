<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>damn!!!!</title>
	<!-- <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css"> -->
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>nome</th>
                    <th>taxa diaria</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${veics}" var="veic">
                    <tr>
                        <td>${veic.id}</td>
                        <td>${veic.nome}</td>
                        <td>${veic.taxa_diaria}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
