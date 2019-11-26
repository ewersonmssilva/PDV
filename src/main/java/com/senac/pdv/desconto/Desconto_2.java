package com.senac.pdv.desconto;


import com.senac.pdv.modelo.Venda;

public class Desconto_2 extends Desconto {

	@Override
	public double getPreco(Venda venda) {
		return venda.calcularValorProdutos()*0.02;		
	}
        
        @Override
        public void setProximo(Desconto proximo) {
		//this.proximo =  proximo;
	}
}
