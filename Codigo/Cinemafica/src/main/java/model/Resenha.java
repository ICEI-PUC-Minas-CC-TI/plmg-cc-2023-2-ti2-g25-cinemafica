package model;

public class Resenha {
  private int ID_Resenha;
  private String Conteudo;
  private Boolean Opiniao;
  private String Data;
  private int ID_Usuario;
  private int ID_Filme;

  public Resenha() {
    this.ID_Resenha = -1;
    this.Conteudo = "";
    this.Opiniao = false;
    this.Data = "";
    this.ID_Usuario = -1;
    this.ID_Filme = -1;
  }

  public Resenha(int ID_Resenha, String Conteudo, Boolean Opiniao, String Data, int ID_Usuario, int ID_Filme) {
    this.ID_Resenha = ID_Resenha;
    this.Conteudo = Conteudo;
    this.Opiniao = Opiniao;
    this.Data = Data;
    this.ID_Usuario = ID_Usuario;
    this.ID_Filme = ID_Filme;
  }

  public int getID_Resenha() {
    return ID_Resenha;
  }

  public void setID_Resenha(int ID_Resenha) {
    this.ID_Resenha = ID_Resenha;
  }

  public String getConteudo() {
    return Conteudo;
  }

  public void setConteudo(String Conteudo) {
    this.Conteudo = Conteudo;
  }

  public Boolean getOpiniao() {
    return Opiniao;
  }

  public void setOpiniao(Boolean Opiniao) {
    this.Opiniao = Opiniao;
  }

  public String getData() {
    return Data;
  }

  public void setData(String Data) {
    this.Data = Data;
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

  @Override

  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }
}