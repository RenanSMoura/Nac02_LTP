package br.com.fiap.ltp.nac02.questao1.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.ltp.nac02.questao1.veiculo.Veiculo;



public class VeiculoDao extends Dao {


	public void inserir(Veiculo veiculo) throws ClassNotFoundException, SQLException {

		
			ComandosString cs = new ComandosString();

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

	public boolean buscar(Veiculo veiculo)throws SQLException, ClassNotFoundException{

		ComandosString cs = new ComandosString();
		Connection connection = getConnection();

		PreparedStatement pstmt = connection.prepareStatement(cs.getSelectPlaca());
		pstmt.setString(1, veiculo.getPlaca());


		ResultSet rs = pstmt.executeQuery();
		String placa = new String("");

		while(rs.next())
			placa = rs.getString("PLACA");

		if(placa.isEmpty())
			return false;
		else
			return true;
	}

	public void deletar(Veiculo veiculo) throws SQLException, ClassNotFoundException{

		
			ComandosString cs = new ComandosString();

			Connection connection = getConnection();

			PreparedStatement pstmt = connection.prepareStatement(cs.getDelete());
			pstmt.setString(1, veiculo.getPlaca());

			pstmt.executeUpdate();
			connection.commit();
			pstmt.close();
			connection.close();
	
	}
	
	public boolean verificaVeiculo(Veiculo veiculo) throws SQLException, ClassNotFoundException{
		boolean retorno = false;
		VeiculoDao veiculoDao = new VeiculoDao();
		
			if(veiculoDao.buscar(veiculo) == true){
				retorno = true;
			}else {
				retorno = false;
			}
			return retorno;
	}


}
