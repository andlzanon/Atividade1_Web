<%-- 
    Document   : listaPromocaoHotel
    Created on : 19/04/2018, 11:06:58
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promoçoes Hotel</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Promoções Cadastradas</h1>
        <hr>
    <c:if test="${empty requestScope.listaPromocaoHotel}">
        Nao há promocoes
    </c:if>
    <c:if test="${!empty requestScope.listaPromocaoHotel}">
        <table>
            <tr>
                <th class="esquerda">Site</th>
                <th>Telefone</th>
                <th>Preco</th>
                <th>Data Inicial</th>
                <th>Data Final</th>
            </tr>
            <c:forEach items="${requestScope.listaPromocaoHotel}" var="promocao">
                <tr>
                    <td class="esquerda">${promocao.url.nome}</td>
                    <td>${promocao.url.telefone}</td>
                    <td>${promocao.preco}</td>
                    <td>${promocao.data_inicial}</td>
                    <td>${promocao.data_final}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>

