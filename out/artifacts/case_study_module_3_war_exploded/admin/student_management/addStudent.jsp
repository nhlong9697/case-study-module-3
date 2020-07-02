<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create program</h1>
<c:if test="${requestScope.message != null}">
    <p>${requestScope.message}</p>
</c:if>
<a href="/admin/program/${requestScope.programId}/class/${requestScope.classId}">Back to class
    management</a>
<form method="post">
    <table>
        <tr>
            <td>User name</td>
            <td><input type="text" name="username" placeholder="Enter program name"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" placeholder="Enter password"></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" placeholder="Enter first name"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" placeholder="Enter first name"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" placeholder="Enter email"></td>
        </tr>
        <tr>
            <td>Class</td>
            <td><input type="text" name="classId" placeholder="Enter class"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create program"></td>
        </tr>
    </table>
</form>
</body>
</html>
