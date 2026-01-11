<%@ page import="com.loja.dao.*" %>
<%@ page import="com.loja.model.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado da Pesquisa</title>
<link rel="stylesheet" href="../assets/css/table.css">
</head>
<body>
	<%
		String termo = request.getParameter("nome");
	%>
	<h1>Resultado para: "<%= termo %>"</h1>
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
		List<Produto> lista = dao.buscarPorNome(termo);
		if(lista.isEmpty()) {
			out.print("Produto não encontrado <meta http-equiv='refresh' content='5; url=listarPro.jsp'>");
		}
		
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