<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create program</title>
</head>
<body>
    <h1>Create program</h1>
    <a href="/admin/class">Back to class management</a>
    <form action="/admin/class?action=addProgram" method="post">
        <table>
           <tr>
               <td>Program name</td>
               <td><input type="text" name="programName" placeholder="Enter program name"></td>
           </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create program"></td>
            </tr>
        </table>
    </form>
</body>
</html>
