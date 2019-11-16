package com.senac.pdv.desconto;


import com.senac.pdv.modelo.Venda;

public class DescontoVendaCasada extends Desconto {

	@Override
	public double getPreco(Venda venda) {
		if (venda.temProduto("Desktop") && venda.temProduto("Monitor")) {
			return venda.calcularValorProdutos()*0.03;
		}
		return proximo.getPreco(venda);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
		
	}

}
