package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Recomendacao;

public class RecomendacaoDAO extends DAO {

    public RecomendacaoDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }

    public boolean insert(Recomendacao recomendacao) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO recomendacao (ID_Recomendacao, Data_Recomendacao, ID_Usuario, ID_Filme, ID_Resenha)"
                    + "VALUES (" + recomendacao.getID_Recomendacao() + ", '" + recomendacao.getData_Recomendacao()
                    + "', '"
                    + recomendacao.getID_Usuario() + "', '" + recomendacao.getID_Filme() + "', '"
                    + recomendacao.getID_Resenha();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public Recomendacao get(int ID_Recomendacao) {
        Recomendacao recomendacao = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM recomendacao WHERE ID=" + recomendacao;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                recomendacao = new Recomendacao(rs.getInt("ID_Recomendacao"), rs.getString("Data_Recomendacao"),
                        rs.getInt("ID_Usuario"), rs.getInt("ID_Filme"), rs.getInt("ID_Resenha"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return recomendacao;
    }

    public List<Recomendacao> get() {
        return get("");
    }

    public List<Recomendacao> getOrderByID_Recomendacao() {
        return get("ID_Resenha");
    }

    public List<Recomendacao> getOrderByData_Recomendacao() {
        return get("Data_Recomendacao");
    }

    public List<Recomendacao> getOrderByID_Usuario() {
        return get("ID_Usuario");
    }

    public List<Recomendacao> getOrderByID_Filme() {
        return get("ID_Filme");
    }

    public List<Recomendacao> getOrderByID_Resenha() {
        return get("ID_Resenha");
    }

    private List<Recomendacao> get(String orderBy) {

        List<Recomendacao> recomendacoes = new ArrayList<Recomendacao>();

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM recomendacao"
                    + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Recomendacao a = new Recomendacao(rs.getInt("ID_Recomendacao"), rs.getString("Data_Recomendacao"),
                        rs.getInt("ID_Usuario"), rs.getInt("ID_Filme"), rs.getInt("ID_Resenha"));
                recomendacoes.add(a);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return recomendacoes;
    }

    public boolean update(Recomendacao recomendacao) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "UPDATE recomendacao SET ID_Recomendacao = '" + recomendacao.getID_Recomendacao()
                    + "', Data_Recomendacao = '" + recomendacao.getData_Recomendacao() + "', ID_Usuario = '"
                    + recomendacao.getID_Usuario() + "', ID_Filme = '" + recomendacao.getID_Filme()
                    + "', ID_Resenha = '" + recomendacao.getID_Resenha() + "'"
                    + " WHERE ID_Recomendacao = " + recomendacao.getID_Recomendacao();

            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public boolean delete(int ID_Recomendacao) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM recomendacao WHERE ID_Recomendacao = " + ID_Recomendacao;
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
}