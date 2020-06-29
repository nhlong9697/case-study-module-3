<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Program List</title>
</head>
<body>
    <a href="/admin/program?action=addProgram">Add program</a>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Program Name</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope.programs}' var="program">
            <tr>
                <td>${program.getProgramId()}</td>
                <td><a href="/admin/program/${program.getProgramId()}">${program.getProgramName()}</a></td>
                <td><a href="/admin/program?action=editProgram&id=${program.getProgramId()}">Edit
                </a></td>
                <td><a
                        href="/admin/program?action=deleteProgram&id=${program.getProgramId()}">Delete
                </a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
