package com.senac.pdv.modelo;

import java.util.List;

public class Produto {
	
	private Integer id;
	private String nome;
	private Double valor;
	private Integer quantidade;
        private String data;
        private Integer desconto;

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
        
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
        
	public Integer getDesconto() {
		return desconto;
	}
        
        public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

        @Override
	public String toString() {            
		return getId() +
				";" + getNome() +
				";" + getPreco() +
				";" + getQuantidade();
                
	/*	return new StringBuffer()
				.append(String.format("\nCodigo: %s", getId()))
				.append(String.format("\nNome: %s", getNome()))
				.append(String.format("\nValor: %s", getPreco()))
				.append(String.format("\nQuantidade: %s", getQuantidade()))
				.toString();    */
	}

   // public void getId(List<Produto> readForDesc) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
}
