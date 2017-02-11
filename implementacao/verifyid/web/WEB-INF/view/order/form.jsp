<%-- 
    Document   : form
    Created on : Feb 10, 2017, 10:27:17 PM
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
            <h1>Cadastro de Pedidos</h1>
            <div id="divmsg">
                    <span>${requestScope.msg}</span>
                </div>
            <form method="POST" action="<%=request.getContextPath()%>/order/add" name="frmAddOrder">
                Order ID : <input type="text" readonly="readonly" name="id"
                    value="<c:out value="${entity.id}" />" /> <br /> 
                Cliente : <input type="text" name="cliente"
                    value="<c:out value="${entity.cliente}" />" /> <br /> 
                Quantidade : <input type="text" name="quantidade"
                    value="<c:out value="${entity.quantidade}" />" /> <br /> 
                Status : <input type="text" name="status"
                    value="<c:out value="${entity.status}" />" /> <br /> <input
                    type="submit" value="Submit" />
            </form>
        </div>