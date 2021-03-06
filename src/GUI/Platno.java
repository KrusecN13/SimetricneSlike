package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;



@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseMotionListener, MouseListener , ActionListener {
	List<Krogec> krogci; // zgodovina vseh krogcev
	List<Crte> crte; // zgodovina vseh �rt

	private int sirina; // �irina platna
	private int visina; // vi�ina platna
	private boolean cezX; // mo�ne simetrije
	private boolean cezY;
	private boolean cezS;
	private boolean cezP;
	private int stSim;
	private int x, y, starX, starY; // shranjene koordinate
	private boolean svincnik;
	private Color color;
	private int velikostCopica;

	
	
	public Platno(GlavnoOkno glavno, int sirina, int visina) {
		super();
		this.setBackground(Color.white);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.krogci = new ArrayList<Krogec>();
		this.crte = new ArrayList<Crte>();
		this.visina = visina;
		this.sirina = sirina;
		this.svincnik = false;
		this.color = Color.black;
		this.cezX = false;
		this.cezY = true;
		this.cezS = false;
		this.cezP = false;
		this.stSim = 5;
		this.velikostCopica = 2;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina);
	}

	@Override
	// nari�e krogce ali �rte, odvisno od izbranega risala (�opi� ali svin�nik)
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Krogec k : this.krogci) {
			k.narisi(g);
		}
		for (Crte c : this.crte) {
			c.narisi(g);
		}
		}
		
	

	@Override
	// shrani trenutne koordinate ob kliku
	public void mousePressed(MouseEvent e){
		x=e.getX();
		y=e.getY();
	}
	
	@Override
	// shrani koordinate ob potegu mi�ke 
	public void mouseDragged(MouseEvent e) {
		starX = this.x;
		starY = this.y;
		this.x= e.getX();
		this.y= e.getY();
		narisi();

	}
	
	// shrani vse potrebne parametre
	private void narisi() {
		if (svincnik) {
			List<Vector<Double>> koordinate1 = potrebneKoordinate(x,y);
			List<Vector<Double>> koordinate2 = potrebneKoordinate(starX,starY);
			narisiCrte(x,y,starX,starY,getGraphics());
			int i= koordinate1.size();
			if(i!=0){
				for(int k=0; k<i;k++){
					int x1= koordinate1.get(k).firstElement().intValue();
					int y1= koordinate1.get(k).lastElement().intValue();
					int x2= koordinate2.get(k).firstElement().intValue();
					int y2= koordinate2.get(k).lastElement().intValue();
					narisiCrte(x1,y1,x2,y2,getGraphics());
			}

			}
		}
		else {
		List<Vector<Double>> koordinate = potrebneKoordinate(x,y);
		narisiKrogce(x,y,getGraphics());
		for (Vector<Double> k : koordinate){
			narisiKrogce(k.firstElement().intValue(),k.lastElement().intValue(),getGraphics());
		}
		}
		}
	
	// vrne zrcaljene vektorje
	private List<Vector<Double>> potrebneKoordinate(int x, int y){
		List<Vector<Double>> sezKoor = new ArrayList<Vector<Double>>() ;
		if(cezX){
				Vector<Double> vektor = koordinate(x, y);
				Vector<Double> zrcaljen = new Vector<Double>(2);
				zrcaljen.add(vektor.firstElement());
				zrcaljen.add(- vektor.lastElement());
				sezKoor.add(koordinatePlatno(zrcaljen));
	}
		if(cezY){
			Vector<Double> vektor = koordinate(x, y);
			Vector<Double> zrcaljen = new Vector<Double>(2);
			zrcaljen.add(-vektor.firstElement());
			zrcaljen.add(vektor.lastElement());
			sezKoor.add(koordinatePlatno(zrcaljen));
		}
		if(cezS){
			Vector<Double> vektor = koordinate(x, y);
			Vector<Double> zrcaljen = new Vector<Double>(2);
			zrcaljen.add(-vektor.firstElement());
			zrcaljen.add(-vektor.lastElement());
			sezKoor.add(koordinatePlatno(zrcaljen));
		}
		if(cezP){
			double k = 2*Math.PI/stSim;
			for(int i=1;i<=stSim;i++){
				Vector<Double> vektor = koordinate(x, y);
				Vector<Double> zrcaljen = new Vector<Double>(2);
				zrcaljen.add(Math.cos(k*i)*vektor.firstElement()- Math.sin(k*i)*vektor.lastElement());
				zrcaljen.add(Math.sin(k*i)*vektor.firstElement()+ Math.cos(k*i)*vektor.lastElement());
				sezKoor.add(koordinatePlatno(zrcaljen));
				
			}
		}
		return sezKoor;
	}

	
	//nari�e krogec in ga doda v seznam krogci
	private void narisiKrogce(int x, int y,Graphics g) {
		Krogec k = new Krogec(this, x, y,velikostCopica, color);
		k.narisi(g);
		this.krogci.add(k);
		}
		
	
	//nari�e �rto in jo doda v seznam crte
	private void narisiCrte(int x, int y,int starX, int starY ,Graphics g) {
		Crte c = new Crte(this,x,y,starX,starY,color);
		c.narisi(g);
		this.crte.add(c);
		}
		
	
	

	// pobri�e seznama krogci in crte
	public void pobrisi() {
			this.krogci = new ArrayList<Krogec>();
			this.crte = new ArrayList<Crte>();
			super.repaint();
		
		
	}
	// koordinate platna zapi�e v koordinatnem sistem
	public Vector<Double> koordinate(int x, int y){
		double a = 4*(double)x/sirina - 2;
		double b = 2 - 4*(double)y/visina;
		Vector<Double> koordinati = new Vector<Double>(2);
		koordinati.add(a);
		koordinati.add(b);
		return koordinati;
	}
	// koordinate spremeni nazaj v koordinate platna
	public Vector<Double> koordinatePlatno(Vector<Double> vektor){
		double x = vektor.firstElement();
		double y = vektor.lastElement();
		double a = (x + 2)* sirina/4;
		double b = (2 - y)* visina / 4;
		Vector<Double> koordinati = new Vector<Double>(2);
		koordinati.add(a);
		koordinati.add(b);
		return koordinati;
	}

	
	
	// nastavi �elene parametre za risanje
	public void rdeca(){
		this.color= Color.red;
	}
	public void crna(){
		this.color= Color.black;
	}
	public void modra(){
		this.color= Color.blue;
	}
	public void zelena(){
		this.color= Color.green;
	}
	public void oranzna(){
		this.color= Color.orange;
	}
	public void roza(){
		this.color= Color.magenta;
	}
	public void svincnik(){
		this.svincnik= true;
	}
	public void copic(){
		this.svincnik= false;
	}
	public void cezX(){
		this.cezX= (false==cezX);
		this.cezP=false;
	}
	public void cezY(){
		this.cezY= (false==cezY);
		this.cezP=false;
	}
	public void cezS(){
		this.cezS= (false==cezS);
		this.cezP=false;
	}
	
	public void velikostCopicaPlus(){
		velikostCopica=velikostCopica+1;
	}
	public void velikostCopicaMinus(){
		if (velikostCopica!=1){
		velikostCopica=velikostCopica-1;
		}
	}
	
	public void cezP(){
		this.cezP=(false==cezP);
		this.cezS = false;
		this.cezX= false;
		this.cezY= false;
	}
	
	public void stSim(int i){
		stSim=i;
	}
	
	
	// ustvari BufferedImage iz platna - kar je do sedaj narisano
	public BufferedImage narediSliko(){
		int s = getWidth();
		int v = getHeight();
		BufferedImage bi = new BufferedImage(s,v,BufferedImage.TYPE_INT_RGB);
		Graphics2D g =bi.createGraphics();
		paint(g);
		return bi;

	}
	
	// ustvarjeno sliko shrani kamor uporabnik �eli
	public void shraniSliko() throws IOException{
		BufferedImage bi=narediSliko();
		JFileChooser fileChooser = new JFileChooser();
		 fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		 fileChooser.setSelectedFile(new File("Slika.png"));
		 fileChooser.setFileFilter(new FileNameExtensionFilter("png","png"));
		  
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			String filename = fileChooser.getSelectedFile().toString();
			if(filename.endsWith(".png")){
				  File file = fileChooser.getSelectedFile();
				  ImageIO.write(bi, "png", file);				
			}
			else{
				File file = new File(fileChooser.getSelectedFile()+".png");
				ImageIO.write(bi, "png", file);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

