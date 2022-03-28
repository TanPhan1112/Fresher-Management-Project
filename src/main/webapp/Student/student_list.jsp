<%-- 
    Document   : student_list
    Created on : Sep 25, 2016, 12:04:01 PM
    Author     : TAN
--%>

<jsp:include page="../home.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Student list</title>
        <style>
            .addStudent{
                margin-top: 100px;
                padding-top: 320px;
                background-image: url("image/pencil.jpg");
                background-repeat: no-repeat; 
                height: 914px;
            }
            td {
                width: 95px;               
            }
            th {
                width: 95px;               
            }
            thead > tr, tbody{
                display:block;}
            tbody { 
                align-content: center;
                height: 250px;
                overflow: auto;
                width:800px;
            }
        </style>
    </head>
    <body>
        <div class="container addStudent">
            <div class="col-sm-offset-3">
                <h3>List students</h3>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>Name</th>
                            <th>Birthday</th>
                            <th>Gender</th>
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
                                <td><c:out value="${row.gioitinh}"/></td>
                                <td><c:out value="${row.diachi}"/></td>
                                <td><c:out value="${row.dt}"/></td>
                                <td><c:out value="${row.email}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body> 
</html>
