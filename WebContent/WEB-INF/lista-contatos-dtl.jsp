<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="br.com.caelum.agenda.modelo.Contato"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/displaytag.css" rel="stylesheet"></link>
<title>Lista de Contatos - Display tag</title>
</head>
<body>

	<!-- Cabecalho da pagina -->
	<c:import url="/WEB-INF/jsp/cabecalho.jsp"></c:import>

	<!-- Cria o DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDAO">
	
		<% List<Contato> lista = dao.getLista();
			request.setAttribute( "teste", lista ); %>

		<!-- Display Tag Library -->
		<display:table name="teste">
			<display:column property="nome" title="Nome"/>
			<display:column property="email" title="Email" />
			<display:column property="endereco" title="Endereco" />
			<display:column property="dataNascimento.time" format="{0,date,dd/MM/yyyy}"
				title="Data de Nascimento" />
		</display:table>

	</jsp:useBean>

	<!-- Rodape da pagina -->
	<c:import url="/WEB-INF/jsp/rodape.jsp"></c:import>

</body>
</html>