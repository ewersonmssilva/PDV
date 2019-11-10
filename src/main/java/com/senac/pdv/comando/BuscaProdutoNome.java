package com.senac.pdv.comando;

import java.util.Scanner;

import com.senac.pdv.dao.ProdutoDAO;
import com.senac.pdv.modelo.Produto;

public class BuscaProdutoNome implements Comando {
	
        @Override
	public void execute(Scanner scanner) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Digite o nome do produto: ");
		scanner.nextLine();
     	String nome = scanner.nextLine(); 
     	
     	for(Produto prodto : DAO.buscaPorNome(nome)) {
            System.out.println(prodto);
     }
     }
		
}