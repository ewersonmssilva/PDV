package com.senac.pdv.modelo;

import com.senac.pdv.desconto.Desconto;
import com.senac.pdv.imposto.Imposto;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private List<Produto> produtos;
	private Imposto imposto;
	private Desconto desconto;
	
	public Venda() {
		produtos = new ArrayList<>();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Desconto getDesconto() {
		return desconto;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public double calcularValorProdutos() {
		return produtos.stream()
				.map(Produto::getPreco)
				.reduce(0.0, Double::sum);
	}
	
	public double calcularImposto() {
		return imposto.getPreco(this);
	}
	
	public double calcularDesconto() {
		return desconto.getPreco(this);
	}
	
	public double calcularValorTotal() {
		return calcularValorProdutos() + calcularImposto() - calcularDesconto();
	}
	
	public int quantidadeProdutos() {
		return produtos.size();
	}
	
	public boolean temProduto(String nome) {
		for (Produto produto : produtos) {
			if(produto.getNome().contains(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean produtoValorMaior(double valor) {
		for (Produto produto : produtos) {
			if(produto.getPreco() > valor) {
				return true;
			}
		}
		return false;
	}
	
        @Override
	public String toString() {
            return calcularValorProdutos() +
                                ";" + calcularImposto() +
				";" + calcularDesconto() +
				";" + calcularValorTotal();            
            
            
                     
            //return calcularImposto + calcularValorProdutos;          
            /*
		return "Valor dos produtos: " + calcularValorProdutos() +
				"\nValor do imposto: " + calcularImposto() +
				"\nValor do desconto: " + calcularDesconto() +
				"\nValor total: " + calcularValorTotal();
            */
	}

}









