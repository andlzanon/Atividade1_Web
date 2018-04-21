<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Hotel</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Cadastro de Hotel</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
                <c:forEach items="${requestScope.mensagens}" var="mensagem">
                    <li>${mensagem}</li>
                    </c:forEach>
            </ul>
            <hr>
        </c:if>
        <form action="NovoHotelServlet" method="post">
            Digite seus dados:<br/>
            CNPJ: <input name="cnpj" type="text" value="${sessionScope.novoHotel.cnpj}" /><br/>
            Nome: <input name="nome" type="text" value="${sessionScope.novoHotel.nome}" /><br/>
            Cidade: <input name="cidade" type="text" value="${sessionScope.novoHotel.cidade}" /><br/>
            Senha: <input name="senha" type="text" value="${sessionScope.novoHotel.senha}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>