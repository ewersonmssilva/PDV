package com.senac.pdv.comando;

import java.util.Scanner;

public class Sair implements Comando {
	
	public void execute(Scanner opcao) {
		System.out.println("Sessão encerrada");
	}

}
