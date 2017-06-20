<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/jquery-ui.css" rel="stylesheet"/>
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<title>Altera contatos </title>
</head>
<body>
<!-- Cabecalho da pagina -->
	<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
	
	<h1>Altera contatos</h1>
	<hr />
	<form action="mvc?logica=AdicionaAlteraContatoLogic&id=${contato.id}" method="post">
		<p>Nome: <input type="text" name="nome" value="${contato.nome}"><br /></p>
		<p>E-mail: <input type="text" name="email" value="${contato.email}"><br /></p>
		<p>Endereco: <input type="text" name="endereco" value="${contato.endereco}"><br /></p>
		
		<!-- Substituindo o input da data para a nova tagfile criada -->
		<!-- <p>Data de Nascimento: <input type="text" name="dataNascimento"><br /></p> -->
		<p>Data de Nascimento: <input type="text" name="dataNascimento" value="<fmt:formatDate value= "${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>" /><br /></p>
		<p><input type="submit" value="Gravar"></p>
	</form>
	
	<!-- Rodape da pagina -->
	<c:import url="/WEB-INF/jsp/rodape.jsp"/>
</body>
</html>