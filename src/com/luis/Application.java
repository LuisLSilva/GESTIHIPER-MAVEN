package com.luis;

import java.util.Scanner;

public class Application {

	
	
	public static void main(String[] args) {
		
		Hipermercado hipermercado;
		Validador validador;
	
		/*
		System.out.print("Escolha uma opção:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		System.out.println("");*/
		
		int choice=1;
		
		switch(choice){
			case 1:
				 System.out.println("Escolheu a opção 1");
				 System.out.println(" ");
				 validador = new Validador();	
				 validador.carregarFicheiro();
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
