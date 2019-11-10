package com.senac.pdv.comando;

import java.util.Scanner;

import com.senac.pdv.dao.ProdutoDAO;
import com.senac.pdv.modelo.Produto;

public class AtualizarProduto implements Comando {
	
	public void execute(Scanner scanner) {
		ProdutoDAO DAO = new ProdutoDAO();
		Produto produto = new Produto();

     	System.out.println("Digite o ID do produto que deseja atualizar: ");
     	scanner.nextLine();
     	produto = DAO.buscaPorCodigo(scanner.nextInt());
     	
     	System.out.println("Digite o novo nome do produto: ");
     	scanner.nextLine();
     	produto.setNome(scanner.nextLine());
     	
 		System.out.println("Digite o novo valor do produto: ");
        scanner.nextLine();
 		produto.setValor(scanner.nextDouble()) ;
                
        System.out.println("Digite o nova quantidade do produto: ");
	 	produto.setQuantidade(scanner.nextInt()) ;
 		
 		DAO.atualizar(produto);
	}

}
