package com.senac.pdv.imposto;


import com.senac.pdv.modelo.Venda;

public class ISJ extends TemplateImposto{
	
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		// TODO Auto-generated method stub
		return (venda.temProduto("Gamer"));
	}

	@Override
	protected double taxaMaxima() {
		// TODO Auto-generated method stub
		return 0.15;
	}

	@Override
	protected double taxaNormal() {
		// TODO Auto-generated method stub
		return 0.03;
	}
}
