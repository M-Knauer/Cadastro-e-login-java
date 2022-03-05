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
 * Servlet implementation class AlterarController
 */
@WebServlet("/Alterar")
public class AlterarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cadastro cliente = new Cadastro();
		SistemaDao dao = new SistemaDao();
		RequestDispatcher rd = null;
		try {
			cliente.setCpf(request.getParameter("txtCpf").trim());
			cliente.setSenha(request.getParameter("txtSenha").trim());
			dao.alterar(cliente);
			rd = request.getRequestDispatcher("Login.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("erro.jsp");
		}
		finally {
			rd.forward(request, response);
		}
		
	}

}
