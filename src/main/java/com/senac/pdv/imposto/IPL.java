package com.senac.pdv.imposto;

import com.senac.pdv.modelo.Venda;

public class IPL extends TemplateImposto {
	
	@Override
	protected boolean isTaxaMaxima(Venda venda) {
		// TODO Auto-generated method stub
		return (venda.produtoValorMaior(10000));
	}

	@Override
	protected double taxaMaxima() {
		// TODO Auto-generated method stub
		return 0.25;
	}

	@Override
	protected double taxaNormal() {
		// TODO Auto-generated method stub
		return 0.1;
	}

}
