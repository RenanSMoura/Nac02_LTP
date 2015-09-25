<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.fiap.ltp.nac02.questao1.Banco.VeiculoDao"%>
<%@ page import="br.com.fiap.ltp.nac02.questao1.Banco.Dao"%>
<%@ page import="java.util.List;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="ServletVeiculoList" method="post">
			<input type="button" value="Listar" /> <input type="button"
				value="Voltar" />
		</form>


	</div>

</body>
</html>