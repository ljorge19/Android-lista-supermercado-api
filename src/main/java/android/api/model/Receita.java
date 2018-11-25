package android.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Receita {
	
	@Id
    public String id;
	private String nome;
	private List<Ingrediente> ingredientes;
	private String preparo;
	public Receita() {
		super();
	}
	public Receita(String id, String nome, List<Ingrediente> ingredientes, String preparo) {
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
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
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
