package br.com.fiap.ltp.nac02.questao1.arquivo;

import java.io.*;

/**
 * Gerador de arquivo
 * @author rm74390
 */
import java.util.ArrayList;

public class GeraArquivo {

	// Atributos.

	private FileWriter path;
	private PrintWriter output;

	/**
	 * Cria Arquivo veiculos2015.csv
	 * @throws IOException
	 */

	public void criaArquivo() throws IOException {
		path = new FileWriter("D:/veiculos2015.csv");
		output = new PrintWriter(path);
	}
	/**
	 * 
	 * Preenche as linhas do arquivo
	 * @throws IOException
	 */

	public void preencherArquivo(ArrayList<String> linhas) throws IOException {
		for (String elemento : linhas) {
			output.println(elemento);
		}
	}
	/*
	 * Fecha arquivo
	 */
	public void fecharArquivo() throws IOException {
		output.close();
		path.close();
	}

}
