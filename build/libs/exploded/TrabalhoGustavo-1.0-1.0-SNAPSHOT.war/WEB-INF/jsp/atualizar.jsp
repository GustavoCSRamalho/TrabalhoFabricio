<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 4/5/14
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>Itens Roubados</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/detalhes.css" />" />
</head>
<body>
<div class="principal">
    <div class="cabecalho"></div>
    <div class="menu">
        <ul>
            <li><a href="/cadastro">Cadastrar ocorrencia</a></li>
            <li><a href="/sair">Sair</a></li>
        </ul>
    </div>
    <div class="corpo">
        <div class="conteudo">
            <div class="formulario">
                <form action="atualizar" method="post">
                    <input type="hidden" name="codigo" value="${ocorrencia.oc_codigo}">
                    <input type="hidden" name="usuario" value="${ocorrencia.oc_usuario}">
                    <input type="hidden" name="telefone1_id" value="${ocorrencia.telefones[0].tel_codigo}">
                    <input type="hidden" name="telefone2_id" value="${ocorrencia.telefones[1].tel_codigo}">
                    <p>Tipo : <input type="text" name="tipo" value="${ocorrencia.oc_tipo}"></p>
                    <p>Descricao : <input type="text" name="descricao" value="${ocorrencia.oc_descricao}"></p>
                    <p>Telefone 1 : <input type="text" name="telefone1" value="${ocorrencia.telefones[0].tel_telefone}"></p>
                    <p>Telefone 2 : <input type="text" name="telefone2" value="${ocorrencia.telefones[1].tel_telefone}"></p>
                    <input type="submit" value="Cadastrar">
                </form>
            </div>
        </div>
    </div>
    <div class="rodape">Desenvolvido por Gustavo Ramalho</div>
</div>
</body>
</html>
