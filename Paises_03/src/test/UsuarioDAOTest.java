package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.UsuarioDAO;
import model.Usuario;

class UsuarioDAOTest {
	UsuarioDAO dao;
	Usuario usuario;
	Usuario novoUsuario;
	
	@BeforeEach
	public void setUp() throws Exception{
		usuario = new Usuario("jhonatan", "jhonatan");
		novoUsuario = new Usuario("jhonatanCosta", "jhonatan");
		dao = new UsuarioDAO();
	}
	
	@Test
	void testValidar() {
		boolean usuarioValidado = dao.validar(usuario);
		assertTrue("Validar Usu�rio", usuarioValidado);
	}

	@Test
	void testCadastrar() {
		try {
			dao.cadastrar(novoUsuario);
			usuario = dao.buscar(novoUsuario);
			
			assertEquals("Verificando a fun��o de cadastrar", novoUsuario, usuario);
			
			dao.excluir(novoUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
