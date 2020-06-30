<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete class</title>
</head>
<body>
<h1>Delete class</h1>
<p>
    <a href="/admin/program/${requestScope.programId}">Back to program list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Class information</legend>
        <table>
            <tr>
                <td>Class id: </td>
                <td>${requestScope.programClass.getClassId()}</td>
            </tr>
            <tr>
                <td>Class name: </td>
                <td>${requestScope.programClass.getClassName()}</td>
            </tr>
            <tr>
                <td>Class program: </td>
                <td>${requestScope.programClass.getProgramId()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete program"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
