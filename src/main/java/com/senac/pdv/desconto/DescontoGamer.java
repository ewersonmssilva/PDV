package com.senac.pdv.desconto;


import com.senac.pdv.modelo.Venda;

public class DescontoGamer extends Desconto {
	
        @Override
	public double getPreco(Venda venda) {
		if(venda.temProduto("Notebook Gamer")) {
			return venda.calcularValorProdutos()*0.25;
		}
		return proximo.getPreco(venda);
	}

        @Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
