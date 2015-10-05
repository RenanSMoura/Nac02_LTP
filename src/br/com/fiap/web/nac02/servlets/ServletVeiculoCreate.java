package br.com.fiap.web.nac02.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.web.nac02.banco.VeiculoDao;
import br.com.fiap.web.nac02.classes.Veiculo;

/**
 *
 * @author rm74390
 *
 *         Servlet respons�vel por realizar o cadastro do ve�culo no banco de
 *         dados
 * @see VeiculoDao.java
 * 
 * @throws ServletException
 * @throws IOException
 * 
 */
@WebServlet("/create")
public class ServletVeiculoCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVeiculoCreate() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("create.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			Veiculo veiculo = new Veiculo();
			VeiculoDao veiculoDao = new VeiculoDao();

			veiculo.setModelo(request.getParameter("modelo"));
			veiculo.setAno(request.getParameter("ano"));
			veiculo.setPlaca(request.getParameter("placa"));
			veiculo.setMotor(request.getParameter("motor"));
			veiculoDao.inserir(veiculo);
			response.sendRedirect("read");

		} catch (Exception e) {
			e.getMessage();
		}

	}
}
