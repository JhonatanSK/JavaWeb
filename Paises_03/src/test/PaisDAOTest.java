package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dao.PaisDAO;
import model.Pais;

@TestMethodOrder(OrderAnnotation.class)
class PaisDAOTest {
	Pais mock, pais, pais2;
	PaisDAO dao;
	ArrayList<Pais> paises;
	static int idPaisCriado;
	
	@BeforeEach
	void setUp() throws Exception {
		mock = new Pais(2, "Brazil", 5000, 44.44);
		dao = new PaisDAO();
		pais = new Pais("Germany", 4000, 60.00);
		pais2 = new Pais(1,	"jhonatanJhon",	200, 112.00);
	}

	@Test
	@Order(4)
	void testIncluir() {
		try {
			int id = dao.incluir(pais);
			mock = dao.buscar(id);
			pais.setId(id);
			idPaisCriado = id;
			assertEquals(pais ,mock,"Verificando se a inclusão do país esta funcionando corretamente");

			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test@Order(5)
	void testAtualizar() {
		pais2.setId(idPaisCriado);
		pais2.setArea(pais.getArea());
		pais2.setNome(pais.getNome());
		pais2.setPopulacao(pais.getPopulacao());
		dao.atualizar(pais2);
		
		pais = dao.buscar(pais2.getId());
		
		assertEquals(pais2, pais, "Verificando se a atualização do país esta funcionando corretamente");
	}

	
	@Test
	@Order(6)
	void testExcluir() {
		pais.setId(idPaisCriado);
		dao.excluir(pais);
		
		pais = new Pais();
		
		pais2 = dao.buscar(pais.getId());
		
		assertEquals(pais2, pais, "Verificando se o pais foi deletado com sucesso");
	}
	
	@Test
	@Order(3)
	void testBuscar() {
		pais = dao.buscar(2);
		assertEquals(mock ,pais,"Verificando se o pais buscado esta funcionando corretamente" );
	}

	@Test
	@Order(2)
	void testRetornarMaiorHabitantes() {
		pais2.setId(68);
		pais2.setNome("china");
		pais2.setPopulacao(99999999);
		pais2.setArea(99999.00);
		
		pais = dao.retornarMaiorHabitantes();
		assertEquals(pais2 ,pais,"Verificando o pais com o maior numero de habitantes" );
	}

	@Test
	@Order(1)
	void testRetornarMenorArea() {
		pais2.setId(67);
		pais2.setNome("Australia");
		pais2.setPopulacao(1);
		pais2.setArea(0.00);
		
		pais = dao.retornarMenorArea();
		assertEquals(pais2 ,pais,"Verificando o pais com o maior numero de habitantes" );
	}

	@Test
	@Order(0)
	void testRetornarTresPaises() {
		try {
			paises = dao.retornarTresPaises();
	
			assertEquals(3, paises.size(), "Verificando se o metodo retorna um array de tres paises");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
