package com.senac.pdv;

import com.senac.pdv.comando.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PDVTeste {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Map<Integer, Comando> mapaComandos = getCommandos();
        int opcao = 0;

		do {
            System.out.println("\n Escolha a ação que deseja realizar nos produtos");
            System.out.println("\n 1 - Inserir");
            System.out.println("\n 2 - Atualizar");
            System.out.println("\n 3 - Remover");
            System.out.println("\n 4 - Buscar por nome");
            System.out.println("\n 5 - Buscar por preço");
            System.out.println("\n 6 - Listar os produtos");
            System.out.println("\n 0 - Sair");
            opcao = scanner.nextInt();
            mapaComandos.get(opcao).execute(scanner);

        } while (opcao <= 6);
	}

	private static Map<Integer, Comando> getCommandos() {
        Map<Integer, Comando> comandos = new HashMap<Integer, Comando>();
        comandos.put(0, new Sair());
        comandos.put(1, new CadastrarProduto());
        comandos.put(2, new AtualizarProduto());
        comandos.put(3, new RemoverProduto());
        comandos.put(4, new BuscaProdutoNome());
        comandos.put(5, new BuscaProdutoPreco());
        comandos.put(6, new ListarProdutos());
        return comandos;
    }

}
