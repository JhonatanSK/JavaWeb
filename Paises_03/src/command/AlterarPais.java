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

public class AlterarPais implements Command{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		request.setCharacterEncoding("UTF-8");
		
		String nome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		String pIdPais = request.getParameter("id");
		
		int idPais = -1;
		int populacao = 0;
		double area = 0.0; 
		
		try {
			if (pIdPais != null) idPais = Integer.parseInt(pIdPais);
			if (pPopulacao != null) populacao = Integer.parseInt(pPopulacao);
			if (pArea != null) area = Double.parseDouble(pArea);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		Pais pais = new Pais();
		pais.setId(idPais);
		pais.setNome(nome);
		pais.setPopulacao(populacao);
		pais.setArea(area);

		PaisService service = new PaisService();
		HttpSession session = request.getSession();
		RequestDispatcher view = null;
		

		service.atualizar(pais);
		ArrayList<Pais> lista;
		try {
			lista = service.carregarTodos();
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarPaises.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		view.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		execute(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
		execute(request, response);
	}
	
	public int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == pais.getId()){
				return i;
			}
		}
		return -1;
	}
	
}
