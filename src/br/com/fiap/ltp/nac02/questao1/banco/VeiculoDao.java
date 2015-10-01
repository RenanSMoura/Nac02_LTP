package br.com.fiap.ltp.nac02.questao1.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.fiap.ltp.nac02.questao1.veiculo.Veiculo;

public class VeiculoDao {
	private Connection connection;
	StringsSql sql = new StringsSql();

	public VeiculoDao() {
		
	}

	public void inserir(Veiculo veiculo) {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql.getInsert());
			pstmt.setString(1, veiculo.getModelo());
			pstmt.setString(2, veiculo.getPlaca());
			pstmt.setString(3, veiculo.getAno());
			pstmt.setDouble(4, Double.parseDouble(veiculo.getMotor()));
			pstmt.executeUpdate();
			connection.commit();
			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean buscar(Veiculo veiculo) {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql.getSelectPlaca());
			pstmt.setString(1, veiculo.getPlaca());

			ResultSet rs = pstmt.executeQuery();
			String placa = new String("");

			while (rs.next()) {
				placa = rs.getString("PLACA");
			}
			
			System.out.println(placa + " " + placa.isEmpty());
			
			return (!placa.isEmpty()) ? true : false;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deletar(Veiculo veiculo) {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql.getDelete());
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.executeUpdate();
			connection.commit();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean verificaVeiculo(Veiculo veiculo) {
		VeiculoDao veiculoDao = new VeiculoDao();
		System.out.println("-->" + veiculoDao.buscar(veiculo));
		return (veiculoDao.buscar(veiculo) == true) ? true : false;
	}

	public void alterarPlaca(Veiculo veiculo) {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql.getUpdatePlaca());
			pstmt.setString(1, veiculo.getPlacaNova());
			pstmt.setString(2, veiculo.getPlaca());

			pstmt.executeUpdate();
			connection.commit();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Veiculo> lista() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			List<Veiculo> lista = new ArrayList<>();
			PreparedStatement pstmt = connection.prepareStatement(sql.getSelectAll());
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

			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Collection<String> listarVeiculo2015() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			ArrayList<String> linhas = new ArrayList<String>();
			PreparedStatement stmtSelect = connection.prepareStatement(sql.getSelect2015());
			ResultSet rs = stmtSelect.executeQuery();
	
			while (rs.next()) {
				String ano = rs.getString("ANO");
				String placa = rs.getString("PLACA");
				String modelo = rs.getString("MODELO");
				String motor = String.valueOf(rs.getDouble("MOTOR"));
	
				linhas.add(ano + " , " + placa + " , " + modelo + " , " + motor);
			}
			return linhas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
