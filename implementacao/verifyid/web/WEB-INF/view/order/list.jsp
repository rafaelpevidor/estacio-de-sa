<%-- 
    Document   : list
    Created on : Feb 10, 2017, 10:24:54 PM
    Author     : rafaelpevidor
--%>

        <div id="indexLeftColumn">
            <span>MENU</span>
            <ul>
                <li><a href="<%=request.getContextPath()%>/home">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/customer">Cliente</a></li>
                <li><a href="<%=request.getContextPath()%>/order">Pedido</a></li>
                <li>Ordem</li>
            </ul>
        </div>
        <div id="indexRightColumn">
            <h1>Cadastro de Pedidos <small>Listagem</small></h1>
            <div id="divmsg">
                <span>${requestScope.msg}</span>
            </div>
            <table border=1>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Quantidade</th>
                        <th>Status</th>
                        <th colspan=2>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td><c:out value="${order.id}" /></td>
                            <td><c:out value="${order.cliente}" /></td>
                            <td><c:out value="${order.quantidade}" /></td>
                            <td><c:out value="${order.status}" /></td>
                            <td><a href="OrderController?action=edit&orderId=<c:out value="${order.id}"/>">Update</a></td>
                            <td><a href="OrderController?action=delete&orderId=<c:out value="${order.id}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
