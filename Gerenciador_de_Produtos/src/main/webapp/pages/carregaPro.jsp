<%@ page import="com.loja.dao.*" %>
<%@ page import="com.loja.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar de produto</title>
</head>
<body>
	<h1>Alterar Produto</h1>
	
	<%
		int cod = Integer.parseInt(request.getParameter("codigo"));
		ProdutoDAO dao = new ProdutoDAO();
		Produto p = dao.buscarId(cod);
	%>
	
	<form action="atualizarPro.jsp" method="post">
		<P>
			<label for="cod">Código:</label>
			<input type="number" id="cod" name="codigo" value="<%= p.getCodigo() %>" readonly>
		</P>
		<P>
			<label for="no">Nome:</label>
			<input type="text" size="50" id="no" name="nome" value="<%= p.getNome() %>" maxlength="50" required>
		</P>
		<P>
			<label for="mar">Marca:</label>
			<input type="text" id="mar" size="50" name="marca" value="<%= p.getMarca() %>" maxlength="50" required>
		</P>
		<P>
			<label for="pre">Preço:</label>
			<input type="number" id="pre" step="0" min="0" name="preco" value="<%= p.getPreco() %>" required>
		</P>
		<button type="submit">Salvar alteração</button>
	</form>
</body>
</html>