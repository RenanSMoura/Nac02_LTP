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
 *@author rm74390 rm71411 rm71355 rm75011 1TDS-S
 * 
 * Servlet responsável pela geração do arquivo.
 * @see VeiculoDao.java 
 * @see GerarArquivo.java
 * @throws ServletException
 * @throws  IOException
 */

@WebServlet("/gerar")
public class ServletVeiculoArquivo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ServletVeiculoArquivo() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GeraArquivo arquivo = new GeraArquivo();

		try {
			VeiculoDao veiculoDao = new VeiculoDao();

			ArrayList<String> linhas = new ArrayList<String>();


			linhas.addAll(veiculoDao.listarVeiculo2015());
			arquivo.criaArquivo();
			arquivo.preencherArquivo(linhas);
			response.sendRedirect("success.jsp");

		} catch (SQLException e) {
			 e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			arquivo.fecharArquivo();
		}


	}

}
