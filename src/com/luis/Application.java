package com.luis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Application {

	
	
	public static void main(String[] args) {
		
		Hipermercado hipermercado = new Hipermercado();
		Validador validador;
		
		/*
		System.out.print("Escolha uma opção:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		System.out.println("");*/
		
		String strCurrentLine;
		int choice=1;
		
		switch (choice) {
		
			case 1:
				System.out.println("Escolheu a opção 1");
				System.out.println(" ");
	
				try {
					BufferedReader objReader = new BufferedReader(new FileReader("Compras.txt"));
					while ((strCurrentLine = objReader.readLine()) != null) {
						String[] lineSplitter = strCurrentLine.split(" ");
						validador = new Validador();
						validador.validacao(lineSplitter);
	
						// System.out.println(strCurrentLine);
					}
					objReader.close();
	
				} catch (IOException e) {
					e.printStackTrace();
				}
	
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
