package GUI;

import java.awt.Color;
import java.awt.Graphics;

public class Krogec {
	Platno platno;
	int x;
	int y;
	int polmer;
	Color color;
	
	
	public Krogec(Platno platno, int x, int y, int polmer,Color color) {
		super();
		this.x = x;
		this.y = y;
		this.polmer = polmer;
		this.platno = platno;
		this.color = color;
	}
	
	public void narisi(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 2*polmer+1, 2*polmer+1);
	}
		
}
