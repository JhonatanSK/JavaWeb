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

@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		String pAcao = request.getParameter("acao");
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
		
		
		if (pAcao.equals("Criar")) {
			int id;
			try {
				id = service.criar(pais);
				pais.setId(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("Pais.jsp");
		}

		else if (pAcao.equals("Excluir")) {
			service.excluir(pais);
			@SuppressWarnings("unchecked")
			ArrayList<Pais> lista = (ArrayList<Pais>) session.getAttribute("lista");
			lista.remove(busca(pais, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarPaises.jsp");
			
		} else if (pAcao.equals("Alterar")) {
			service.atualizar(pais);
			ArrayList<Pais> lista;
			try {
				lista = service.carregarTodos();
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarPaises.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (pAcao.equals("Visualizar")) {
			pais = service.carregar(pais.getId());
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("VisualizarPais.jsp");
			
		} else if (pAcao.equals("Editar")) {
			pais = service.carregar(pais.getId());
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("EditarPais.jsp");
		}
		view.forward(request, response);
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
