package com.senac.pdv.imposto;

import com.senac.pdv.modelo.Venda;

public abstract class TemplateImposto implements Imposto {
	
	public final double getValor(Venda venda) {
		if (isTaxaMaxima(venda)) {
			return venda.calcularValorProdutos()*taxaMaxima();
		} else {
			return venda.calcularValorProdutos()*taxaNormal();
		}
	}
	
	protected abstract boolean isTaxaMaxima(Venda venda);
	
	protected abstract double taxaMaxima();
	
	protected abstract double taxaNormal(); 
	
}
