package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Pais;

public class PaisDAO {

	public int incluir(Pais to) throws Exception {
		int id = 0;
		String sqlInsert = "INSERT INTO paises(nome, populacao, area) values (?,?,?)";
	
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setLong(2, to.getPopulacao());
			stm.setDouble(3, to.getArea());
			stm.execute();
			
			try(ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()")){
				if (rs.next()) {				
					id = rs.getInt(1);
				}
			}
			catch (SQLException ex) {
				throw new Exception(ex.getMessage());
			}
		} 
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return id;
	}
	
	public void atualizar(Pais to) {
		String sqlUpdate = "UPDATE paises SET nome = ?, populacao = ?, area = ? where id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setLong(2, to.getPopulacao());
			stm.setDouble(3, to.getArea());	
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Pais to) {
		String sqlDelete = "DELETE FROM paises where id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Pais buscar(int id) {
		Pais to = new Pais();
		String sqlSelect = "SELECT id, nome, populacao, area FROM paises WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				}

			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return to;
				
	}
	
	public Pais retornarMaiorHabitantes() {
		Pais to = new Pais();
		String sqlSelect = "Select id, nome, populacao, area FROM paises order by populacao desc limit 1";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				}
				else {
					to.setId(0);
					to.setNome(null);
					to.setPopulacao(0);
					to.setArea(0);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return to;
				
	}
	
	public Pais retornarMenorArea() {
		Pais to = new Pais();
		String sqlSelect = "Select id, nome, populacao, area FROM paises order by area asc limit 1";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				}
				else {
					to.setId(0);
					to.setNome(null);
					to.setPopulacao(0);
					to.setArea(0);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return to;
				
	}
	
	//m�todo que retorna um vetor de 3 pa�ses.

	public ArrayList<Pais> retornarTresPaises() {
		ArrayList<Pais> paises = new ArrayList<Pais>();
		
		for(int i = 0; i < 3; i++) {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do pa�s: "));
			paises.add(buscar(id));
		}
		
		return paises;
	}
}
