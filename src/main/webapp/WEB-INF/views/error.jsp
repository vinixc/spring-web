<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Produto não encontrado">

	<section id="index-section" class="container middle">
		
		<h2>${exception.message } </h2>
		
		<!-- 
			Mensagem: ${exception.message }
			<c:forEach items="${exception.stackTrace}" var="stk">
				${stk}
			</c:forEach>
		 -->
		
	</section>
	
</tags:pageTemplate>
