<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
    <h1>Admin login</h1>
    <form action="/admin" method="post">
        <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" placeholder="Enter username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" placeholder="Enter password"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" id="submit" value="Log in"></td>
            </tr>
        </table>
    </form>
</body>
</html>
