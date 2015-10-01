package br.com.fiap.ltp.nac02.questao1.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Classe responsável pela conexão com o banco Oracle
 * @see Connection
 * @author rm74390
 *
 */
public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "OPS$RM75011", "081082");
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}