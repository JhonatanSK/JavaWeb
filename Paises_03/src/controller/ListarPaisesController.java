package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;


@WebServlet("/ListarPaises.do")
public class ListarPaisesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		
		//String pAcao = request.getParameter("acao");
		
		PaisService service = new PaisService();
		HttpSession session = request.getSession();
		
		
		ArrayList<Pais> lista = null;
		try {
			lista = service.carregarTodos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("ListarPaises.jsp");
		
		view.forward(request, response);
		
	}

}
