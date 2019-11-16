package com.senac.pdv;


import com.senac.pdv.desconto.*;
import com.senac.pdv.imposto.ICMSSP;
import com.senac.pdv.imposto.IPL;
import com.senac.pdv.modelo.Produto;
import com.senac.pdv.modelo.Venda;

public class PDV {

	public static void main(String[] args) {
		Desconto d1 = new DescontoGamer();
		Desconto d2 = new DescontoValorAlto();
		Desconto d3 = new DescontoGrandeQuantidade();
		Desconto d4 = new DescontoProdutoValorAlto();
		Desconto d5 = new DescontoVendaCasada();
		Desconto d0 = new SemDesconto();
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		d4.setProximo(d5);
		d5.setProximo(d0);
		
		Venda venda = new Venda();
                

		Produto p1 = new Produto();
		p1.setNome("Desktop");
		p1.setPreco(3100.00);
		venda.adicionarProduto(p1);

		Produto p2 = new Produto();
		p2.setNome("Monitor");
		p2.setPreco(800.00);

		venda.adicionarProduto(p2);
		venda.setImposto(new ICMSSP());
		venda.setImposto(new IPL());
		venda.setDesconto(d1);
		System.out.println(venda);
	}

}
