package br.com.fiap.web.nac02.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.web.nac02.banco.VeiculoDao;
import br.com.fiap.web.nac02.classes.Veiculo;

/**
 *
 * @author rm74390 rm71411 rm71355 rm75011 1TDS-S
 * 
 *         Servlet respons�vel altera��o do atribuo PLACA, nas inst�ncias da
 *         classe Veiculo no banco de dados.
 * @see VeiculoDao.java
 * 
 * @throws ServletException
 * @throws IOException
 * 
 */
@WebServlet("/update")
public class ServletVeiculoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVeiculoUpdate() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println();
		
		try {
			String placa;
			Veiculo veiculo = new Veiculo();
			veiculo.setId(request.getParameter("id"));
			
			VeiculoDao veiculoDao = new VeiculoDao();
			placa = veiculoDao.buscarId(veiculo);
			getServletContext().setAttribute("placa", placa);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("update.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Veiculo veiculo = new Veiculo();
			VeiculoDao veiculoDao = new VeiculoDao();
			veiculo.setPlaca(request.getParameter("placa"));
			veiculo.setPlacaNova(request.getParameter("placaNova"));
			veiculoDao.alterarPlaca(veiculo);
			response.sendRedirect("read");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
