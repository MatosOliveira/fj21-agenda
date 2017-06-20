<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<title>Adiciona Contatos</title>
</head>
<body>

	<!-- Cabecalho da pagina -->
	<c:import url="/WEB-INF/jsp/cabecalho.jsp" />
	
	<h1>Adiciona Contatos</h1>
	<hr />
	<form action="mvc?logica=AdicionaAlteraContatoLogic&id=0" method="post">
		<p>
			Nome: <input type="text" name="nome" /><br />
		</p>
		<p>
			E-mail: <input type="text" name="email" /><br />
		</p>
		<p>
			Endereco: <input type="text" name="endereco" /><br />
		</p>
		<p>
			<!-- Data de Nascimento: <input type="text" name="dataNascimento" /><br /> -->
			Data de Nascimento: <caelum:campoData id="dataNascimento"></caelum:campoData><br />
		</p>
		<input type="submit" value="Gravar" />
	</form>
	
	<!-- Rodape da pagina -->
	<c:import url="/WEB-INF/jsp/rodape.jsp" />
	
</body>
</html>