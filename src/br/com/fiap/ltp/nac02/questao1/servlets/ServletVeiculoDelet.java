package br.com.fiap.ltp.nac02.questao1.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.ltp.nac02.questao1.banco.VeiculoDao;
import br.com.fiap.ltp.nac02.questao1.veiculo.Veiculo;

/**
 * Servlet implementation class ServletVeiculoDelet
 */
@WebServlet("/excluir")
public class ServletVeiculoDelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVeiculoDelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			Veiculo veiculo = new Veiculo();
			VeiculoDao veiculoDao = new VeiculoDao();
			boolean verifica = false;

			veiculo.setPlaca(request.getParameter("placa"));
			verifica = veiculoDao.verificaVeiculo(veiculo);
			if (verifica)
				veiculoDao.deletar(veiculo);
			response.sendRedirect("lista");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Deu merda!");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("Deu merda na classe!");
		}

	}

}
