<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  
            //recebe o parametro que vem do index.jsp e depois o insere como
            //parametro para a permissao no servlet
            String param = request.getParameter("permissao");
            String param2 = request.getParameter("acao");
            //somente primera letra em maiuscula para o head da tela de login
            if(param2.equals("sitelist")){
                //cria formBeans, acessa com o get e da um override no parametro acao
            }
            String titulo = param.substring(0, 1).toUpperCase() + param.substring(1, param.length());
            System.out.println(param);
%>        
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
    <body>
        <h1>Login de <%=titulo%></h1>
        <hr>
        <form action="LoginServlet?permissao=<%=param%>&acao=<%=param2%>" method="post">
            Digite seus dados:<br/>
            Usuário: <input name="usuario" type="text" value="" /><br/>
            Senha: <input name="senha" type="text" value="" /><br/>
            <input type="submit" value="Entrar"/>
        </form>
    </body>
</html>
