package br.com.fiap.ltp.nac02.questao1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.ltp.nac02.questao1.banco.VeiculoDao;
import br.com.fiap.ltp.nac02.questao1.veiculo.Veiculo;

/**
 * Servlet implementation class ServletVeiculoChange
 */
@WebServlet("/atualizar")
public class AlterarVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarVeiculo() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Veiculo veiculo = new Veiculo();
		VeiculoDao veiculoDao = new VeiculoDao();
		boolean verifica = false;

		veiculo.setPlaca(request.getParameter("placa"));
		veiculo.setPlacaNova(request.getParameter("placaNova"));
		verifica = veiculoDao.buscar(veiculo);
		if (verifica) {
			veiculoDao.alterarPlaca(veiculo);
		}
		response.sendRedirect("lista");
	}

}
