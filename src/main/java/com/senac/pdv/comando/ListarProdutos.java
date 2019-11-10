package com.senac.pdv.comando;

import com.senac.pdv.dao.ProdutoDAO;

import java.util.Scanner;

public class ListarProdutos implements Comando {
	
        @Override
	public void execute(Scanner entrada) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Lista de produtos:");
                DAO.listar().forEach((prod) -> {
                    System.out.println(prod);
            }); 
	}
}
