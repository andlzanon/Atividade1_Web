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
        <a href="login.jsp?permissao=adm&acao=site">Cadastrar de Site de Reservas</a><br/>
        <a href="login.jsp?permissao=adm&acao=hotel">Cadastrar Hotel</a><br/>
        <a href="VerHoteisServlet">Hoteis Cadastrados</a><br/>
        <a href="login.jsp?permissao=hotel&acao=cadastro">Criação de promoção de hotel</a><br/>
        <a href="login.jsp?permissao=hotel&acao=listagem">Promoções vigentes</a><br/>
        
        <form action="VerHoteisServlet" method="post">
            <a>Pesquisar por cidade:</a><input name="cidade" type="text" value=""/> <input type="submit" value="Procurar"/>
        </form>
        
        <form action="login.jsp?permissao=site&acao=sitelist" method="post">
            <a>Pesquisar promoções por site:</a><input name="cidade" type="text" value=""/> <input type="submit" value="Procurar"/>
        </form>
        
    </body>
</html>