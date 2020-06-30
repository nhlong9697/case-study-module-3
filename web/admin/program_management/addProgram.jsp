<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create program</title>
</head>
<body>
    <h1>Create program</h1>
    <c:if test="${requestScope.message != null}">
        <p>${requestScope.message}</p>
    </c:if>
    <a href="/admin/program">Back to class management</a>
    <form method="post">
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
