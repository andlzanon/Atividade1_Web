<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotéis</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Hotéis Cadastrados</h1>
        <hr>
        <c:if test="${empty requestScope.listaHoteis}">
            <p>${requestScope.erro}</p>
        </c:if>
        <c:if test="${!empty requestScope.listaHoteis}">
            <table>
                <tr>
                    <th class="esquerda">Nome</th>
                    <th>CNPJ</th>
                    <th>Cidade</th>
                </tr>
                <c:forEach items="${requestScope.listaHoteis}" var="hotel">
                    <tr>
                        <td class="esquerda">${hotel.nome}</td>
                        <td>${hotel.cnpj}</td>
                        <td>${hotel.cidade}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>