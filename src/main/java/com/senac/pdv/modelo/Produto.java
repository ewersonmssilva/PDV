package com.senac.pdv.modelo;

public class Produto {
	
	private Integer id;
	private String nome;
	private Double valor;
	private Integer quantidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return valor;
	}

	public void setPreco(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String toString() {
		return new StringBuffer()
				.append(String.format("\nCodigo: %s", getId()))
				.append(String.format("\nNome: %s", getNome()))
				.append(String.format("\nValor: %s", getPreco()))
				.append(String.format("\nQuantidade: %s", getQuantidade()))
				.toString();
	}
}
