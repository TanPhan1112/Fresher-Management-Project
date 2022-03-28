<%-- 
    Document   : student_update
    Created on : Sep 25, 2016, 11:56:15 AM
    Author     : TAN
--%>

<jsp:include page="../home.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Update students</title>
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
                <h3>Update students</h3>
                <form method="POST" action="Update_Student_Servlet">
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
                                    <td><input type="button" class="btn btn-default" value="<c:out value="${row.mahv}"/>"><input type="hidden" class="form-control" name="mahv" required="" value="<c:out value="${row.mahv}"/>"></td>
                                    <td><input type="text" class="form-control" name="name" required="" value="<c:out value="${row.ten}"/>"></td>
                                    <td><input type="date" min="1900-12-31" max="9999-12-31" class="form-control" name="birthday" required="" value="<c:out value="${row.ngaysinh}"/>"></td>
                                    <td><div class="form-control" id="genderopt">
                                            <input type="hidden" class="form-control" id="gender" name="gender" value="<c:out value="${row.gioitinh}"/>">
                                            <select style="border: none" id="fm">
                                                <option value="Female">Female</option>
                                                <option value="Male">Male</option>
                                            </select>
                                        </div></td>
                                    <td><input type="text" class="form-control" name="address" required="" value="<c:out value="${row.diachi}"/>"></td>
                                    <td><input type="text" class="form-control" name="phone" required="" value="<c:out value="${row.dt}"/>"></td>
                                    <td><input type="email" class="form-control" name="email" required="" value="<c:out value="${row.email}"/>"></td>
                                    <td>
                                        <button type="submit" class="btn btn-warning" href="Update_Student_Servlet">
                                            Update
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
            <form class="col-sm-offset-3" method="POST" action="Show_Student_Update">
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <span style="color: green">${updMess}</span>
                        <span style="color: red">${updError}</span>
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
        var gender = 'Female';
        if (gender === $('#gender').val()) {
            $('#genderopt option[value=Female]').attr('selected', 'selected');
        } else {
            $('#genderopt option[value="Male"]').attr('selected', 'selected');
        }
        $('#fm').change(function () {
            var selGender = $('#fm').find(":selected").text();//not FILTER & VAL
            if (selGender === 'Male') {
                $('#gender').val('Male');
            } else {
                $('#gender').val('Female');
            }
        });
    </script>
</html>
