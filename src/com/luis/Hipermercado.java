package com.luis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Hipermercado {


	public static void main(String[] args) {
		
	BufferedReader fR;
	BufferedWriter fW;	
		
	try {
		fW= new BufferedWriter(new FileWriter("testefile.txt"));
	} catch (IOException e) {
		e.printStackTrace();
	} 	
		
	
	}

}
