<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Program List</title>
    <style>
        table {
            border-collapse: collapse;
        }
    </style>
</head>
<body>

<a href="/admin/program">Back to program management</a>
<a href="/admin/program/${requestScope.programId}/class?action=addClass">Add class</a>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Class Name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope.classList}' var="classProgram">
        <tr>
            <td>${classProgram.getClassId()}</td>
            <td><a
                    href="/admin/program/${requestScope.programId}/class/${classProgram.getClassId()}">${classProgram.getClassName()}</a></td>
            <td><a
                    href="/admin/program/${requestScope.programId}/class?action=editClass&id=${classProgram.getClassId()}">Edit
            </a></td>
            <td><a
                    href="/admin/program/${requestScope.programId}/class?action=deleteClass&id=${classProgram.getClassId()}">Delete
            </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
