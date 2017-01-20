<%-- 
    Document   : customer
    Created on : Jan 19, 2017, 11:45:53 PM
    Author     : rafaelpevidor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.:VERIFY-ID:.</title>
    </head>
    <body>
        <h1>Cadastro de Clientes <small>Listagem</small></h1>
        <table>
            <thead>
                <th>#</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Ações</th>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.records}" var="item">
                <td>${item.id}</td>
                <td>${item.nome}</td>
                <td>${item.telefone}</td>
                <td>
                    
                </td>
            </c:forEach>
            </tbody>
            <tfoot>Total de clientes: ${requestScope.totalClientes}</tfoot>
        </table>
    </body>
</html>
