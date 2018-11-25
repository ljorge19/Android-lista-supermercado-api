package android.api.model;

public class Produto {

	private String nome;
	private String qtde;
	
	public Produto() {
		super();
	}
	public Produto(String nome, String qtde) {
		super();
		this.nome = nome;
		this.qtde = qtde;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQtde() {
		return qtde;
	}
	public void setQtde(String qtde) {
		this.qtde = qtde;
	}
	@Override
	public String toString() {
		return "Ingrediente [nome=" + nome + ", qtde=" + qtde + "]";
	}
}
