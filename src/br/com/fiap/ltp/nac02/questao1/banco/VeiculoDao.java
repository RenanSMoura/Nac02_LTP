package br.com.fiap.ltp.nac02.questao1.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




import br.com.fiap.ltp.nac02.questao1.servlets.ServletVeiculoList;
import br.com.fiap.ltp.nac02.questao1.veiculo.Veiculo;

/**
 *@author rm74390 rm71411 rm71355 rm75011 1TDS-S
 * Comandos de neg�cio do sistema
 * 
 * @see ComandosString
 * @see ConnectionFactory
 */

public class VeiculoDao {
	private Connection connection;
	ComandosString cs = new ComandosString();
	
	/*
	 * Construtor da classe VeiculoDao
	 */
	public VeiculoDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	/**
	 * Insere uma instancia da classe  ve�culo no banco de dados
	 * @param veiculo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void inserir(Veiculo veiculo) throws ClassNotFoundException, SQLException {
		
		PreparedStatement pstmt = connection.prepareStatement(cs.getInsert());
		pstmt.setString(1, veiculo.getModelo());
		pstmt.setString(2, veiculo.getPlaca());
		pstmt.setString(3, veiculo.getAno());
		pstmt.setDouble(4, Double.parseDouble(veiculo.getMotor()));

		pstmt.executeUpdate();
		connection.commit();
		pstmt.close();
		connection.close();

	}
	/**
	 * Realiza a busca por uma instancia da clase ve�culo no banco de dados
	 * @param veiculo
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public boolean buscar(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		
		PreparedStatement pstmt = connection.prepareStatement(cs.getSelectPlaca());
		pstmt.setString(1, veiculo.getPlaca());

		ResultSet rs = pstmt.executeQuery();
		String placa = new String("");

		while (rs.next())
			placa = rs.getString("PLACA");

		if (placa.isEmpty())
			return false;
		else
			return true;
	}
	/**
	 * Deleta uma inst�ncia da classe ve�culo do bando de dados
	 * @param veiculo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public void deletar(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		
		PreparedStatement pstmt = connection.prepareStatement(cs.getDelete());
		pstmt.setString(1, veiculo.getPlaca());
		
		if(this.verificaVeiculo(veiculo)) {
			pstmt.executeUpdate();
			connection.commit();
			pstmt.close();
		}
		connection.close();

	}
	/**
	 *  Procura uma inst�ncia da classe ve�culo no banco de dados
	 * @param veiculo
	 * @return Confirma��o ou n�o da exist�ncia de determinada inst�ncia de ve�culo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean verificaVeiculo(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		boolean retorno = false;
		VeiculoDao veiculoDao = new VeiculoDao();

		if (veiculoDao.buscar(veiculo) == true) {
			retorno = true;
		} else {
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Altera o atributo .getPlaca() de uma inst�ncia da classe ve�culo do banco de dados
	 * @param veiculo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void alterarPlaca(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		
		PreparedStatement pstmt = connection.prepareStatement(cs.getUpdatePlaca());
		pstmt.setString(1, veiculo.getPlacaNova());
		pstmt.setString(2, veiculo.getPlaca());
		
		if (this.buscar(veiculo)) {
			pstmt.executeUpdate();
			connection.commit();
			pstmt.close();
		}
		
		connection.close();

	}
	/**
	 * Realiza a listagem de todas as inst�ncias que est�o contidas dentro do banco de dados.
	 * @see ServletVeiculoList.java
	 * @return Lista contendo inst�ncias da classe Ve�culos
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public List<Veiculo> lista() throws SQLException, ClassNotFoundException {
		List<Veiculo> lista = new ArrayList<>();
		PreparedStatement pstmt = connection.prepareStatement(cs.getSelectAll());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Veiculo veiculo = new Veiculo();
			veiculo.setId(rs.getString("id_veiculo"));
			veiculo.setModelo(rs.getString("modelo"));
			veiculo.setPlaca(rs.getString("placa"));
			veiculo.setMotor(rs.getString("motor"));
			veiculo.setAno(rs.getString("ano"));
			lista.add(veiculo);
		}
		connection.close();

		return lista;

	}
	/**
	 * Realiza uma listagem de todos os ve�culos que possuem seu ano de fabrica��o igual a 2015 e adiciona o resultado 
	 * da listagem em um arquivo @see GeraArquivo.java
	 * @return lista de ve�culos 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public Collection<String> listarVeiculo2015() throws SQLException, ClassNotFoundException {
		ArrayList<String> linhas = new ArrayList<String>();
		PreparedStatement stmtSelect = connection.prepareStatement(cs.getSelect2015());
		ResultSet rs = stmtSelect.executeQuery();

		while (rs.next()) {
			String ano = rs.getString("ANO");
			String placa = rs.getString("PLACA");
			String modelo = rs.getString("MODELO");
			String motor = String.valueOf(rs.getDouble("MOTOR"));

			linhas.add(ano + " , " + placa + " , " + modelo + " , " + motor);
		}

		return linhas;
	}

}
