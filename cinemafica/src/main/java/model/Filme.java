package model;

public class Filme {
    private int ID_Filme;
    private String Genero;
    private String Atores;
    private String Titulo;
    private String Classificacao_Indicativa;
    private String Descricao;
    private String Data_Lancamento;
  

    public Filme() {
        this.ID_Filme = -1;
        this.Genero = "";
        this.Atores = "";
        this.Titulo = "";
        this.Classificacao_Indicativa = "";
        this.Descricao = "";
        this.Data_Lancamento = "";
    }

    public Filme(int ID_Filme, String Genero, String Atores, String Titulo, String Classificacao_Indicativa, String Descricao, String Data_Lancamento) {
    	this.ID_Filme = ID_Filme;
        this.Genero =Genero;
        this.Atores = Atores;
        this.Titulo = Titulo;
        this.Classificacao_Indicativa = Classificacao_Indicativa;
        this.Descricao = Descricao;
        this.Data_Lancamento = Data_Lancamento;
    }

    public int getID_Filme() {
		return ID_Filme;
	}
    public void setID_Filme(int iD_Filme) {
		ID_Filme = iD_Filme;
	}
    public String getGenero() {
		return Genero;
	}
    public void setGenero(String genero) {
		Genero = genero;
	}
    
    public String getAtores() {
		return Atores;
	}
    public void setAtores(String atores) {
		Atores = atores;
	}
    public String getTitulo() {
		return Titulo;
	}
    public void setTitulo(String titulo) {
		Titulo = titulo;
	}
    public String getClassificacao_Indicativa() {
		return Classificacao_Indicativa;
	}
    public void setClassificacao_Indicativa(String classificacao_Indicativa) {
		Classificacao_Indicativa = classificacao_Indicativa;
	}
    public String getDescricao() {
		return Descricao;
	}
    public void setDescricao(String descricao) {
		Descricao = descricao;
	}
    public String getData_Lancamento() {
		return Data_Lancamento;
	}
    public void setData_Lancamento(String data_Lancamento) {
		Data_Lancamento = data_Lancamento;
	}
    
    
@Override

    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
}