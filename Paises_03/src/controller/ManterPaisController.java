package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cadastro realizado com sucesso!</title></head><body>");
		out.println("	<h1>Registro cadastrado!</h1>");
		out.println(	"id: "+ pais.getId()+"<br>");
		out.println(	"nome: "+ pais.getNome()+"<br>");
		out.println(	"popula��o: "+ pais.getPopulacao()+"<br>");
		out.println(	"�rea: "+ pais.getArea()+"<br>");
		out.println("</body></html>");
	}

}
