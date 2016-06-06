package GUI;

import java.awt.Color;
import java.awt.Graphics;

public class Crte {
	Platno platno;
	int x, y, starX, starY;
	Color color;
	
	public Crte (Platno platno,int x, int y, int starX, int starY,Color color){
		super();
		this.x=x;
		this.y=y;
		this.starX=starX;
		this.starY=starY;
		this.color = color;
	}
//nariše èrte
	public void narisi(Graphics g) {
		g.setColor(color);
		g.drawLine(x, y, starX, starY);
	}

}
