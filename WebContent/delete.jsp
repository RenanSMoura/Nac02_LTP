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
	<h2> Deletar Ve�culo</h2>
	<form action="ServletVeiculoDelet" method="get">
	Placa do ve�culo: <input type="text" name="placa"/>
	<input type="submit" value="Salvar"/> <input type="reset" value="Limpar"/> </br>
	</form>
	<button onclick="location.href='main.jsp'">Menu Principal</button></br>
</div>
</body>
</html>