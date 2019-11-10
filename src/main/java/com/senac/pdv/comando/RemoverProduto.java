package com.senac.pdv.comando;

import com.senac.pdv.dao.ProdutoDAO;

import java.util.Scanner;


public class RemoverProduto implements Comando {
	
        @Override
	public void execute (Scanner scanner) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Digite o ID do produto que deseja remover: ");   	  		
 		DAO.remover(scanner.nextInt());
	}

}
