<%-- 
    Document   : listaPromocaoSite
    Created on : 20/04/2018, 18:06:36
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promoçoes Site</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Promoções Cadastradas</h1>
        <hr>
    <c:if test="${empty requestScope.listaPromocaoSite}">
        Nao ha promocoes
    </c:if>
    <c:if test="${!empty requestScope.listaPromocaoSite}">
        <table>
            <tr>
                <th class="esquerda">Hotel</th>
                <th>Cidade</th>
                <th>Preco</th>
                <th>Data Inicial</th>
                <th>Data Final</th>
            </tr>
            <c:forEach items="${requestScope.listaPromocaoSite}" var="promocao">
                <tr>
                    <td class="esquerda">${promocao.cnpj.nome}</td>
                    <td>${promocao.cnpj.cidade}</td>
                    <td>${promocao.preco}</td>
                    <td>${promocao.data_inicial}</td>
                    <td>${promocao.data_final}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>