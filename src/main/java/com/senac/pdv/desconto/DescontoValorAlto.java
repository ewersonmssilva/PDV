package com.senac.pdv.desconto;


import com.senac.pdv.modelo.Venda;

public class DescontoValorAlto extends Desconto {
	
	public double getPreco(Venda venda) {
		if(venda.calcularValorProdutos() > 20) {
			return venda.calcularValorProdutos()*0.2;
		}
		return proximo.getPreco(venda);
	}
	
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
