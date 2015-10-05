package br.com.fiap.web.nac02.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.web.nac02.banco.VeiculoDao;
import br.com.fiap.web.nac02.classes.Veiculo;

/**
 * @author rm74390 rm71411 rm71355 rm75011 1TDS-S
 * 
 *         Servlet respons�vel por realizar a listagem das inst�ncias e
 *         mostra-l�s na p�gina jsp
 * @see read.jsp
 * @see VeiculoDao.java
 * @throws ServletException
 * @throws IOException
 */
@WebServlet("/read")
public class ServletVeiculoRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVeiculoRead() {
		super();

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			VeiculoDao veiculoDao = new VeiculoDao();
			List<Veiculo> lista = null;

			lista = veiculoDao.lista();
			getServletContext().setAttribute("veiculos", lista);
			response.sendRedirect("read.jsp");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
