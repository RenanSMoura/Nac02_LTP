<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Veículos - Incluir</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="assets/veiculo.css">
</head>
<body>
	<div class="pure-menu pure-menu-horizontal pure-menu-scrollable">
	    <ul class="pure-menu-list">
	        <li class="pure-menu-item"><a href="main.jsp" class="pure-menu-link">Listar Veículo</a></li>
	        <li class="pure-menu-item"><a href="add.jsp" class="pure-menu-link">Adicionar Veículo</a></li>
	        <li class="pure-menu-item"><a href="#" class="pure-menu-link">Gerar Listagem CVS</a></li>
	    </ul>
	</div>

	<h1>Incluir Veículo</h1>
	<form action="ServletVeiculo" method="GET">
		Modelo: <input type ="text"name="modelo" /> <br/>
		Placa: <input type="text" name="placa"  maxlength="9"/><br/>
		Motor: <input type="text"  name="motor" id="motor" onkeypress="//return SomenteNumero(event)" /><br/>
		Ano de Fabricação: <input type="text" value="" name="ano" onkeypress="return SomenteNumero(event)"/><br/>
		<input type="submit" value="Salvar"/> <input type="reset" value="Limpar"/> <input type="button" value="Voltar"/>
	</form>
		
</body>
</html>