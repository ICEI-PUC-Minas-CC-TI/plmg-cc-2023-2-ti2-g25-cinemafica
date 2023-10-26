package model;

public class Recomendacao {
  private int ID_Recomendacao;
  private String Data_Recomendacao;
  private int ID_Usuario;
  private int ID_Filme;
  private int ID_Resenha;

  public Recomendacao() {
    this.ID_Recomendacao = -1;
    this.Data_Recomendacao = "";
    this.ID_Usuario = -1;
    this.ID_Filme = -1;
    this.ID_Resenha = -1;
  }

  public Recomendacao(int ID_Recomendacao, String Data_Recomendacao, int ID_Usuario, int ID_Filme, int ID_Resenha) {
    this.ID_Recomendacao = ID_Recomendacao;
    this.Data_Recomendacao = Data_Recomendacao;
    this.ID_Usuario = ID_Usuario;
    this.ID_Filme = ID_Filme;
    this.ID_Resenha = ID_Resenha;
  }

  public int getID_Recomendacao() {
    return ID_Recomendacao;
  }

  public void setID_Recomendacao(int ID_Recomendacao) {
    this.ID_Recomendacao = ID_Recomendacao;
  }

  public String getData_Recomendacao() {
    return Data_Recomendacao;
  }

  public void setData_Recomendacao(String Data_Recomendacao) {
    this.Data_Recomendacao = Data_Recomendacao;
  }

  public int getID_Usuario() {
    return ID_Usuario;
  }

  public void setID_Usuario(int ID_Usuario) {
    this.ID_Usuario = ID_Usuario;
  }

  public int getID_Filme() {
    return ID_Filme;
  }

  public void setID_Filme(int ID_Filme) {
    this.ID_Filme = ID_Filme;
  }

  public int getID_Resenha() {
    return ID_Resenha;
  }

  public void setID_Resenha(int ID_Resenha) {
    this.ID_Resenha = ID_Resenha;
  }

  @Override

  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }
}