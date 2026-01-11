<%@ page import="com.loja.dao.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir produto</title>
</head>
<body>
	<%
		String cod = request.getParameter("codigo");
		if(cod != null && !cod.isEmpty()) {
			int id = Integer.parseInt(cod);
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(id);
			out.print("Produto excluído com sucesso <meta http-equiv='refresh' content='5; url=listarPro.jsp'>");
		}
	%>
</body>
</html>