package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;


public class UsuarioDAO extends DAO {
	
	public UsuarioDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Usuario usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO usuario (id_Usuario, Email, Senha, Data_Nascimento, Data_Ingresso, Quantidade_Criticas)"
				       + "VALUES ("+usuario.getId_Usuario()+ ", '" + usuario.getEmail() + "', '"  
				       + usuario.getSenha() + "', '"  + usuario.getData_Nascimento() + "', '"  
						       + usuario.getData_Ingresso() + "', '"  
								       + usuario.getQuantidade_Criticas();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Usuario get(int Id_Usuario) {
		Usuario usuario = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + usuario;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 usuario = new Usuario(rs.getInt("Id_Usuario"), rs.getString("Email"), rs.getString("Senha"), rs.getString("Data_Nascimento"), rs.getString("Data_Ingresso"), rs.getInt("Quantidade_Criticas"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuario;
	}
	
	
	public List<Usuario> get() {
		return get("");
	}

	
	public List<Usuario> getOrderById() {
		return get("Id_Usuario");		
	}
	
	
	public List<Usuario> getOrderByEmail() {
		return get("Email");		
	}
	
	
	public List<Usuario> getOrderBySenha() {
		return get("Senha");
	}
	public List<Usuario> getOrderByDataNascimento() {
		return get("Data_Nascimento");
		
	}
	public List<Usuario> getOrderByDataIngresso() {
		return get("Data_Ingresso");
	}
	public List<Usuario> getOrderByQuantidadeCriticas() {
		return get("Quantidade_Criticas");
	}
	
	private List<Usuario> get(String orderBy) {	
	
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Usuario a = new Usuario(rs.getInt("Id_Usuario"), rs.getString("Email"), rs.getString("Senha"), rs.getString("Data_Nascimento"), rs.getString("Data_Ingresso"), rs.getInt("Quantidade_Criticas"));
	            usuarios.add(a);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}

	
	public boolean update(Usuario usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuario SET id_Usuario = '" + usuario.getId_Usuario() + "', email = '"  
				       + usuario.getEmail() + "', Senha = '" +usuario.getSenha() + "', Data_Nascimento = '"  
						       + usuario.getData_Nascimento() + "', Data_Ingresso = '"  
								       + usuario.getData_Ingresso() + "', Quantidade_Criticas = '"  
										       + usuario.getQuantidade_Criticas() +  "'"
					   + " WHERE id_Usuario = " +usuario.getId_Usuario();
			
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id_Usuario) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM usuario WHERE id_Usuario = " + id_Usuario;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean autenticar(String email, String senha) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE login LIKE '" + email + "' AND senha LIKE '" + senha  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}
}