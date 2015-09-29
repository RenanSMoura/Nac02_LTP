package br.com.fiap.ltp.nac02.questao1.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.ltp.nac02.questao1.Banco.VeiculoDao;
import br.com.fiap.ltp.nac02.questao1.veiculo.Veiculo;

/**
 * Servlet implementation class ServletVeiculoChange
 */
@WebServlet("/ServletVeiculoChange")
public class ServletVeiculoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVeiculoChange() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Veiculo veiculo = new Veiculo();
		VeiculoDao veiculoDao = new VeiculoDao();
		boolean verifica = false;
		
		try{
			veiculo.setPlaca(request.getParameter("placa"));
			veiculo.setPlacaNova(request.getParameter("placaNova"));
				verifica = veiculoDao.buscar(veiculo);
					if(verifica){
						veiculoDao.alterarPlaca(veiculo);
						response.sendRedirect("success.jsp");
					}
			
			
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println("Deu merda no SQL");
		}catch (ClassNotFoundException e){
			System.out.println("Mano, deu merda na hora de montar a classe!!!!!!!!!1");
			e.printStackTrace();
		}
		
		
		
	}

}
