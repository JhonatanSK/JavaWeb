package service;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisService {
	PaisDAO dao;

	public PaisService() {
		dao = new PaisDAO();
	}
	
	public int criar(Pais to) throws Exception {
		return dao.incluir(to);
	}
	
	public void atualizar(Pais to) {
		dao.atualizar(to);
	}
	
	public void excluir(Pais to) {
		dao.excluir(to);
	}
	
	public Pais carregar(int id) {
		Pais to = dao.buscar(id);
		return to;
	}
	
	public Pais retornarMaiorHabitantes() {
		Pais to = dao.retornarMaiorHabitantes();
		return to;
	}
	
	public Pais retornarMenorArea() {
		Pais to = dao.retornarMenorArea();
		return to;
	}
	
	public ArrayList<Pais> retornarTresPaises() {
		try {
			ArrayList<Pais> to = dao.retornarTresPaises();
			return to;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Pais> carregarTodos() throws Exception {
		ArrayList<Pais> to = dao.retornarTodosPaises();
		return to;
	}
	
}
