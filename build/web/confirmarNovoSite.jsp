<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Hotel</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Cadastro de Hotel</h1>
        URL: ${sessionScope.novoSite.url}<br/>
        Nome: ${sessionScope.novoSite.nome}<br/>
        Telefone: ${sessionScope.novoSite.telefone}<br/>
        <br/>
        <a href="GravarSiteServlet">Confirmar</a>
        <a href="siteForm.jsp">Modificar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>