<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit program</title>
</head>
<body>
<p>
    <a href="/admin/program">Back to program list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Program information</legend>
        <table>
            <tr>
                <td>Program Name: </td>
                <td><input type="text" name="programName" id="programName"
                           value="${requestScope.program.getProgramName()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update program"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
