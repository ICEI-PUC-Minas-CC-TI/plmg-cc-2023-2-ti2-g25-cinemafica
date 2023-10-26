package model;

public class Filme {
  private int ID_Filme;
  private String[] Generos;
  private String Atores;
  private String Titulo;
  private String Classificacao_Indicativa;
  private String Descricao;
  private String Data_Lancamento;

  public Filme() {
    this.ID_Filme = -1;
    this.Generos = new String[19];
    this.Atores = "";
    this.Titulo = "";
    this.Classificacao_Indicativa = "";
    this.Descricao = "";
    this.Data_Lancamento = "";
  }

  public Filme(int ID_Filme, String[] Generos, String Atores, String Titulo, String Classificacao_Indicativa,
      String Descricao, String Data_Lancamento) {
    this.ID_Filme = ID_Filme;
    this.Generos = Generos;
    this.Atores = Atores;
    this.Titulo = Titulo;
    this.Classificacao_Indicativa = Classificacao_Indicativa;
    this.Descricao = Descricao;
    this.Data_Lancamento = Data_Lancamento;
  }

  public int getID_Filme() {
    return ID_Filme;
  }

  public void setID_Filme(int ID_Filme) {
    this.ID_Filme = ID_Filme;
  }

  public String[] getGeneros() {
    return Generos;
  }

  public void setGeneros(String[] Generos) {
    this.Generos = Generos;
  }

  public String getAtores() {
    return Atores;
  }

  public void setAtores(String Atores) {
    this.Atores = Atores;
  }

  public String getTitulo() {
    return Titulo;
  }

  public void setTitulo(String Titulo) {
    this.Titulo = Titulo;
  }

  public String getClassificacao_Indicativa() {
    return Classificacao_Indicativa;
  }

  public void setClassificacao_Indicativa(String Classificacao_Indicativa) {
    this.Classificacao_Indicativa = Classificacao_Indicativa;
  }

  public String getDescricao() {
    return Descricao;
  }

  public void setDescricao(String Descricao) {
    this.Descricao = Descricao;
  }

  public String getData_Lancamento() {
    return Data_Lancamento;
  }

  public void setData_Lancamento(String Data_Lancamento) {
    this.Data_Lancamento = Data_Lancamento;
  }

  @Override

  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }
}