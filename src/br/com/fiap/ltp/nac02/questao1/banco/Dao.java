package br.com.fiap.ltp.nac02.questao1.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	Connection connection = null;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String usuario = "OPS$RM75011";// seu RM
		String senha = "081082";// sua data de nascimento
		String jdbcUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; // acesso

		// abre a conexao
		connection = DriverManager.getConnection(jdbcUrl, usuario, senha);

		// connection = DriverManager.getConnection(,user,senha);
		connection.setAutoCommit(false);

		return connection;
	}
}