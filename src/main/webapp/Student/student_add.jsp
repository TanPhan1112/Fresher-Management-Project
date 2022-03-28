<%-- 
    Document   : add_student
    Created on : Sep 25, 2016, 10:11:53 AM
    Author     : TAN
--%>

<jsp:include page="../home.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <title>Add student</title>
    </head>
    <body>
        <div class="container addStudent">          
            <form class="form-horizontal" action="Add_Student_Servlet" method="POST">
                <h3 class="addSt">add students</h3>
                <div class="form-group">
                    <label class="col-sm-5 control-label"></label>
                    <span style="color: green">${addMess}</span>
                    <span style="color: red">${addError}</span>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-5 control-label">Name: (*)</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="name" id="name" placeholder="name" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthday" class="col-sm-5 control-label">Birthday: (*)</label>
                    <div class="col-sm-5">
                        <input type="date" min="1900-12-31" max="9999-12-31" class="form-control" name="birthday" id="birthday" placeholder="birthday" required="">
                    </div>
                </div>  
                <div class="form-group">
                    <label for="gender" class="col-sm-5 control-label">Gender: (*)</label>
                    <div class="col-sm-5">
                        <input type="radio" name="gender" value="Male" checked="true"> Male &nbsp;
                        <input type="radio" name="gender" value="Female"> Female
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-5 control-label">Address:</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="address" id="address" placeholder="address">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-5 control-label">Phone number:</label>
                    <div class="col-sm-5">
                        <input type="tel" class="form-control" name="phone" id="phone" placeholder="phone" pattern="[0]\d{9,10}" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="emailAddress" class="col-sm-5 control-label">Email address: (*)</label>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" name="email" id="email" placeholder="email" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="col-sm-5 control-label"></label>
                    <div class="col-sm-5">
                        <input type="submit" class="btn btn-default" value="Add">
                        <button type="reset" class="btn btn-default col-sm-offset-1">Clear</button>
                    </div>
                </div>
            </form> 
        </div>
    </body>
</html>
