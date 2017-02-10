<%-- 
    Document   : index
    Created on : Jan 19, 2017, 2:01:29 PM
    Author     : rafaelpevidor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.:VERIFY-ID:.</title>
    </head>
    <body>
        <% 
            System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath()+"/login"); 
        %>
    </body>
</html>
