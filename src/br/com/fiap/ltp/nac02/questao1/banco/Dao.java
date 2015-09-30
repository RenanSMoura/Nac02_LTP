package br.com.fiap.ltp.nac02.questao1.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Dao {

	Connection connection = null;


	public Connection getConnection()throws SQLException, ClassNotFoundException{


		Class.forName("oracle.jdbc.driver.OracleDriver");		
//		String url = new String("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL");
//		String user = new String ("OPS$RM71411");
//		String senha = new String("221289");
//		
		
		String usuario = "OPS$RM75011";//seu RM
		String senha = "081082";//sua data de nascimento
		String jdbcUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; //acesso externo
		//String jdbcUrl = "jdbc:oracle:thin:@192.168.60.15:1521:ORCL"; //acesso interno
		//String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; //acesso local express edition

		// abre a conexao
		 connection = DriverManager.getConnection(jdbcUrl, usuario, senha);


		
		//connection = DriverManager.getConnection(,user,senha);
		connection.setAutoCommit(false);

		return connection;


	}
	
	
}