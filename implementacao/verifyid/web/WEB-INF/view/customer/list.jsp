<%-- 
    Document   : customer
    Created on : Jan 19, 2017, 11:45:53 PM
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
            <h1>Cadastro de Clientes <small>Listagem</small></h1>
            <div id="divmsg">
                <span>${requestScope.msg}</span>
            </div>
            <a href="<%=request.getContextPath()%>/customer/new">Novo</a>
            <table>
                <thead>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Razão Social</th>
                    <th>Telefone</th>
                    <th>Ações</th>
                </thead>
                <tbody>
                <c:forEach items="${records}" var="item">
                    <td>${item.id}</td>
                    <td>${item.nome}</td>
                    <td>${item.razaoSocial}</td>
                    <td>${item.telefone}</td>
                    <td>
                        <td><a href="<%=request.getContextPath()%>/customer/edit?id=<c:out value="${item.id}"/>">Editar</a></td>
                        <td><a href="<%=request.getContextPath()%>/customer/remove?id=<c:out value="${item.id}"/>">Excluir</a></td>
                    </td>
                </c:forEach>
                </tbody>
            </table>
        </div>
        
