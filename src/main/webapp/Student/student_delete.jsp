<%-- 
    Document   : delete_student
    Created on : Sep 25, 2016, 11:28:10 AM
    Author     : TAN
--%>

<jsp:include page="../home.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Delete student</title>
        <style>
            .addStudent{
                margin-top: 100px;
                padding-top: 320px;
                background-image: url("image/pencil.jpg");
                background-repeat: no-repeat; 
                height: 914px;
            }
        </style>
    </head>
    <body>
        <div class="container addStudent">
            <div class="col-sm-offset-3">
                <h3>delete students</h3>
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
                                <td>
                                    <button class="btn btn-danger" data-href="Delete_Student_Servlet?mahv=<c:out value="${row.mahv}"/>" data-toggle="modal" data-target="#confirm-delete">
                                        Delete
                                    </button>
                                    <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <strong>Delete Confirmation</strong>
                                                </div>
                                                <div class="modal-body">
                                                    <center>Are you sure?</center>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                                    <a class="btn btn-danger btn-ok">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>  
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="col-sm-offset-3" method="POST" action="Show_Student_Delete">
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <span style="color: green">${delMess}</span>
                        <span style="color: red">${delError}</span>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group row">
                        <label for="stId" class="col-sm-2 control-label">Student ID: (*)</label>
                        <div class="col-sm-3">
                            <input type="number" class="form-control" name="stId" placeholder="Student ID" required="">
                        </div>
                        <button type="submit" class="btn btn-default">Show</button>
                    </div>
                </div>
            </form>
        </div>
    </body> 
    <script>
        $('#confirm-delete').on('show.bs.modal', function (e) {
            $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
        });
    </script>
</html>
