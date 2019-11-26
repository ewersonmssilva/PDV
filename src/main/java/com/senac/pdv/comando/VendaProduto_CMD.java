package com.senac.pdv.comando;

import com.senac.pdv.dao.ProdutoDAO;
import com.senac.pdv.desconto.*;
import com.senac.pdv.imposto.ICMSSP;
import com.senac.pdv.imposto.IPL;
import com.senac.pdv.modelo.Produto;
import com.senac.pdv.modelo.Venda; 

import java.util.Scanner;

/**
 *
 * @author Ewerson
 */
public class VendaProduto_CMD implements Comando {
    
        @Override
	public void execute(Scanner scanner) {
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
                
                int codigo = 1;
		ProdutoDAO DAO = new ProdutoDAO();            
            	Venda venda = new Venda();
                               
                while (codigo != 0) {
                    System.out.println("Digite o codigo do produto ou zero para Terminar: ");
                    scanner.nextLine();     	
                    codigo = scanner.nextInt();
                    
                    if (codigo != 0){
                        System.out.println("Digite a quantidade: ");
                        scanner.nextLine();     	
                        int quantidade = scanner.nextInt();
                    
                        Produto prodGET = DAO.buscaPorCodigo(codigo);

                        Produto prodSET = new Produto();
                        prodSET.setId(prodGET.getId());
                        prodSET.setNome(prodGET.getNome());
                        prodSET.setPreco(prodGET.getPreco()* quantidade);
                        prodSET.setQuantidade(prodGET.getQuantidade());
                        venda.adicionarProduto(prodSET);
                    }             

                }
		venda.setImposto(new ICMSSP());
		venda.setImposto(new IPL());
		venda.setDesconto(d1);
		System.out.println(venda);               
        }   

}

