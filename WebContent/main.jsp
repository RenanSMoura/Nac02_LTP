<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	
		<button onclick="location.href='add.jsp'">Adicionar Ve�culo</button></br>
		<button onclick="location.href='change.jsp'">Alterar Placa </button></br>
		<button onclick="location.href='dell.jsp'">Deletar Ve�culo </button></br>
		<form action="ServletVeiculoArquivo" method="get">
		<button type="submit">Arquivo de Ve�culos 2015</button>
		</form>
		<form action="ServletVeiculoList" method="get">
		<button type="submit">Listar Arquivos</button>
		</form>
		<button>Sair</button>
	
	</div>
	
</body>
</html>