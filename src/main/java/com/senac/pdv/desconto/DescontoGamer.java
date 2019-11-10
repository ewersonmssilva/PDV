package com.senac.pdv.desconto;


import com.senac.pdv.modelo.Venda;

public class DescontoGamer extends Desconto {
	
	public double getValor(Venda venda) {
		if(venda.temProduto("Notebook Gamer")) {
			return venda.calcularValorProdutos()*0.25;
		}
		return proximo.getValor(venda);
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
