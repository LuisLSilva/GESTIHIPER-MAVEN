package com.luis;

public class Consulta {

	Hipermercado hipermercado;
	
	public Consulta(Hipermercado hipermercado) {
		super();
		this.hipermercado = hipermercado;
	}

	public void totalComprasMes(){
		
		int quantidadeTotal=0;
		
		    for(int j=1; j<13; j++){
		    	for(int i=0; i<hipermercado.getListCompra().size(); i++){
			    	if(j == hipermercado.getListCompra().get(i).getMes()){
			    		quantidadeTotal+=quantidadeTotal+ hipermercado.getListCompra().get(i).getQuantidade();
			    	}
		    	}
		    	System.out.println("O mês:"+j+" quantidade:"+ quantidadeTotal);
		     	quantidadeTotal = 0;
		    }
	}

	
	public void totalGlobal() {
		
		 double totalMes=0;
		 double totalGlobal=0;
		
		 	for(int j=1; j<13; j++){
		 		for(int i=0; i<hipermercado.getListCompra().size(); i++){
		 			if(j == hipermercado.getListCompra().get(i).getMes()){
		 		         totalMes = hipermercado.getListCompra().get(i).getPreco() * hipermercado.getListCompra().get(i).getQuantidade();
		 			}
		 		}
		 		System.out.println("O mês:"+j+" totalidade do mes:"+ totalMes);
		 		double temp = totalMes;
		        totalMes=0;
		        totalGlobal+=temp;
		 	}
		 	System.out.println("------ TotalGlobal:"+totalGlobal);
	}	
}
