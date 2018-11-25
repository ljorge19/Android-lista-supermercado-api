package android.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Lista {
	
	@Id
    public String id;
	private String nome;
	private List<Produto> ingredientes;
	private String preparo;
	public Lista() {
		super();
	}
	public Lista(String id, String nome, List<Produto> ingredientes, String preparo) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.preparo = preparo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Produto> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Produto> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getPreparo() {
		return preparo;
	}
	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}
	@Override
	public String toString() {
		return "Receita [id=" + id + ", nome=" + nome + ", ingredientes=" + ingredientes + ", preparo=" + preparo + "]";
	}

}
