<%-- 
    Document   : course_delete
    Created on : Oct 17, 2016, 1:10:34 PM
    Author     : TAN
--%>

<jsp:include page="../home.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Delete course</title>
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
                <h3>delete courses</h3>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Course ID</th>
                            <th>Course name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${requestScope.listcourse}">
                            <tr>
                                <td><c:out value="${row.makh}"/></td>
                                <td><c:out value="${row.tenkh}"/></td>
                                <td>
                                    <button class="btn btn-danger" data-href="?makh=<c:out value="${row.makh}"/>" data-toggle="modal" data-target="#confirm-delete">
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
            <form class="col-sm-offset-3" method="POST" action="Show_Course_Delete">
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <span style="color: green">${delcMess}</span>
                        <span style="color: red">${delcError}</span>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group row">
                        <label for="courseId" class="col-sm-2 control-label">Course ID: (*)</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="courseId" placeholder="Course ID" required="">
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
