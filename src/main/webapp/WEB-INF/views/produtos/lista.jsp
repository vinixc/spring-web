<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android etc</title>


<c:url value="/resources/css" var="cssPath"/>

<link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath }/bootstrap-theme.min.css">



</head>
<body>
	<h1>Lista de Produtos</h1>
	
	<div><h1>${sucesso }</h1></div>
	<div><h1>${falha }</h1></div>
	
	<table>
		<tr>
			<td>T�tulo</td>
			<td>Descri��o</td>
			<td>P�ginas</td>
		</tr>
		<c:forEach items="${produtos }" var="produto">
		<tr>
			<td><a href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build() }">${produto.titulo }</a></td>
			<td>${produto.descricao }</td>
			<td>${produto.paginas }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>