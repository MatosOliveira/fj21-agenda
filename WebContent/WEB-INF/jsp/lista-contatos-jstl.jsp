<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/lista.css" rel="stylesheet"></link>
<title>Lista de Contatos</title>
</head>
<body>

	<!-- Cabecalho da pagina -->
	<c:import url="/WEB-INF/jsp/cabecalho.jsp"></c:import>

	<!-- ** Removendo o DAO e substituindo pelo parametro guardado na request ** -->
	<!-- Cria o DAO -->
	<!--<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDAO">-->

	<table width="100%">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
			<th>Remover Contato</th>
			<th>Alterar Contato</th>
		</tr>

		<!-- Percorre contatos montando as linhas da tabela -->
		<c:forEach var="contato" items="${contatos}">
			<tr>
				<!-- Nome do contato -->
				<td>${contato.nome}</td>

				<!-- Validação do email -->
				<td><c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							<p>Email nao informado!</p>
						</c:otherwise>
					</c:choose></td>

				<!-- Endereço do contato -->
				<td align="left">${contato.endereco}</td>

				<!-- Formatação da data -->
				<td align="center"><fmt:formatDate
						value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"></fmt:formatDate>
				</td>

				<!-- Remoção de contatos -->
				<td align="center">
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}"> 
						<img alt="Remover Contato" src="<c:url value="/imagens/excluir.jpg"/>" />
					</a>
				</td>

				<!-- Alteração de contatos -->
				<td align="center">
					<a href="mvc?logica=PesquisaContatoLogic&id=${contato.id}&nome=${contato.nome}&email=${contato.email}&endereco=${contato.endereco}&dataNascimento=<fmt:formatDate value= "${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>">
						<img alt="Alterar Contato" src="<c:url value="/imagens/alterar.jpg"/>" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<!--</jsp:useBean>-->

	<!-- Rodape da pagina -->
	<c:import url="/WEB-INF/jsp/rodape.jsp"></c:import>

</body>
</html>