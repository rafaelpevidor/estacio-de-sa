<%-- 
    Document   : newjsp
    Created on : Jan 18, 2017, 2:33:01 PM
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
        <form method="post" action="<%=request.getContextPath()%>/login" style="margin-left: 40%; margin-top: 10%;">
            <div id="divmsg">
                <span>${requestScope.msg}</span>
            </div>
            <div id="divlogin">
                <h1>Login</h1>
                <fieldset style="width: 200px;">
                    <legend>Usuário</legend>
                    <input type="text" id="txtlogin" name="login"maxlength="200"/><br/>
                </fieldset>
                <fieldset style="width: 200px;">
                    <legend>Senha</legend>
                    <input type="password" id="txtsenha" name="password" maxlength="8"/><br/>
                </fieldset><br/>
                <input type="submit" id="btnlogin" value="Entrar" style="width: 263px; height: 30px;"/>
            </div>
        </form>
    </body>
</html>
