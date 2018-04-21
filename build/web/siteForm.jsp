<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Site</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Cadastro de Site de Reservas</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
                <c:forEach items="${requestScope.mensagens}" var="mensagem">
                    <li>${mensagem}</li>
                    </c:forEach>
            </ul>
            <hr>
        </c:if>
        <form action="NovoSiteServlet" method="post">
            Digite seus dados:<br/>
            URL: <input name="url" type="text" value="${sessionScope.novoSite.url}" /><br/>
            Nome: <input name="nome" type="text" value="${sessionScope.novoSite.nome}" /><br/>
            Telefone: <input name="telefone" type="text" value="${sessionScope.novoSite.telefone}" /><br/>
            Senha: <input name="senha" type="text" value="${sessionScope.novoSite.senha}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>