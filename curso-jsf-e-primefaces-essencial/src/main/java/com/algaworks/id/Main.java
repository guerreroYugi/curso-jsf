package com.algaworks.id;

public class Main {
	
	public static void main(String []args) {
		
		Pedidos pedidos = new Pedidos();
		//1ª forma de injeção
		RelatorioService relatorioService = new RelatorioService(pedidos);
		
		//2ª forma de injecao
		RelatorioService relatorioService2 = new RelatorioService();
		relatorioService2.setPedidos(pedidos);
	}

}
