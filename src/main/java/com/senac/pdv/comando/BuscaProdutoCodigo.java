package com.senac.pdv.comando;

import com.senac.pdv.dao.ProdutoDAO;

import java.util.Scanner;


public class BuscaProdutoCodigo implements Comando{
  
	@Override
	public void execute(Scanner scanner) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Digite o código do produto: ");
		scanner.nextLine();     	
            int codigo = scanner.nextInt();
        
            System.out.println(DAO.buscaPorCodigo(codigo));

                
                
     }

}
