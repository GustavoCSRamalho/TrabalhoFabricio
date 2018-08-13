<%--/<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<!DOCTYPE html>
<html>
<head>
    <title>Itens Roubados</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="detalhes.css">
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
            <div class="lista">
                <table>
                    <tr>
                        <th>Tipo</th>
                        <th>Descrição</th>
                        <th>Telefone 1</th>
                        <th>Telefone 2</th>
                        <th>Atualizar</th>
                        <th>Deletar</th>
                    </tr>
                    <c:forEach items="${ocorrencias}" var="ocorrencia">
                        <tr>
                            <td>${ocorrencia.oc_tipo}</td>
                            <td>${ocorrencia.oc_descricao}</td>
                            <c:forEach items="${ocorrencia.telefones}" var="telefone">
                                <td>${telefone.tel_telefone}</td>
                            </c:forEach>
                            <td><a href="/atualizar?codigo=${ocorrencia.oc_codigo}">Ir</a> </td>
                            <td><a href="/deletar?codigo=${ocorrencia.oc_codigo}">Ir</a> </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div class="rodape">Desenvolvido por Gustavo Ramalho</div>
</div>
</body>
</html>