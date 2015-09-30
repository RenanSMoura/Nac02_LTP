package br.com.fiap.ltp.nac02.questao1.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.fiap.ltp.nac02.questao1.veiculo.Veiculo;

public class VeiculoDao extends Dao {
	ComandosString cs = new ComandosString();

	public void inserir(Veiculo veiculo) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

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

	public boolean buscar(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();

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

	public void deletar(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();

		PreparedStatement pstmt = connection.prepareStatement(cs.getDelete());
		pstmt.setString(1, veiculo.getPlaca());

		pstmt.executeUpdate();
		connection.commit();
		pstmt.close();
		connection.close();

	}

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

	public void alterarPlaca(Veiculo veiculo) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();

		PreparedStatement pstmt = connection.prepareStatement(cs.getUpdatePlaca());
		pstmt.setString(1, veiculo.getPlacaNova());
		pstmt.setString(2, veiculo.getPlaca());

		pstmt.executeUpdate();
		connection.commit();
		pstmt.close();
		connection.close();

	}

	public List<Veiculo> lista() throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		List<Veiculo> lista = new ArrayList<>();
		PreparedStatement pstmt = connection.prepareStatement(cs.getSelectAll());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Veiculo veiculo = new Veiculo();
			System.out.println(rs);
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

	public Collection<String> listarVeiculo2015() throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		ComandosString cs = new ComandosString();
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
