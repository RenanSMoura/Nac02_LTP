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
 * Comandos de negócio do sistema
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
	 * Insere uma instancia da classe  veículo no banco de dados
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
	 * Realiza a busca por uma instancia da clase veículo no banco de dados
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
	 * Deleta uma instância da classe veículo do bando de dados
	 * @param veiculo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public void deletar(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		
		PreparedStatement pstmt = connection.prepareStatement(cs.getDelete());
		pstmt.setString(1, veiculo.getPlaca());

		pstmt.executeUpdate();
		connection.commit();
		pstmt.close();
		connection.close();

	}
	/**
	 *  Procura uma instância da classe veículo no banco de dados
	 * @param veiculo
	 * @return Confirmação ou não da existência de determinada instância de veículo
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
	 * Altera o atributo .getPlaca() de uma instância da classe veículo do banco de dados
	 * @param veiculo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void alterarPlaca(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		
		PreparedStatement pstmt = connection.prepareStatement(cs.getUpdatePlaca());
		pstmt.setString(1, veiculo.getPlacaNova());
		pstmt.setString(2, veiculo.getPlaca());

		pstmt.executeUpdate();
		connection.commit();
		pstmt.close();
		connection.close();

	}
	/**
	 * Realiza a listagem de todas as instâncias que estão contidas dentro do banco de dados.
	 * @see ServletVeiculoList.java
	 * @return Lista contendo instâncias da classe Veículos
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
	 * Realiza uma listagem de todos os veículos que possuem seu ano de fabricação igual a 2015 e adiciona o resultado 
	 * da listagem em um arquivo @see GeraArquivo.java
	 * @return lista de veículos 
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
