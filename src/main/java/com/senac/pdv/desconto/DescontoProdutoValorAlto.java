package com.senac.pdv.desconto;


import com.senac.pdv.modelo.Venda;

public class DescontoProdutoValorAlto extends Desconto {

	@Override
	public double getPreco(Venda venda) {
		if (venda.produtoValorMaior(100)) {
			return venda.calcularValorProdutos()*0.05;
		}
		return proximo.getPreco(venda);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;		
	}
}
