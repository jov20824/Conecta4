package main;

import java.util.Scanner;

import clases.Tablero;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Tablero tablero = new Tablero();
		Scanner teclado = new Scanner(System.in);
		
		while(tablero.isGanador()==false) {
			int donde= (teclado.nextInt());
			tablero.colocar(donde);
			System.out.println(tablero);
		}
		teclado.close();
		
	}

}
