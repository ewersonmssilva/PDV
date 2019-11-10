package com.senac.pdv.imposto;


import com.senac.pdv.modelo.Venda;

public class ICMSSP extends TemplateImposto {

	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		// TODO Auto-generated method stub
		return (venda.calcularValorProdutos() > 3000);
	}

	@Override
	protected double taxaMaxima() {
		// TODO Auto-generated method stub
		return 0.3;
	}

	@Override
	protected double taxaNormal() {
		// TODO Auto-generated method stub
		return 0.2;
	}
}