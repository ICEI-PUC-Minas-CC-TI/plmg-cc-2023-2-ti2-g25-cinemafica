package dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
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
            String sql = "INSERT INTO usuario (\"Nome\", \"Email\", \"Senha\", \"Generos\", \"Data_Nascimento\", \"Data_Ingresso\", \"Quantidade_Criticas\")"
                    + "VALUES (?, ?, ?, ?, ?, CURRENT_DATE, ?)";
            
            PreparedStatement st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, usuario.getNome());
            st.setString(2, usuario.getEmail());
            st.setString(3, usuario.getSenha());
            st.setArray(4, conexao.createArrayOf("VARCHAR", usuario.getGeneros()));
            Date dataNascimento = Date.valueOf(usuario.getData_Nascimento());
            st.setDate(5, dataNascimento);
            st.setInt(6, usuario.getQuantidade_Criticas());

            int affectedRows = st.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = st.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    usuario.setID_Usuario(generatedID);
                }
                status = true;
            }

            st.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public Usuario get(int ID_Usuario) {
        Usuario usuario = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM usuario WHERE 'ID_Usuario'=" + ID_Usuario;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Array generosArray = rs.getArray("Generos");
                String[] generos = (String[]) generosArray.getArray();

                usuario = new Usuario(rs.getInt("\"ID_Usuario\""), rs.getString("\"Nome\""), rs.getString("\"Email\""), rs.getString("\"Senha\""),
                        generos, rs.getString("\"Data_Nascimento\""), rs.getString("\"Data_Ingresso\""),
                        rs.getInt("\"Quantidade_Criticas\""));
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return usuario;
    }
	
	public Usuario getEmail(String Email) {
		Usuario usuario = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE \"Email\"='" + Email + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				Array generosArray = rs.getArray("Generos");
	            String[] generos = (String[]) generosArray.getArray();
	            
				usuario = new Usuario(rs.getInt("ID_Usuario"), rs.getString("Nome"), rs.getString("Email"), rs.getString("Senha"),
						generos, rs.getString("Data_Nascimento"), rs.getString("Data_Ingresso"),
						rs.getInt("Quantidade_Criticas"));
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

	public List<Usuario> getOrderByID() {
		return get("ID_Usuario");
	}

	public List<Usuario> getOrderByNome() {
		return get("Nome");
	}

	public List<Usuario> getOrderByEmail() {
		return get("Email");
	}

	public List<Usuario> getOrderBySenha() {
		return get("Senha");
	}

	public List<Usuario> getOrderByGeneros() {
		return get("Generos");
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
	        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        String sql = "SELECT * FROM usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY \"" + orderBy + "\""));
	        System.out.println(sql);
	        ResultSet rs = st.executeQuery(sql);
	        while (rs.next()) {
	            Array generosArray = rs.getArray("Generos");
	            String[] generos = (String[]) generosArray.getArray();
	            Usuario a = new Usuario(rs.getInt("ID_Usuario"), rs.getString("Nome"), rs.getString("Email"), rs.getString("Senha"),
	                    generos, rs.getString("Data_Nascimento"), rs.getString("Data_Ingresso"),
	                    rs.getInt("Quantidade_Criticas"));
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
            String sql = "UPDATE usuario SET \"ID_Usuario\" = '" + usuario.getID_Usuario() + "', \"Nome\" = '" + usuario.getNome() + "', \"Email\" = '"
                    + usuario.getEmail() + "', \"Senha\" = '" + usuario.getSenha() + "', \"Generos\" = '" + String.join(",", usuario.getGeneros())
                    + "', \"Data_Nascimento\" = '"
                    + usuario.getData_Nascimento() + "', \"Data_Ingresso\" = '"
                    + usuario.getData_Ingresso() + "', \"Quantidade_Criticas\" = '"
                    + usuario.getQuantidade_Criticas() + "'"
                    + " WHERE \"ID_Usuario\" = " + usuario.getID_Usuario();

            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

	public boolean delete(int ID_Usuario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM usuario WHERE 'ID_Usuario' = " + ID_Usuario;
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
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM usuario WHERE \"Email\" LIKE '" + email + "' AND \"Senha\" LIKE '" + senha + "'";
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