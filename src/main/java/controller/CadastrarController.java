package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cadastro;
import model.dao.SistemaDao;

/**
 * Servlet implementation class CadastrarController
 */
@WebServlet("/Cadastrar")
public class CadastrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cadastro cliente = new Cadastro();
		SistemaDao dao = new SistemaDao();
		RequestDispatcher dp = null;
		
		try {
			if (request.getParameter("txtNome").trim() != "" && request.getParameter("txtCpf").trim() != "" && request.getParameter("txtSenha").trim() != "") {
				cliente.setNome(request.getParameter("txtNome"));
				cliente.setCpf(request.getParameter("txtCpf"));
				cliente.setSenha(request.getParameter("txtSenha"));
				dp = request.getRequestDispatcher("Login.jsp");
			}
			else {
				cliente.setNome(null);
				cliente.setCpf(null);
				cliente.setSenha(null);
				
				dp = request.getRequestDispatcher("Cadastro.jsp");
				
			}
			
			dao.cadastrar(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
			dp = request.getRequestDispatcher("erro.jsp");
		}
		finally {
			dp.forward(request, response);
		}
		
	}

}
