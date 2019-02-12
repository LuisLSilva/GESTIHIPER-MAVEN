package com.luis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Validador {
	
	String strCurrentLine;
	
	public Validador(){
		super();
	}
	
	public void loadFile(){
		try {
			BufferedReader objReader = new BufferedReader(new FileReader("Compras.txt"));
			 
			while ((strCurrentLine = objReader.readLine()) != null) {
				String[] lineSplitter = strCurrentLine.split(" ");
		
				List<String> listaClientes = new ArrayList<String>();
				List<String> listaPrecos = new ArrayList<String>();
				List<String> listaQuantidade = new ArrayList<String>();
				List<String> listaTipo = new ArrayList<String>();
				List<String> listaProduto = new ArrayList<String>();
				List<String> listaMes = new ArrayList<String>();
				
				for(int i=0; i<4; i++){
					System.out.print(lineSplitter[i]+ "\t");
					listaClientes.add(lineSplitter[0]);		
					listaPrecos.add(lineSplitter[1]);
					listaQuantidade.add(lineSplitter[2]);
					listaTipo.add(lineSplitter[3]);
					listaProduto.add(lineSplitter[4]);
					listaMes.add(lineSplitter[5]);	
				}
		 //		System.out.println("A lista de clientes: "+listaClientes.get(0));
		 //   	System.out.println(strCurrentLine);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void validation(){
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
