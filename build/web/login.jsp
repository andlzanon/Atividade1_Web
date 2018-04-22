<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="br.ufscar.dc.hotel.forms.SiteFormBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%  
            //recebe o parametro que vem do index.jsp e depois o insere como
            //parametro para a permissao no servlet
            String param = request.getParameter("permissao");
            String param2 = request.getParameter("acao");
            
            String titulo = param.substring(0, 1).toUpperCase() + param.substring(1, param.length());
            System.out.println("Param1: "+param);
            System.out.println("Param2: "+param2);
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
        <c:if test="${!empty requestScope.mensagens}">
            <ul class="erro">
                <c:forEach items="${requestScope.mensagens}" var="mensagem">
                    <li>${mensagem}</li>
                    </c:forEach>
            </ul>
            <hr>
        </c:if>
        <form action="LoginServlet?permissao=<%=param%>&acao=<%=param2%>" method="post">
            Digite seus dados:<br/>
            Usuário: <input name="usuario" type="text" value="${sessionScope.dadosLogin.usuario}" /><br/>
            Senha: <input name="senha" type="password" value="${sessionScope.dadosLogin.senha}" /><br/>
            <input type="submit" value="Entrar"/>
        </form>
    </body>
</html>
