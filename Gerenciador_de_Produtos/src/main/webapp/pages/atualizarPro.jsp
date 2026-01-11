<%@ page import="com.loja.dao.*"%>
<%@ page import="com.loja.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar produto</title>
</head>
<body>
	<%
		int cod = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String marca = request.getParameter("marca");
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		Produto p = new Produto();
		p.setCodigo(cod);
		p.setNome(nome);
		p.setMarca(marca);
		p.setPreco(preco);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.alterar(p);
		out.print("Produto atualizado com sucesso! <meta http-equiv='refresh' content='5; url=listarPro.jsp'>");
	%>
</body>
</html>