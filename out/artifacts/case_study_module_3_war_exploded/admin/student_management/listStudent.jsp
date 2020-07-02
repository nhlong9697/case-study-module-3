<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/admin/program?action=addProgram">Add program</a>
<table border="1">
    <tr>
        <td>Username</td>
        <td>Password</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>Class Id</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope.studentList}' var="student">
        <tr>
            <td>${student.getStudentId()}</td>
            <td><a
                    href="/admin/program/${requestScope.programId}/class/${requestScope.classId}">${student.getFirstName()}</a></td>
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
