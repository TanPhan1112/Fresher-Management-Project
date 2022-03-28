<%-- 
    Document   : student_statistics
    Created on : Sep 25, 2016, 11:50:29 AM
    Author     : TAN
--%>

<jsp:include page="../home.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Student statistics</title>
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
                height: 170px;
                overflow: auto;
                width:800px;
            }
        </style>
    </head>
    <body>
        <div class="container addStudent">
            <div class="col-sm-offset-3">
                <h3>Statistics students</h3>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Student ID</th>
                            <th>Name</th>
                            <th>Course</th>
                            <th>Subjects studied</th>
                            <th>Theory score</th>
                            <th>Practical score</th>
                            <th>Average score</th>
                            <th>Result</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${requestScope.listsv}">
                            <tr>
                                <td><c:out value="${row[0]}"/></td>   
                                <td><c:out value="${row[1]}"/></td>
                                <td><c:out value="${row[2]}"/></td>
                                <td><c:out value="${row[3]}"/></td>
                                <td><c:out value="${row[4]}"/></td>
                                <td><c:out value="${row[5]}"/></td>
                                <td><c:out value="${(row[4] + row[5])/2}"/></td>
                                <td>
                                    <c:if test="${((row[4] + row[5])/2)>=5}"><span style="color: green"><c:out value="PASSED"/></span></c:if>
                                    <c:if test="${((row[4] + row[5])/2)<5}"><span style="color: red"><c:out value="FAILED"/></span></c:if>
                                    </td>
                                </tr>              
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="col-sm-offset-3" method="POST" action='Statistics_Student_Servlet'>
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-3 control-label"></label>
                        <span style="color: green">${staMess}</span>
                        <span style="color: red">${staError}</span>
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
</html>
