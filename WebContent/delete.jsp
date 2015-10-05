<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ve�culos - Excluir</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="assets/veiculo.css">
</head>
<body>
	<div class="pure-menu pure-menu-horizontal pure-menu-scrollable">
	    <ul class="pure-menu-list">
	        <li class="pure-menu-item"><a href="read" class="pure-menu-link">Listar Ve�culo</a></li>
	        <li class="pure-menu-item"><a href="create" class="pure-menu-link">Adicionar Ve�culo</a></li>
	        <li class="pure-menu-item"><a href="update" class="pure-menu-link">Alterar Placa</a></li>
	        <li class="pure-menu-item"><a href="delete" class="pure-menu-link">Excluir Ve�culo</a></li>
	        <!--li class="pure-menu-item"><a href="gerar" class="pure-menu-link">Gerar Listagem CVS</a></li-->
	    </ul>
	</div>
	<h1>Excluir Ve�culo</h1>
	
	<form class="pure-form pure-form-aligned" action="delete" method="POST">
	    <fieldset>
	        <div class="pure-control-group">
	            <label for="placa">Placa</label>
	            <input id="placa" name="placa" type="text" placeholder="Placa" maxlength="8" value="${placa}">
	        </div>

	        <div class="pure-controls">
               <button type="submit" class="pure-button pure-button-primary">Confirmar</button>
	        </div>
	    </fieldset>
	</form>
</body>
</html>