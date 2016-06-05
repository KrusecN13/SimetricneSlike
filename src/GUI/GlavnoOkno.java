package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GlavnoOkno extends JFrame {
	private Platno platno;
	private int visina;
	private int sirina;


	public GlavnoOkno() throws HeadlessException {
		super();
		this.setTitle("Simetriène Slike");
		sirina=500;
		visina=500;
		
		// Dodamo menu
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		platno = new Platno(this,visina,sirina);
		GridBagConstraints gbc_platno = new GridBagConstraints();
		gbc_platno.gridheight = 10;
		gbc_platno.insets = new Insets(0, 0, 5, 5);
		gbc_platno.gridx = 0;
		gbc_platno.gridy = 0;
		this.getContentPane().add(platno, gbc_platno);
		
		JButton btnRdea = new JButton("");
		btnRdea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.rdeca();
			}
		});
		
		JCheckBox chckbxezSredie = new JCheckBox("\u010Cez sredi\u0161\u010De");
		chckbxezSredie.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxezSredie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
					platno.cezS();
			}
		});
		GridBagConstraints gbc_chckbxezSredie = new GridBagConstraints();
		gbc_chckbxezSredie.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxezSredie.gridx = 2;
		gbc_chckbxezSredie.gridy = 0;
		getContentPane().add(chckbxezSredie, gbc_chckbxezSredie);
		
		JCheckBox chckbxezXOs = new JCheckBox("\u010Cez X os");
		chckbxezXOs.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxezXOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.cezX();
			}
		});
		GridBagConstraints gbc_chckbxezXOs = new GridBagConstraints();
		gbc_chckbxezXOs.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxezXOs.gridx = 3;
		gbc_chckbxezXOs.gridy = 0;
		getContentPane().add(chckbxezXOs, gbc_chckbxezXOs);
		
		JCheckBox chckbxezYOs = new JCheckBox("\u010Cez Y os");
		chckbxezYOs.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxezYOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				platno.cezY();
			}
		});
		GridBagConstraints gbc_chckbxezYOs = new GridBagConstraints();
		gbc_chckbxezYOs.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxezYOs.gridx = 4;
		gbc_chckbxezYOs.gridy = 0;
		getContentPane().add(chckbxezYOs, gbc_chckbxezYOs);
		btnRdea.setBackground(Color.RED);
		GridBagConstraints gbc_btnRdea = new GridBagConstraints();
		gbc_btnRdea.ipady = 10;
		gbc_btnRdea.ipadx = 10;
		gbc_btnRdea.insets = new Insets(0, 0, 5, 5);
		gbc_btnRdea.gridx = 2;
		gbc_btnRdea.gridy = 1;
		getContentPane().add(btnRdea, gbc_btnRdea);
		
		JButton btnModra = new JButton("");
		btnModra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.modra();
			}
		});
		
		JButton btnZelena = new JButton("");
		btnZelena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.zelena();
			}
		});
		btnZelena.setBackground(Color.GREEN);
		GridBagConstraints gbc_btnZelena = new GridBagConstraints();
		gbc_btnZelena.ipady = 10;
		gbc_btnZelena.ipadx = 10;
		gbc_btnZelena.insets = new Insets(0, 0, 5, 5);
		gbc_btnZelena.gridx = 3;
		gbc_btnZelena.gridy = 1;
		getContentPane().add(btnZelena, gbc_btnZelena);
		btnModra.setBackground(Color.BLUE);
		GridBagConstraints gbc_btnModra = new GridBagConstraints();
		gbc_btnModra.ipadx = 10;
		gbc_btnModra.ipady = 10;
		gbc_btnModra.insets = new Insets(0, 0, 5, 5);
		gbc_btnModra.gridx = 4;
		gbc_btnModra.gridy = 1;
		getContentPane().add(btnModra, gbc_btnModra);
		
		JButton btnopi = new JButton("\u010Copi\u010D");
		btnopi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.copic();
			}
		});
		
		JButton btnPobrisi = new JButton("Pobrisi");
		btnPobrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.pobrisi();
			}
		});
		
		JButton btnrna = new JButton("");
		btnrna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.crna();
			}
		});
		btnrna.setBackground(Color.BLACK);
		GridBagConstraints gbc_btnrna = new GridBagConstraints();
		gbc_btnrna.anchor = GridBagConstraints.NORTH;
		gbc_btnrna.ipadx = 10;
		gbc_btnrna.ipady = 10;
		gbc_btnrna.insets = new Insets(0, 0, 5, 5);
		gbc_btnrna.gridx = 2;
		gbc_btnrna.gridy = 2;
		getContentPane().add(btnrna, gbc_btnrna);
		
		JLabel lblNewLabel = new JLabel("Simetrije:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Slikar:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.roza();
			}
		});
		btnNewButton.setBackground(Color.MAGENTA);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.ipady = 10;
		gbc_btnNewButton.ipadx = 10;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 2;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.oranzna();
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.ipady = 10;
		gbc_btnNewButton_1.ipadx = 10;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 2;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		GridBagConstraints gbc_btnPobrisi = new GridBagConstraints();
		gbc_btnPobrisi.fill = GridBagConstraints.BOTH;
		gbc_btnPobrisi.insets = new Insets(0, 0, 5, 5);
		gbc_btnPobrisi.gridx = 2;
		gbc_btnPobrisi.gridy = 6;
		getContentPane().add(btnPobrisi, gbc_btnPobrisi);
		
		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.velikostCopicaMinus();
			}
		});
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {platno.velikostCopicaPlus();
			}
		});
		
		JButton btnShrani = new JButton("Shrani");
		btnShrani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					platno.shraniSliko();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnShrani = new GridBagConstraints();
		gbc_btnShrani.fill = GridBagConstraints.BOTH;
		gbc_btnShrani.insets = new Insets(0, 0, 5, 5);
		gbc_btnShrani.gridx = 3;
		gbc_btnShrani.gridy = 6;
		getContentPane().add(btnShrani, gbc_btnShrani);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 3;
		getContentPane().add(button, gbc_button);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 3;
		getContentPane().add(button_1, gbc_button_1);
		GridBagConstraints gbc_btnopi = new GridBagConstraints();
		gbc_btnopi.insets = new Insets(0, 0, 5, 5);
		gbc_btnopi.gridx = 2;
		gbc_btnopi.gridy = 3;
		getContentPane().add(btnopi, gbc_btnopi);
		
		JButton btnSvinnik = new JButton("Svin\u010Dnik");
		btnSvinnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {platno.svincnik();
			}
		});
		GridBagConstraints gbc_btnSvinnik = new GridBagConstraints();
		gbc_btnSvinnik.insets = new Insets(0, 0, 5, 5);
		gbc_btnSvinnik.gridx = 2;
		gbc_btnSvinnik.gridy = 4;
		getContentPane().add(btnSvinnik, gbc_btnSvinnik);
		
		TextField textField = new TextField("500");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 7;
		getContentPane().add(textField, gbc_textField);
		
		TextField textField_1 = new TextField("500");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 8;
		getContentPane().add(textField_1, gbc_textField_1);
		
		JButton btnNovaSlika = new JButton("Novo Platno");
		btnNovaSlika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxezSredie.setSelected(false);
				chckbxezXOs.setSelected(false);
				chckbxezYOs.setSelected(false);
				noviParametri(textField,textField_1);
			novoPlatno();
			}
		});
		
		GridBagConstraints gbc_btnNovaSlika = new GridBagConstraints();
		gbc_btnNovaSlika.fill = GridBagConstraints.BOTH;
		gbc_btnNovaSlika.gridheight = 2;
		gbc_btnNovaSlika.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovaSlika.gridx = 4;
		gbc_btnNovaSlika.gridy = 7;
		getContentPane().add(btnNovaSlika, gbc_btnNovaSlika);
		
		JLabel lblSirina = new JLabel("Sirina");
		GridBagConstraints gbc_lblSirina = new GridBagConstraints();
		gbc_lblSirina.anchor = GridBagConstraints.NORTH;
		gbc_lblSirina.insets = new Insets(0, 0, 5, 5);
		gbc_lblSirina.gridx = 2;
		gbc_lblSirina.gridy = 7;
		getContentPane().add(lblSirina, gbc_lblSirina);
		

		
		JLabel lblViina = new JLabel("Vi\u0161ina");
		GridBagConstraints gbc_lblViina = new GridBagConstraints();
		gbc_lblViina.anchor = GridBagConstraints.NORTH;
		gbc_lblViina.insets = new Insets(0, 0, 5, 5);
		gbc_lblViina.gridx = 2;
		gbc_lblViina.gridy = 8;
		getContentPane().add(lblViina, gbc_lblViina);
		
		JLabel lblPlatno = new JLabel("Platno:");
		GridBagConstraints gbc_lblPlatno = new GridBagConstraints();
		gbc_lblPlatno.anchor = GridBagConstraints.EAST;
		gbc_lblPlatno.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlatno.gridx = 1;
		gbc_lblPlatno.gridy = 6;
		getContentPane().add(lblPlatno, gbc_lblPlatno);
		
		chckbxezYOs.setSelected(true);
	}

	public void novoPlatno(){
		platno.setVisible(false);
		platno = new Platno(this,visina,sirina);
		GridBagConstraints gbc_platno = new GridBagConstraints();
		gbc_platno.insets = new Insets(0, 0, 0, 5);
		gbc_platno.gridx = 0;
		gbc_platno.gridheight = 19;
		gbc_platno.gridy = 0;
		this.getContentPane().add(platno, gbc_platno);
	}
	public void noviParametri(TextField textField1,TextField textField2){
		String myString1 = textField1.getText();
		String myString2 = textField2.getText();
		try {
			sirina = Integer.parseInt(myString2);
		    visina = Integer.parseInt(myString1);
		}
		catch (NumberFormatException e) {
		}
	}

}

