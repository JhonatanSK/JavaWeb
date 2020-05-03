package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class ListarPaises implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		request.setCharacterEncoding("UTF-8");
		
		PaisService service = new PaisService();
		HttpSession session = request.getSession();
		
		ArrayList<Pais> lista = null;
		try {
			lista = service.carregarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("ListarPaises.jsp");
		
		view.forward(request, response);	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		execute(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		execute(request, response);
	}

}
