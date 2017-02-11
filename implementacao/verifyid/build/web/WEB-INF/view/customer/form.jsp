<%-- 
    Document   : form
    Created on : Feb 10, 2017, 10:30:59 PM
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
            <form method="POST" action="<%=request.getContextPath()%>/customer/add" name="frmAddCustomer">
                ID : <input type="text" readonly="readonly" name="id"
                    value="<c:out value="${entity.id}" />" /> <br /> 
                Nome : <input type="text" name="nome"
                    value="<c:out value="${entity.nome}" />" /> <br /> 
                Razão Social : <input type="text" name="razaoSocial"
                    value="<c:out value="${entity.razaoSocial}" />" /> <br /> 
                CNPJ : <input type="text" name="cnpj"
                    value="<c:out value="${entity.cnpj}" />" /> <br /> 
                Endereço : <input type="text" name="endereco"
                    value="<c:out value="${entity.endereco}" />" /> <br />
                Telefone : <input type="text" name="telefone"
                    value="<c:out value="${entity.telefone}" />" /> <br />
                <input
                    type="submit" value="Salvar" />
            </form>
        </div>
        
