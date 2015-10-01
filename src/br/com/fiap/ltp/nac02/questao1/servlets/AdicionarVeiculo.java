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
 * Servlet implementation class ServletVeiculo
 */
@WebServlet("/adicionar")
public class AdicionarVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionarVeiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Veiculo veiculo = new Veiculo();
		VeiculoDao veiculoDao = new VeiculoDao();

		veiculo.setModelo(request.getParameter("modelo"));
		veiculo.setAno(request.getParameter("ano"));
		veiculo.setPlaca(request.getParameter("placa"));
		veiculo.setMotor(request.getParameter("motor"));
		veiculoDao.inserir(veiculo);
		response.sendRedirect("lista");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

}
