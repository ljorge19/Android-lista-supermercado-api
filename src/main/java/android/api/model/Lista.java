package android.api.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Lista {
	
	@Id
    public String id;
	private String nome;
	private List<Produto> produtos;
	private String comentario;
	public Lista() {
		super();
	}
	public Lista(String id, String nome, List<Produto> produtos, String comentario) {
		super();
		this.id = id;
		this.nome = nome;
		this.produtos = produtos;
		this.comentario = comentario;
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
	public List<Produto> getprodutos() {
		return produtos;
	}
	public void setprodutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public String getcomentario() {
		return comentario;
	}
	public void setcomentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Receita [id=" + id + ", nome=" + nome + ", produtos=" + produtos + ", comentario=" + comentario + "]";
	}

}
