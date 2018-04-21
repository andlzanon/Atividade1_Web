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
        CNPJ: ${sessionScope.novoHotel.cnpj}<br/>
        Nome: ${sessionScope.novoHotel.nome}<br/>
        Cidade: ${sessionScope.novoHotel.cidade}<br/>
        <br/>
        <a href="GravarHotelServlet">Confirmar</a>
        <a href="hotelForm.jsp">Modificar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>