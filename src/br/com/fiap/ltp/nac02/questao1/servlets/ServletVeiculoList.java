package br.com.fiap.ltp.nac02.questao1.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.ltp.nac02.questao1.banco.VeiculoDao;
import br.com.fiap.ltp.nac02.questao1.veiculo.Veiculo;

/**
 * @author rm74390
 * 
 * Servlet responsável por realizar a listagem das instâncias e mostra-lás na página jsp
 * @see main.jsp
 * @see VeiculoDao.java 
 * @throws ServletException
 * @throws  IOException
 */
@WebServlet("/lista")
public class ServletVeiculoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ServletVeiculoList() {
		super();

	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			VeiculoDao veiculoDao = new VeiculoDao();
			List<Veiculo> lista = null;
			
			lista = veiculoDao.lista();

			getServletContext().setAttribute("veiculos", lista);
			response.sendRedirect("main.jsp");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
