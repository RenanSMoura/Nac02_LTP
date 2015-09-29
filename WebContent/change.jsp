<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form action="ServletVeiculoChange" method="get">
			<h2> Alterar a Placa do Veículo</h2>
			Placa Antiga  <input type="text" name="placa"/><br/>
			Placa Nova  <input type="text" name="placaNova"/><br/>
			<input type="submit" value="Salvar"/> <input type="reset" value="Limpar"/> <br/>
			
		</form>
		<button onclick="location.href='main.jsp'">Menu Principal</button></br>
	</div>
</body>
</html>