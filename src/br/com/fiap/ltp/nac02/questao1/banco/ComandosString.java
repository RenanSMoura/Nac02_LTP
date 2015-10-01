package br.com.fiap.ltp.nac02.questao1.banco;

/**
 * @author rm74390
 * Classe com querys responsáveis pela manipulação do banco de dados
 */
public class ComandosString {
	/*
	 * Atributos
	 */
	
	private String insert = new String("INSERT INTO TB_LTP_VEICULO VALUES"
			+ "(SQ_LTP_VEICULO.NEXTVAL,"
			+ "?,?,?,?)");
	
	private String delete = new String("DELETE FROM TB_LTP_VEICULO WHERE PLACA = ?");
			
	private String selectPlaca = new String("SELECT PLACA FROM TB_LTP_VEICULO WHERE PLACA = ?");
	
	private String updatePlaca = new String ("UPDATE TB_LTP_VEICULO SET PLACA = ? WHERE PLACA = ?");
	
	private String selectAll = new String("SELECT * FROM TB_LTP_VEICULO ORDER BY ID_VEICULO ASC");
	
	private String select2015 = new String ("SELECT * FROM TB_LTP_VEICULO WHERE ANO = '2015'");
	
	/*
	 * Métodos Get's and Set's
	 */

	public String getInsert() {
		
		return insert;
	}

	public String getDelete() {
		return delete;
	}

	public String getSelectPlaca() {
		return selectPlaca;
	}

	public String getUpdatePlaca() {
		return updatePlaca;
	}

	public String getSelectAll() {
		return selectAll;
	}

	public String getSelect2015() {
		return select2015;
	}

}
