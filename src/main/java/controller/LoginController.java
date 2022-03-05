package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cadastro;
import model.dao.SistemaDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cadastro> dados = new ArrayList<Cadastro>();
		SistemaDao dao = new SistemaDao();
		Cadastro cliente = new Cadastro();
		RequestDispatcher dp = null;
		
		try {
			cliente.setNome(request.getParameter("txtNome"));
			cliente.setSenha(request.getParameter("txtSenha"));
			dados = dao.logar(cliente);
			
			if (dados != null) {
				request.setAttribute("dados", dados);
				dp = request.getRequestDispatcher("Logado.jsp");
				
			}
			else {
				dp = request.getRequestDispatcher("Login.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			dp = request.getRequestDispatcher("erro.jsp");
		}
		finally {
			dp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
