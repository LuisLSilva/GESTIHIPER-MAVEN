package com.luis;

import java.util.Scanner;

public class Application {

	Hipermercado hipermercado;
	static Validador validador;
	
	public static void main(String[] args) {
	
		System.out.print("Escolha uma opção:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		System.out.println("");
		
		switch(choice){
			case 1:
				 System.out.println("Escolheu a opção 1");
				 validador = new Validador();	
				 validador.loadFile();
				 break;
				 
			case 2:
				 System.out.println("Escolheu a opção 2");
				 break;
			
			case 3:
				 System.out.println("Escolheu a opção 3");
				 break;
			
			default:
				 System.out.println("Não escolheu opção nenhuma");
			}
		
	}

}
