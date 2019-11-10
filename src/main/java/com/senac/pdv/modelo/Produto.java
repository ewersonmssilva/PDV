package com.senac.pdv.modelo;

public class Produto {
	
	private Long id;
	private String nome;
	private Double valor;
	private Integer quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
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
				.append(String.format("\nValor: %s", getValor()))
				.append(String.format("\nQuantidade: %s", getQuantidade()))
				.toString();
	}
}
