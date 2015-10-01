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
 * @author rm74390
 * 
 * Servlet responsável pela exclusão de uma instância da Classe Veículo, contida no banco de dados
 * @see VeiculoDao.java
 * 
 * @throws ServletException
 * @throws  IOException
 *  
 * 
 */
@WebServlet("/excluir")
public class ServletVeiculoDelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ServletVeiculoDelet() {
		super();
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


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
		
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		
		}

	}

}
