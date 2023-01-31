package main;

import java.awt.Dimension;

import javax.swing.JFrame;

import settings.Chr_Choice;
import settings.Dif_Choice;
import settings.Map_Choice;

public class Frame extends JFrame{
	Map_Choice map;
	Chr_Choice chr;
	public JFrame window;
	Dif_Choice dif;
	
	public Frame(Dif_Choice dif, Chr_Choice chr, Map_Choice map) {
		this.dif=dif;
		this.map=map;
		this.chr=chr;
		
		
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("화면단");
		PanelGame pg = new PanelGame(this);
		
		window.add(pg);
		
		window.pack(); // resizes the JFrame into the size of GamePanel
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}
//	public static void main(String[] args) {
//		new Frame();
//		
//	}

}
