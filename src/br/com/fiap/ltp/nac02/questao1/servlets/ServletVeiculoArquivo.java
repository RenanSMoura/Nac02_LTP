package br.com.fiap.ltp.nac02.questao1.servlets;

import java.io.IOException;
import java.sql.SQLException;
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
public class ServletVeiculoArquivo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVeiculoArquivo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GeraArquivo arquivo = new GeraArquivo();
		
		try {
			VeiculoDao veiculoDao = new VeiculoDao();

			ArrayList<String> linhas = new ArrayList<String>();
			

			linhas.addAll(veiculoDao.listarVeiculo2015());
			arquivo.criaArquivo();
			arquivo.preencherArquivo(linhas);
			response.sendRedirect("success.jsp"); // Criar jsp para arquivo!

		} catch (SQLException e) {
			System.out.println("<ERRO COM O SGBD: " + e.getMessage() + ">");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			arquivo.fecharArquivo();
		} catch (IOException e) {
			System.out.println("<ERRO COM O ARQUIVO: " + e.getMessage() + ">");
		}

	}

}
