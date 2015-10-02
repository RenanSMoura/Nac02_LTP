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
 *
 *@author rm74390 rm71411 rm71355 rm75011 1TDS-S
 * 
 * Servlet respons�vel altera��o do atribuo PLACA, nas inst�ncias da classe Veiculo no banco de dados.
 * @see VeiculoDao.java 
 * 
 * @throws ServletException
 * @throws  IOException
 * 
 */
@WebServlet("/atualizar")
public class ServletVeiculoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ServletVeiculoChange() {
		super();

	}

	/**
	 * M�todo R
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			Veiculo veiculo = new Veiculo();
			VeiculoDao veiculoDao = new VeiculoDao();
			
			veiculo.setPlaca(request.getParameter("placa"));
			veiculo.setPlacaNova(request.getParameter("placaNova"));
			veiculoDao.alterarPlaca(veiculo);
			response.sendRedirect("lista");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
