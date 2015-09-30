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
	        <li class="pure-menu-item"><a href="lista" class="pure-menu-link">Listar Veículo</a></li>
	        <li class="pure-menu-item"><a href="add.jsp" class="pure-menu-link">Adicionar Veículo</a></li>
	        <li class="pure-menu-item"><a href="change.jsp" class="pure-menu-link">Alterar Placa</a></li>
	        <li class="pure-menu-item"><a href="delete.jsp" class="pure-menu-link">Excluir Veículo</a></li>
	        <li class="pure-menu-item"><a href="gerar" class="pure-menu-link">Gerar Listagem CVS</a></li>
	    </ul>
	</div>
	<h1>Incluir Veículo</h1>
	<form class="pure-form pure-form-aligned" action="adicionar" method="GET">
	    <fieldset>
	        <div class="pure-control-group">
	            <label for="modelo">Modelo</label>
	            <input id="modelo" name="modelo" type="text" placeholder="Modelo" maxlength="50">
	        </div>
	
	        <div class="pure-control-group">
	            <label for="placa">Placa</label>
	            <input id="placa" name="placa" type="text" placeholder="Placa" maxlength="8" >
	        </div>
	
	        <div class="pure-control-group">
	            <label for="motor">Motor</label>
	            <input id=""motor" name="motor" type="text" placeholder="Motor" maxlength="3">
	        </div>
	
	        <div class="pure-control-group">
	            <label for="ano">Ano</label>
	            <input id="ano" name="ano" type="text" placeholder="Ano" maxlength="4">
	        </div>
	
	        <div class="pure-controls">
               <button type="submit" class="pure-button pure-button-primary">Submit</button>
	        </div>
	    </fieldset>
	</form>
</body>
</html>