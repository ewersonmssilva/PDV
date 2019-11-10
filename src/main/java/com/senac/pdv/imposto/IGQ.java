package com.senac.pdv.imposto;


import com.senac.pdv.modelo.Venda;

public class IGQ extends TemplateImposto {
		
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		// TODO Auto-generated method stub
		return (venda.quantidadeProdutos() > 5);
	}

	@Override
	protected double taxaMaxima() {
		// TODO Auto-generated method stub
		return 0.2;
	}

	@Override
	protected double taxaNormal() {
		// TODO Auto-generated method stub
		return 0.05;
	}

}
