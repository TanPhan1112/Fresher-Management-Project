<%-- 
    Document   : test
    Created on : Oct 14, 2016, 12:19:44 PM
    Author     : TAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="row" items="${requestScope.listsv}">
                    <tr>
                        <td><c:out value="${row.mahv}"/></td>
                        <td><c:out value="${row.ten}"/></td>
                        <td><c:out value="${row.ngaysinh}"/></td>
                        <td><c:out value="${row.diachi}"/></td>
                        <td><c:out value="${row.dt}"/></td>
                        <td><c:out value="${row.email}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
