<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete program</title>
</head>
<body>
<h1>Delete program</h1>

<p>
    <a href="/admin/program">Back to program list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Program id: </td>
                <td>${requestScope.program.getProgramId()}</td>
            </tr>
            <tr>
                <td>Program name: </td>
                <td>${requestScope.product.getProgramName()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete program"></td>
                <td><a href="/admin/program">Back to program list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
