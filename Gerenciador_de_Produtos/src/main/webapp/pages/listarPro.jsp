<%@ page import="com.loja.dao.*" %>
<%@ page import="com.loja.model.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de produtos</title>
<link rel="stylesheet" href="../assets/css/table.css">
</head>
<body>
		<h1>Listar de Produtos</h1>
		<table>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Marca</th>
				<th>Preço</th>
				<th>Exclusão</th>
				<th>Alteração</th>
			</tr>
			<%
			ProdutoDAO dao = new ProdutoDAO();
			List<Produto> lista = dao.listar();
			for(Produto p : lista) {
			%>
			<tr>
				<td><%= p.getCodigo() %></td>
				<td><%= p.getNome() %></td>
				<td><%= p.getMarca() %></td>
				<td><%= p.getPreco() %></td>
				<td><a href="excluirPro.jsp?codigo=<%= p.getCodigo() %>">Excluir</a></td>
				<td><a href="carregaPro.jsp?codigo=<%= p.getCodigo() %>">Alterar</a></td>
			</tr>
			<%
			}
			%>
		</table>
</body>
</html>