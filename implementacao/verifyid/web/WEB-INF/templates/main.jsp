<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css">
        <title>VERIFY-ID</title>
    </head>
    <body>
        <div id="main">
            <div id="header">
                VERIFY-ID!
            </div>

            <%= request.getAttribute("Controller") %>

            <div id="footer">
                Estácio de Sá - 2017
            </div>
        </div>
    </body>
</html>
