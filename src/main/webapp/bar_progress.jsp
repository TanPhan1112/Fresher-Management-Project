<%-- 
    Document   : bar_progress
    Created on : Oct 7, 2016, 6:53:19 PM
    Author     : TAN
--%>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="index.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logging</title>
    </head>
    <body>
        <!-- Modal Start here-->
        <div class="modal fade bs-example-modal-sm" id="myPleaseWait" tabindex="-1"
             role="dialog" aria-hidden="true" data-backdrop="static">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">
                            <span class="glyphicon glyphicon-time">
                            </span>Login Successfully...
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class="progress">
                            <div class="progress-bar progress-bar-info
                                 progress-bar-striped active"
                                 style="width: 100%">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal ends Here -->
        <div id="counter" style="display: none">3</div>
        <script>
            setInterval(function () {
                var div = document.querySelector("#counter");
                var count = div.textContent * 1 - 1;
                div.textContent = count;
                if (count <= 0) {
                    location.href = "HomeServlet";
                } else {
                    $('#myPleaseWait').modal('show');
                }
            }, 1000);
        </script>
    </body>
</html>
