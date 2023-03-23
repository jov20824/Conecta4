package clases;

import java.util.Scanner;

public class Tablero {
	
	char[][] tablero;
	int filas;
	int columnas;
	int turno;
	int[] contador;
	boolean ganador;
	
	public Tablero() {
		filas=6;
		columnas=7;
		tablero = new char[filas][columnas];
		turno=0;
		contador = new int[columnas];
		this.rellenarContador();
		ganador=false;
	}

	public void colocar(int donde) {
		char devolver=' ';

		if ((donde>=0)&(donde<=6)) {
			if (turno%2==0) {
				devolver='X';
			}
			if (turno%2!=0) {
				devolver='0';
			}
			if (this.contador[donde]>=0) {
				this.tablero[this.contador[donde]][donde]=devolver;
				this.comprobarGanadorVertical(this.contador[donde], donde);
				this.comprobarGanadorHorizontal(this.contador[donde], donde);
				this.comprobarGanadorDiagonalPrincipal(this.contador[donde], donde);
				this.comprobarGanadorDiagonalSecundaria(this.contador[donde], donde);
				this.turno++;
				this.contador[donde]--;
				if (this.ganador==true) {
					System.out.println("El ganador es "+devolver);
				}
			}
		}		
	}
	
	public void comprobarGanadorVertical(int fila, int columna) {
		
		char mirarChar = tablero[fila][columna];
		int coincidencia1=0;
		
		if (fila<=2) {
			for (int i = fila;i<=fila+3;i++) {
				if (tablero[i][columna]==mirarChar) {
					coincidencia1++;
				}
			}
			if (coincidencia1==4) {
				this.ganador=true;
				
			}
		}
		
		
	}
	
	public void comprobarGanadorHorizontal(int fila, int columna) {
		
		char mirarChar = tablero[fila][columna];
		int coincidencia2=0;
		if (columna>=0) {
			int i =0;
			while (i<this.columnas & coincidencia2<4) {
				
				if (tablero[fila][i]==mirarChar) {
					coincidencia2++;
				}
				else coincidencia2=0;
				
				i++;
			}
			if (coincidencia2==4) this.ganador=true;
		}
	}
	public void comprobarGanadorDiagonalPrincipal(int fila, int columna) {
		char mirarChar = tablero[fila][columna];
		int coincidencia3=0;
		int fila2;
		int columna2;
		if (fila>columna) {
			fila2=fila-columna;
			columna2=0;
		}
		else {
			fila2=0;
			columna2=columna-fila;
		}
		int i=0;
			
			while ((fila2+i)<this.filas & (columna2+i)<this.columnas & coincidencia3<4) {
				if (tablero[fila2+i][columna2+i]==mirarChar) {
					coincidencia3++;
				}
				else coincidencia3=0;
				
				i++;
			}
			if (coincidencia3==4) this.ganador=true;
		}
		
	public void comprobarGanadorDiagonalSecundaria(int fila, int columna) {
		char mirarChar = tablero[fila][columna];
		int coincidencia3=0;
		int fila2=fila;
		int columna2=columna;
		while (columna2>0 & fila2<(this.filas-1) & columna2<this.columnas & fila2>0) {
			fila2++;
			columna2--;
		}
		int i=0;	
		
		while ((fila2-i)>0 & (columna2+i)<this.columnas & coincidencia3<4) {
			if (tablero[fila2-i][columna2+i]==mirarChar) {
				coincidencia3++;
			}
			else coincidencia3=0;
			
			i++;
		}
		if (coincidencia3==4) this.ganador=true;
	}
	
	
	public void rellenarContador() {
		for (int i=0;i<this.contador.length;i++) {
			contador[i]=this.filas-1;
		}
	}
	
	@Override
	public String toString() {
		String devolver="";
		
		for (int i=0;i<filas;i++) {
			for (int j=0;j<columnas;j++) {
				devolver+=tablero[i][j]+" ";
			}
			devolver+="\n";
		}
		for (int i=0;i<columnas;i++) {
			devolver+="- ";
		}
		devolver+="\n";
		for (int i=0;i<columnas;i++) {
			devolver+=i+" ";
		}
		return devolver;
	}


	
	
	public char[][] getTablero() {
		return tablero;
	}

	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int[] getContador() {
		return contador;
	}

	public void setContador(int[] contador) {
		this.contador = contador;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}
	
	
}
