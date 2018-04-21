<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Promoção</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Cadastro de Nova Promoção</h1>
        <hr>
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
                <c:forEach items="${requestScope.mensagens}" var="mensagem">
                    <li>${mensagem}</li>
                    </c:forEach>
            </ul>
            <hr>
        </c:if>
        <form action="NovaPromocaoServlet" method="post">
            Digite seus dados:<br/>
            URL do Site: <input name="url" type="text" value="${sessionScope.novaPromocao.url}" /><br/>
            CNPJ do Hotel: <input name="cnpj" type="text" disabled="disabled" value="${sessionScope.cnpj_hotel}" /><br/>
            Preço: <input name="preco" type="number" value="${sessionScope.novaPromocao.preco}" /><br/>
            Data inicial: <input name="data_inicial" type="text" value="${sessionScope.novaPromocao.data_inicial}" /><br/>
            Data final: <input name="data_final" type="text" value="${sessionScope.novaPromocao.data_final}" /><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>