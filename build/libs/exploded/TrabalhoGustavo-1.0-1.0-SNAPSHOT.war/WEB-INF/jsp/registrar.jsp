<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 4/5/14
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%--<html>--%>
<%--<head>--%>
    <%--<title></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Welcome SpingMVC4 Home Page!</h1>--%>



<%--</body>--%>
<%--</html>--%>


<!DOCTYPE html>
<html>
<head>
    <title>Itens Roubados</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/detalhesLogarERegistrar.css" />" />
    <script type="application/javascript" src="<c:url value="/resources/javascript/funcoes.js" />"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="principal">
    <div class="cabecalho"></div>
    <div class="menu">
        <ul>
            <li><a href="/">Logar</a></li>
            <li><a href="/registrar">Registrar</a></li>
        </ul>
    </div>
    <div class="corpo">
        <div class="conteudo">
            <div class="formulario">
                <form action="registrar" method="post">
                    <p>Usuario : <input id="us_usuario" type="text" name="us_usuario"></p>
                    <p>Senha : <input id="us_senha" type="password" name="us_senha"></p>
                    <%--<input type="submit" value="Registrar">--%>
                    <a onclick="registrar()">Registrar</a>
                </form>
            </div>
        </div>
    </div>
    <div class="rodape">Desenvolvido por Gustavo Ramalho</div>
</div>
</body>
</html>