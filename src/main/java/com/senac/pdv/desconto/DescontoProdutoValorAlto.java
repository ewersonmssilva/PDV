package com.senac.pdv.desconto;


import com.senac.pdv.modelo.Venda;

public class DescontoProdutoValorAlto extends Desconto {

	@Override
	public double getValor(Venda venda) {
		if (venda.produtoValorMaior(3000)) {
			return venda.calcularValorProdutos()*0.05;
		}
		return proximo.getValor(venda);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
		
	}

}
