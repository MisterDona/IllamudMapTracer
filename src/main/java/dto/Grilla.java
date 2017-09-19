package dto;

import javafx.scene.layout.Pane;

public class Grilla {
	
	int lado;
	float alto;
	float ancho;
	int b;
	int columna;
	int fila;
	float desplazamiento;
	Hexagono hexa;
	
	// constructor
	public Grilla (int l) {	
		lado = l;
		alto = lado * (float) 1.5;
		ancho = (float)(lado * Math.sqrt(3));
	}

	public void getHexagono(int x, int y, Pane canvas) {
		int actual[]= {0,0};
		fila = (int) ((float) y / alto)+1;
		columna = 0;
		b = (int) ((((float) y / alto) - (int) ((float) y /  alto))*100);
		if (fila % 2 == 0) 
		{
			if (x>(ancho/2)) 
			{
				float newx = x - (ancho/2);
				columna = (int) (newx / (ancho)) + 1;
			}
		} else columna = (int) (x / ancho) + 1;
		
		if (b>33) 
		{
			System.out.println(fila +","+ columna);
		} else {
			checktriangulo(x,y);
		}
		actual[0] = columna;
		actual[1] = fila;
		hexa= new Hexagono(lado,actual,canvas.getWidth(),canvas.getHeight());
		System.out.println(".."+ actual[1] + "," + actual[0]);
		hexa.dibujar(canvas);
	}
	
	private void checktriangulo(int x, int y) {
		if (fila%2 != 0)
			desplazamiento = (ancho/2);
		else desplazamiento = 0;
		
		int y1 = (int) ((alto* (fila-1))+(alto/3));
		int x1 = (int) (((ancho*columna-1) - (ancho/2))-desplazamiento);
		int y2 = (int) (alto * (fila-1));
		int x2 = (int) ((ancho *columna-1)-desplazamiento);
		int y3 = (int) ((alto* (fila-1))+(alto/3));
		int x3 = (int) (((ancho*columna-1) + (ancho/2))-desplazamiento);
		int calculo1= (x1 - x3) * (y2 - y3) - (y1 - y3) * (x2 - x3);
		int calculo2= (x1 - x) * (y2 - y) - (x2 - x) * (y1 - y);
		int calculo3= (x2 - x) * (y3 - y) - (x3 - x) * (y2 - y);
		int calculo4= (x3 - x) * (y1 - y) - (x1 - x) * (y3 - y);
		
		if (calculo1>0 & calculo2>0 & calculo3>0 & calculo4>0) 
		{
			System.out.println(fila + "," + columna);
		} else if (calculo1<0 & calculo2<0 & calculo3<0 & calculo4<0) {
			System.out.println(fila + "," + columna);
		} else {
			if (x<x2) {
				if (fila%2==1) columna--;
				fila = fila-1;
				System.out.println("<<");
			} else if (x>x2) {
				if (fila%2==0) columna++;
				System.out.println(">>");
				fila = fila-1;
			}
			System.out.println(fila + "," + columna);
		}
		
	}
	   
	public void getPuntos (int[] poliy, int[] polix, int[] actual) {
		if (actual[1]%2 != 0) 
			desplazamiento = (ancho/2);
		else 
			desplazamiento = 0;
		poliy[0] = (int) ((alto* (actual[1]-1))+(alto/3));
		polix[0] = (int) (((ancho*actual[0]-1) - (ancho/2))-desplazamiento);
		poliy[1] = (int) (alto * (actual[1]-1));
		polix[1] = (int) ((ancho *actual[0]-1)-desplazamiento);
		poliy[2] = (int) ((alto* (actual[1]-1))+(alto/3));
		polix[2] = (int) (((ancho*actual[0]-1) + (ancho/2))-desplazamiento);
		poliy[3] = (int) (alto* (actual[1]));
		polix[3] = polix[2];
		poliy[4] = (int) ((alto* (actual[1]))+(alto/3));;
		polix[4] = polix[1];
		poliy[5] = (int) (alto* (actual[1]));
		polix[5] = polix[0];   
	}
}
