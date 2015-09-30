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
 * Servlet implementation class ServletVeiculoList
 */
@WebServlet("/lista")
public class ServletVeiculoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVeiculoList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VeiculoDao veiculoDao = new VeiculoDao();
		List<Veiculo> lista = null;

		try {

			// Lista todos os registros existente no Banco de Dados
			lista = veiculoDao.lista();

			getServletContext().setAttribute("veiculos", lista);
			response.sendRedirect("main.jsp");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
