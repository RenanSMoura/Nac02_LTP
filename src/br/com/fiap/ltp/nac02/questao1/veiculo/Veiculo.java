package br.com.fiap.ltp.nac02.questao1.veiculo;
/**
 * 
 * @author rm74390 rm71411 rm71355 rm75011 1TDS-S
 *
 *JB classe Veiculo
 *
 */

/*
 * Atributos
 */
public class Veiculo {
	private String id;
	private String modelo;
	private String placa;
	private String ano;
	private String motor;
	private String placaNova;
	
	/*
	 * Construtor
	 */

	public Veiculo() {

	}
	/*
	 * 
	 * M�todos Get's and Set's
	 */

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlacaNova() {
		return placaNova;
	}

	public void setPlacaNova(String placaNova) {
		this.placaNova = placaNova;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

}
