<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 404</title>
</head>
<body>
<c:if test="${requestScope.message != null}">
   <p>${requestScope.message}</p>
</c:if>
</body>
</html>
