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
<!DOCTYPE html>
<html>
<head>
    <title>Itens Roubados</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/detalhes.css" />" />
    <script type="application/javascript" src="<c:url value="/resources/javascript/funcoes.js" />"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body class="fundo">
<div class="principal">
    <div class="cabecalho"></div>
    <div class="menu mudarfundo">
        <ul>
            <li><a href="/cadastro">Cadastrar ocorrencia</a></li>
            <li><a href="/sair">Sair</a></li>
        </ul>
    </div>
    <div class="corpo">
        <div class="conteudo">
            <div class="formulario mudarfundo">
                <form action="cadastro" method="post">
                    <p>Tipo : <input id="tipo" type="text" name="tipo"></p>
                    <p>Descricao : <input id="descricao" type="text" name="descricao"></p>
                    <p>Telefone 1 : <input id="telefone1" type="text" name="telefone1"></p>
                    <p>Telefone 2 : <input id="telefone2" type="text" name="telefone2"></p>
                    <%--<input type="submit" value="Cadastrar">--%>
                    <a onclick="cadastrar()">Cadastrar</a>
                </form>
            </div>
        </div>
    </div>
    <div class="rodape">Desenvolvido por Gustavo Ramalho</div>
</div>
</body>
</html>