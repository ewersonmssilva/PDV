package com.senac.pdv.comando;

//import com.senac.pdv.dao.ProdutoDAO;
import com.senac.pdv.desconto.*;
import com.senac.pdv.imposto.ICMSSP;
import com.senac.pdv.imposto.IPL;
import com.senac.pdv.modelo.Produto;
import com.senac.pdv.modelo.Venda; 
import java.util.Scanner;

//import java.util.Scanner;

/**
 *
 * @author Ewerson
 */
public class VendaProduto implements Comando{
    
       // @Override
	public Venda vendaProd(int id, double preco, String desc) {
              	Desconto d1 = new DescontoValorAlto();
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
		p1.setId(id);
		p1.setPreco(preco);
		venda.adicionarProduto(p1);

		venda.setImposto(new ICMSSP());
		venda.setImposto(new IPL());
		venda.setDesconto(d0);
		return venda;            
        }  

    @Override
    public void execute(Scanner entrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

