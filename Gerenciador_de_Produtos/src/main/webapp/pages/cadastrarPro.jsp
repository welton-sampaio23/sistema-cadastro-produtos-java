<%@ page import="com.loja.dao.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			int c = Integer.parseInt(request.getParameter("codigo"));
			String n = request.getParameter("nome");
			String m = request.getParameter("marca");
			double p = Double.parseDouble(request.getParameter("preco"));
			ProdutoDAO dao = new ProdutoDAO();
			dao.cadastrar(c, n, m, p);
			out.print("Produto cadastrado com sucesso");
		%>
	</body>
</html>