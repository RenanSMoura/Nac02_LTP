<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Veículos - Listagem</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="assets/veiculo.css">
</head>
<body>
	<div class="pure-menu pure-menu-horizontal pure-menu-scrollable">
	    <ul class="pure-menu-list">
	        <li class="pure-menu-item"><a href="lista" class="pure-menu-link">Listar Veículo</a></li>
	        <li class="pure-menu-item"><a href="add.jsp" class="pure-menu-link">Adicionar Veículo</a></li>
	        <li class="pure-menu-item"><a href="gerar" class="pure-menu-link">Gerar Listagem CVS</a></li>
	    </ul>
	</div>
	
	<h1>Listagem de Veículos</h1>
	
	<table class="pure-table pure-table-bordered">
	    <thead>
	        <tr>
	            <th>#</th>
	            <th>Modelo</th>
	            <th>Placa</th>
	            <th>Ano</th>
	            <th>Motor</th>
	            <th>Ações</th>
	        </tr>
	    </thead>
		
		<!-- cria o DAO -->
		<%--  <jsp:useBean id="dao" class="br.com.fiap.ltp.nac02.questao1.banco.VeiculoDao"/> --%>
		
	    <tbody>
	    	<c:forEach items="${veiculos}" var="veiculo">
			    <tr>      
			        <td>${veiculo.id}</td>
			        <td>${veiculo.modelo}</td>
			        <td>${veiculo.placa}</td>
			        <td>${veiculo.ano}</td>
			        <td>${veiculo.motor}</td>
			        <td>
		            	<a href="change.jsp?id=${veiculo.id}">Alterar</a> | <a href="delete?id=${veiculo.id}">Excluir</a>
		            </td> 
			    </tr>
			</c:forEach>
	    </tbody>
	</table>




	<!-- <div align="center">
	
		<button onclick="location.href='add.jsp'">Adicionar Veículo</button></br>
		<button onclick="location.href='change.jsp'">Alterar Placa </button></br>
		<button onclick="location.href='dell.jsp'">Deletar Veículo </button></br>
		<form action="ServletVeiculoArquivo" method="get">
		<button type="submit">Arquivo de Veículos 2015</button>
		</form>
		<form action="ServletVeiculoList" method="get">
		<button type="submit">Listar Arquivos</button>
		</form>
		<button>Sair</button>
	
	</div> -->
	
</body>
</html>