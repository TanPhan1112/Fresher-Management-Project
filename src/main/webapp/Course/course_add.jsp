<%-- 
    Document   : Course_add
    Created on : Oct 17, 2016, 12:09:44 PM
    Author     : TAN
--%>

<jsp:include page="../home.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <title>Add course</title>
    </head>
    <body>
        <div class="container addStudent">          
            <form class="form-horizontal" action="" method="POST">
                <h3 class="addSt">add courses</h3>
                <div class="form-group">
                    <label class="col-sm-5 control-label"></label>
                    <span style="color: green">${addcMess}</span>
                    <span style="color: red">${errorcMess}</span>
                </div>
                <div class="form-group">
                    <label for="courseId" class="col-sm-5 control-label">Course ID: (*)</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="courseId" placeholder="Course Id" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="courseName" class="col-sm-5 control-label">Course's name: (*)</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="courseName" placeholder="Course name" required="">
                    </div>
                </div>                              
                <div class="form-group">
                    <label for="" class="col-sm-5 control-label"></label>
                    <div class="col-sm-5">
                        <input type="submit" class="btn btn-default" value="Add">
                    </div>
                </div>
            </form> 
        </div>
    </body>
</html>
