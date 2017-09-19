package dto;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Hexagono {
	private int lado;
	private float alto;
	private float ancho;
	private boolean dibujado= false;
	Polygon poly= new Polygon();
	


	public Hexagono (int l,int[] actual,double maxX,double maxY){
		lado = l;
		alto = lado * (float) 1.5;
		ancho = (float)(lado * Math.sqrt(3));
		poly.setFill(Color.BLUE);
		float desplazamiento;
		if (actual[1]%2 != 0) 
			desplazamiento = (ancho/2);
		else 
			desplazamiento = 0;
		poly.getPoints().add((double) ((alto* (actual[1]-1))+(alto/3)));
		poly.getPoints().add((double) (((ancho*actual[0]-1) - (ancho/2))-desplazamiento));
		poly.getPoints().add((double) (alto * (actual[1]-1)));
		poly.getPoints().add((double) ((ancho *actual[0]-1)-desplazamiento));
		poly.getPoints().add((double) ((alto* (actual[1]-1))+(alto/3)));
		poly.getPoints().add((double) (((ancho*actual[0]-1) + (ancho/2))-desplazamiento));
		poly.getPoints().add((double) (alto* (actual[1])));
		poly.getPoints().add((double) (((ancho*actual[0]-1) + (ancho/2))-desplazamiento));
		poly.getPoints().add((double) ((alto* (actual[1]))+(alto/3)));;
		poly.getPoints().add((double) ((ancho *actual[0]-1)-desplazamiento));
		poly.getPoints().add((double) (alto* (actual[1])));
		poly.getPoints().add((double) (((ancho*actual[0]-1) - (ancho/2))-desplazamiento));
		for (int i=0;i<12; i++ ) {
			if (i%2 == 0) {
				if (poly.getPoints().get(i)>maxX) {
					System.out.println("-------------------------------");
					System.out.println(maxX);
					poly.getPoints().set(i,maxX);
					System.out.println(poly.getPoints().get(i));
				}
			}
			else if(poly.getPoints().get(i)>maxY) {
				System.out.println("-------------------------------");
				System.out.println(maxY);
				poly.getPoints().set(i, maxY);
				System.out.println(poly.getPoints().get(i));
			}
				
		}
	}
	public void dibujar (Pane canvas) {
		if (dibujado == false) {
			canvas.getChildren().add(poly);
			dibujado = true;
		}
		else {
			canvas.getChildren().remove(poly);
			dibujado = false;
		}
	}
}
