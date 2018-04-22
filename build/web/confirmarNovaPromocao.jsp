<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Promoção</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Cadastro de Promoção</h1>
        URL: ${sessionScope.novaPromocao.url}<br/>
        CNPJ: ${sessionScope.novaPromocao.cnpj}<br/>
        Preço: ${sessionScope.novaPromocao.preco}<br/>
        Data inicial: ${sessionScope.novaPromocao.data_inicial}<br/>
        Data final: ${sessionScope.novaPromocao.data_final}<br/>
        <br/>
        <a href="GravarPromocaoServlet">Confirmar</a>
        <a href="promocaoForm.jsp">Modificar</a>
        <a href="index.jsp">Cancelar</a>
    </body>
</html>