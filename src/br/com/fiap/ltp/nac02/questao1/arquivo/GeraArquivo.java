package br.com.fiap.ltp.nac02.questao1.arquivo;

import java.io.*;
import java.util.ArrayList;

public class GeraArquivo {

	// Atributos.

	private FileWriter path;
	private PrintWriter output;

	// Métodos.

	public void criaArquivo() throws IOException {
		path = new FileWriter("E:/veiculos2015.csv");
		output = new PrintWriter(path);
	}

	public void preencherArquivo(ArrayList<String> linhas) throws IOException {
		for (String elemento : linhas) {
			output.println(elemento);
		}
	}

	public void fecharArquivo() throws IOException {
		output.close();
		path.close();
	}

}
