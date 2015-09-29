<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


 
<body>

	<h2> Incluir Veículo!</h2>
		<form action="ServletVeiculo" method="GET">
			Modelo: <input type ="text"name="modelo" /> <br/>
			Placa: <input type="text" name="placa"  maxlength="9"/><br/>
			Motor: <input type="text"  name="motor" id="motor" onkeypress="//return SomenteNumero(event)" /><br/>
			Ano de Fabricação: <input type="text" value="" name="ano" onkeypress="return SomenteNumero(event)"/><br/>
			<input type="submit" value="Salvar"/> <input type="reset" value="Limpar"/> <input type="button" value="Voltar"/>
		</form>
		</br>
		<button onclick="location.href='main.jsp'">Menu Principal</button></br>
		
		<script>
			document.getElementById("motor").addEventListener("input", function() {
				this.value = this.value.replace(/\D+/, "");
			})
		</script>



</body>
</html>