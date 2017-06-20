<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
 	br.com.caelum.agenda.dao.ContatoDAO,
 	br.com.caelum.agenda.modelo.Contato"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/lista.css" rel="stylesheet">
<title>Lista de Contatos</title>
</head>
<body>
	<table width="100%">
	<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>

		<%--Inserindo codigo Java na nossa classe --%>
		<%
			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
			ContatoDAO dao = new ContatoDAO();
			List<Contato> lista = dao.getLista();
			for (Contato contato : lista) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td class="data"><%=dataFormatada.format(contato.getDataNascimento().getTime())%></td>
		</tr>

		<%
			}
		%>

	</table>
</body>
</html>