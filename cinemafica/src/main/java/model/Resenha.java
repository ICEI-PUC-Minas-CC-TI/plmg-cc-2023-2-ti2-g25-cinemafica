package model;

public class Resenha {
    private int ID_Resenha;
    private String Conteudo;
    private double Relevancia;
    private String Data;
    private int ID_Usuario;
    private int ID_Filme;

  

    public Resenha() {
        this.ID_Resenha = -1;
        this.Conteudo= "";
        this.Relevancia = -1;
        this.Data = "";
        this.ID_Usuario = -1;
        this.ID_Filme = -1;
    }

    public Resenha(int ID_Resenha, String Conteudo, double Relevancia, String Data, int ID_Usuario, int ID_Filme) {
    	this.ID_Resenha = ID_Resenha;
        this.Conteudo =Conteudo;
        this.Relevancia = Relevancia;
        this.Data = Data;
        this.ID_Usuario = ID_Usuario;
        this.ID_Filme = ID_Filme;
    }

    public int getID_Resenha() {
		return ID_Resenha;
	}
    public void setID_Resenha(int iD_Resenha) {
		ID_Resenha = iD_Resenha;
	}
    public String getConteudo() {
		return Conteudo;
	}
    public void setConteudo(String conteudo) {
		Conteudo = conteudo;
	} 
    public double getRelevancia() {
		return Relevancia;
	}
    public void setRelevancia(double relevancia) {
		Relevancia = relevancia;
	}
    public String getData() {
		return Data;
	}
    public void setData(String data) {
		Data = data;
	}
    public int getID_Usuario() {
		return ID_Usuario;
	}
    public void setID_Usuario(int iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}
    public int getID_Filme() {
		return ID_Filme;
	}
    public void setID_Filme(int iD_Filme) {
		ID_Filme = iD_Filme;
	}
    
@Override

    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
}