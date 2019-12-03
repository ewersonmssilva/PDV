package com.senac.pdv.desconto;


import com.senac.pdv.modelo.Venda;

public class DescontoGrandeQuantidade extends Desconto {

	public double getPreco(Venda venda) {
		if(venda.quantidadeProdutos() > 5) {
			return venda.calcularValorProdutos()*0.25;
		}
		return proximo.getPreco(venda);
	}
	
	public void setProximo(Desconto proximo) {
		this.proximo =  proximo;
	}
}
