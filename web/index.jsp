<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>
  <a href="/register">Register</a>
  <a href="/logout">Log out</a>
  <a href="/profile">Profile</a>
  <form action="/home" method="post">
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
        <td><input type="submit" value="Log in"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
