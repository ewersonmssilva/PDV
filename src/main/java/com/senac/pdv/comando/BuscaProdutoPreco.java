package com.senac.pdv.comando;

import com.senac.pdv.dao.ProdutoDAO;

import java.util.Scanner;


public class BuscaProdutoPreco implements Comando{
	
        @Override
	public void execute (Scanner scanner) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Digite o preço: ");
		scanner.nextLine();
		double preco = scanner.nextDouble();
		
		System.out.println("Deseja pesquisar todos os maiores que " + preco + " ou menores que " + preco + "? \nMaior:true\nMenor:false\n");
		scanner.nextLine();
		boolean opcaoP = scanner.nextBoolean();
		System.out.println(DAO.buscaPreco(preco, opcaoP));
		
	}

}
