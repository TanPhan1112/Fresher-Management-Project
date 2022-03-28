<%-- 
    Document   : index
    Created on : Sep 23, 2016, 2:01:57 PM
    Author     : TAN
--%>

<jsp:include page="header.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Fresher Management</title>
    </head>
    <body class="body-img">
        <div class="menu">
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="HomeServlet"><span style="color: azure" class="glyphicon glyphicon-home" aria-hidden="true"></span></a>                       
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <!--Student management-->
                        <ul class="nav navbar-nav">                           
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Student Management<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="Add_Student_Servlet">Add student</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="Show_Student_Delete">Delete student</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="Statistics_Student_Servlet">Student statistics</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="Show_Student_Update">Update student</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="List_Student_Servlet">Student list</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="Search_Student_Servlet">Search students</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="Mark_Student_Servlet">Add practical marks</a></li>
                                </ul>
                            </li>
                        </ul>
                        <!--Course management-->
                        <ul class="nav navbar-nav">                           
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Course Management<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="Add_Course_Servlet">Add course</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="Show_Course_Delete">Delete course</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Course statistics</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Update course</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Course list</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Search courses</a></li>                                   
                                </ul>
                            </li>
                        </ul>
                        <!--Subject management-->
                        <ul class="nav navbar-nav">                           
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Subject Management<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Add subject</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Delete subject</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Update subject</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Subject list</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Search subjects</a></li>                                   
                                </ul>
                            </li>
                        </ul>
                        <!--Test management-->
                        <ul class="nav navbar-nav">                           
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Test Management<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Add test</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Delete test</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Update test</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Test list</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Search tests</a></li>                                   
                                </ul>
                            </li>
                        </ul>                       
                        <ul class="nav navbar-nav navbar-right">
                            <li><a style="color: greenyellow">
                                    <span style="color: white"><%= "Welcome "%></span>
                                    <%
                                        Object userName = request.getAttribute("username");
                                    %>
                                    <%= userName%> !</a></li>
                            <li><a href="LogoutServlet">Sign out</a></li>
                        </ul>                       
                        <!--                        <form class="navbar-form navbar-left">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" placeholder="Search">
                                                    </div>
                                                    <button type="submit" class="btn btn-default">Submit</button>
                                                </form>-->
                        <!--                        <ul class="nav navbar-nav navbar-right">
                                                    <li><a href="#">Link</a></li>
                                                    <li class="dropdown">
                                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                                        <ul class="dropdown-menu">
                                                            <li><a href="#">Action</a></li>
                                                            <li><a href="#">Another action</a></li>
                                                            <li><a href="#">Something else here</a></li>
                                                            <li role="separator" class="divider"></li>
                                                            <li><a href="#">Separated link</a></li>
                                                        </ul>
                                                    </li>
                                                </ul>-->
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
    </body>
</html>