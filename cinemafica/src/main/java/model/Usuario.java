package model;

public class Usuario {
    private int id_Usuario;
    private String Email;
    private String Senha;
    private String Data_Nascimento;
    private String Data_Ingresso;
    private int Quantidade_Criticas;
  

    public Usuario() {
        this.id_Usuario = -1;
        this.Email = "";
        this.Senha = "";
        this.Data_Nascimento = "";
        this.Data_Ingresso = "";
        this.Quantidade_Criticas = 0;
    }

    public Usuario(int id_Usuario, String Email, String Senha, String Data_Nascimento, String Data_Ingresso, int Quantidade_Criticas) {
    	this.id_Usuario = id_Usuario;
        this.Email = Email;
        this.Senha = Senha;
        this.Data_Nascimento = Data_Nascimento;
        this.Data_Ingresso = Data_Ingresso;
        this.Quantidade_Criticas = Quantidade_Criticas;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
    	this.id_Usuario = id_Usuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    public String getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(String Data_Nascimento) {
        this.Data_Nascimento = Data_Nascimento;
    }
    public String getData_Ingresso() {
        return Data_Ingresso;
    }

    public void setData_Ingresso(String Data_Ingresso) {
        this.Data_Ingresso = Data_Ingresso;
    }
    public int getQuantidade_Criticas() {
        return Quantidade_Criticas;
    }

    public void setQuantidade_Criticas(int Quantidade_Criticas) {
        this.Quantidade_Criticas = Quantidade_Criticas;
    }
    

    @Override
    public String toString() {
        return "Usuario [=" + id_Usuario + ", Email=" + Email + ", Senha=" + Senha + ", Data_Nascimento=" + Data_Nascimento + ", Data_Ingresso=" + Data_Ingresso + ", Quantidade_Criticas=" + Quantidade_Criticas + "]";
    }
}