<%-- 
    Document   : index
    Created on : Sep 25, 2016, 10:36:44 AM
    Author     : TAN
--%>

<jsp:include page="header.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <body>        
        <div class="container">           
            <div class="row">
                <h1 class="col-sm-offset-2">Fresher Management</h1>
                <h4 class="col-sm-offset-3 signin">Please sign in!</h4>
                <form class="form-horizontal" method="POST" action="LoginServlet">
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">Username:</label>
                        <div class="col-sm-5">                           
                            <input type="text" class="form-control" name="username" id="username" required="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">Password:</label>
                        <div class="col-sm-5">
                            <input type="password" class="form-control" name="password" id="password" required="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-sm-5">
                            <input type="submit" class="btn btn-default">
                        </div>                       
                    </div>                                    
                </form>
                <div class="form-group">
                    <label class="col-sm-2 control-label"></label>
                    <span style="color: red">${errorMess}</span>
                </div>
            </div>           
        </div>  
    </body>
    <%--<sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/FresherManagement?zeroDateTimeBehavior=convertToNull"
                       user="root" password="1112"/>
    <c:if test="${pageContext.request.method=='POST'}">
        <c:catch var="exception">
            <sql:query dataSource="${conn}" var="acc">
                select * from account where username = ? and password = ?
                <sql:param value="${param.username}"/>
                <sql:param value="${param.pwd}"/>
            </sql:query>
            <c:if test="${acc.rowCount == 0}">
                <div class="container">
                    <div class="form-group">
                        <div class="col-sm-offset-2">                           
                            <p style="color: red"><c:out value="Invalid username or password!"/></p>
                        </div>
                    </div>
                </div>         
            </c:if>
        <c:forEach var="row" items="">
            <c:if test="">            
            </c:if>             
        </c:forEach>
    </c:catch>
    <c:if test="${exception!=null}">
        <c:out value="Login failed"/>
    </c:if>
</c:if>--%>
</html>