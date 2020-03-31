package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		int populacao = Integer.parseInt(request.getParameter("populacao"));
		double area = Double.parseDouble(request.getParameter("area"));
		
		Pais pais = new Pais();
		pais.setNome(nome);
		pais.setPopulacao(populacao);
		pais.setArea(area);
		
		PaisService service = new PaisService();
		
		
		int id;
		try {
			id = service.criar(pais);
			pais = service.carregar(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("pais", pais);
		
		RequestDispatcher view = request.getRequestDispatcher("Pais.jsp");
		view.forward(request, response);

	}

}
