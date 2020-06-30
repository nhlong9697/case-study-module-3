<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create class</title>
</head>
<body>
<h1>Create class</h1>
<c:if test='${requestScope.message != null}'>
    <p>${requestScope.message}</p>
</c:if>
<a href="/admin/program/${requestScope.programId}/class">Back to class management</a>
<form method="post">
    <table>
        <tr>
            <td>Class name</td>
            <td><input type="text" name="className" placeholder="Enter class name"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create class"></td>
        </tr>
    </table>
</form>
</body>
</html>
