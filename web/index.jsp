<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:remove scope="session" var="novoHotel" />
<c:remove scope="session" var="novoSite"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Hoteis</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Bem-vindo ao Bookking do DC!</h1>
        <hr>
        <p>Escolha o que deseja fazer:</p>
        <a href="loginServlet?usuario=adm">Cadastro de Site de Reservas</a><br/>
        <a href="#">Cadastrar Hotel</a><br/>
        <a href="VerHoteisServlet">Listar todos os hoteis</a><br/>
        
        <form action="VerHoteisServlet" method="post">
            <a>Pesquisar por cidade:</a><input name="cidade" type="text" value=""/> <input type="submit" value="Procurar"/>
        </form>
        
    </body>
</html>