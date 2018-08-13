<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 4/5/14
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Itens Roubados</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/detalhesLogarERegistrar.css" />" />
</head>
<body class="fundo">
<div class="principal">
    <div class="cabecalho"></div>
    <div class="menu">
        <ul>
            <li><a href="/logar">Logar</a></li>
            <li><a href="/registrar">Registrar</a></li>
        </ul>
    </div>
    <div class="corpo">
        <div class="conteudo">
            <div class="formulario">
                <form action="logar" method="post">
                    <p>Usuario : <input type="text" name="us_usuario"></p>
                    <p>Senha : <input type="password" name="us_senha"></p>
                    <input type="submit" value="Logar">
                </form>
            </div>
        </div>
    </div>
    <div class="rodape">Desenvolvido por Gustavo Ramalho</div>
</div>
</body>
</html>