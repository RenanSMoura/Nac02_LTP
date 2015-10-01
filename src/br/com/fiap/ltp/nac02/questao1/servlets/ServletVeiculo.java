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
 *
 *@author rm74390
 *
 *Servlet responsável por realizar o cadastro do veículo no banco de dados
 * @see VeiculoDao.java 
 * 
 * @throws ServletException
 * @throws  IOException
 * 
 */
@WebServlet("/adicionar")
public class ServletVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ServletVeiculo() {
		super();

	}


	/**

	 *   
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		try {

			Veiculo veiculo = new Veiculo();
			VeiculoDao veiculoDao = new VeiculoDao();

			veiculo.setModelo(request.getParameter("modelo"));
			veiculo.setAno(request.getParameter("ano"));
			veiculo.setPlaca(request.getParameter("placa"));
			veiculo.setMotor(request.getParameter("motor"));
			veiculoDao.inserir(veiculo);
			response.sendRedirect("lista");

		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

}
