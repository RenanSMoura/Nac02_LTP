package br.com.fiap.ltp.nac02.questao1.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.ltp.nac02.questao1.arquivo.GeraArquivo;
import br.com.fiap.ltp.nac02.questao1.banco.VeiculoDao;

/**
 * Servlet implementation class ServletVeiculoArquivo
 */
@WebServlet("/gerar")
public class GerarArquivoVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GerarArquivoVeiculo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GeraArquivo arquivo = new GeraArquivo();

		VeiculoDao veiculoDao = new VeiculoDao();

		ArrayList<String> linhas = new ArrayList<String>();

		linhas.addAll(veiculoDao.listarVeiculo2015());
		arquivo.criaArquivo();
		arquivo.preencherArquivo(linhas);
		response.sendRedirect("success.jsp");

		try {
			arquivo.fecharArquivo();
		} catch (IOException e) {
			System.out.println("<ERRO COM O ARQUIVO: " + e.getMessage() + ">");
		}

	}

}
