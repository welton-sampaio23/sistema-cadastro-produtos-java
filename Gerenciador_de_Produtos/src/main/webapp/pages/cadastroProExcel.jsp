<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Importar Excel</title>
</head>
<body>
	<h1>Cadastro em Lote</h1>
	
	<form action="../UploadServlet" method="post" enctype="multipart/form-data">
		<label for="sele">Selecione o arquivo</label>
		<input type="file" name="arquivo" id="sele" required accept=".csv">
		<button type="submit">Importar Produtos</button>
	</form>
	
	<!--  <form action="../UploadServlet" method="post" enctype="multipart/form-data">
		<label for="exc">Selecione o arquivo CSV:</label>
		<input type="file" name="arquivo" required accept=".css">
		<button type="submit">Importar Produtos</button>
	</form> -->
</body>
</html>