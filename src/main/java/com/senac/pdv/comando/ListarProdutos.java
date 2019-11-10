package com.senac.pdv.comando;

import com.senac.pdv.dao.ProdutoDAO;
import com.senac.pdv.modelo.Produto;

import java.util.Scanner;

public class ListarProdutos implements Comando {
	
	public void execute(Scanner entrada) {
		ProdutoDAO DAO = new ProdutoDAO();
		
		System.out.println("Lista de produtos:");
		for(Produto prod : DAO.listar()) {
			System.out.println(prod);
		} 
	}
}
