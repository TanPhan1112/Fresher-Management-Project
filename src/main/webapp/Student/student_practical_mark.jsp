<%-- 
    Document   : student_practical_mark
    Created on : Sep 25, 2016, 12:49:08 PM
    Author     : TAN
--%>

<jsp:include page="../home.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Students practical mark</title>
    </head>
    <body>
        <div class="container addStudent">          
            <form class="form-horizontal" action="Mark_Student_Servlet" method="POST">
                <h3 class="addSt">Students practical mark</h3>
                <div class="form-group">
                    <label class="col-sm-5 control-label"></label>
                    <span style="color: green">${markMess}</span>
                    <span style="color: red">${markError}</span>
                </div>
                <div class="form-group">
                    <label for="stId" class="col-sm-5 control-label">Student ID: (*)</label>
                    <div class="col-sm-5">
                        <input type="number" class="form-control" name="stId" placeholder="Student ID" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="courseId" class="col-sm-5 control-label">Course ID: (*)</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="courseId" placeholder="Course ID" required="">
                    </div>
                </div>                              
                <div class="form-group">
                    <label for="subjectId" class="col-sm-5 control-label">Subject ID: (*)</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="subjectId" placeholder="Subject ID" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="theory" class="col-sm-5 control-label">Theory mark: (*)</label>
                    <div class="col-sm-5">
                        <input type="number" min="0" max="10" step="0.01" class="form-control" name="theory" placeholder="Theory mark" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="practical" class="col-sm-5 control-label">Practical mark: (*)</label>
                    <div class="col-sm-5">
                        <input type="number" min="0" max="10" step="0.01" class="form-control" name="practical" placeholder="Practical mark" required="" pattern="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="col-sm-5 control-label"></label>
                    <div class="col-sm-5">
                        <input type="submit" class="btn btn-default" value="Save">
                        <button type="reset" class="btn btn-default col-sm-offset-1">Clear</button>
                    </div>
                </div>
            </form> 
        </div>
    </body>  
</html>
