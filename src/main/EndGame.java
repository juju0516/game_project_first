package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ict.edu2.Main2;
import com.ict.edu2.MainMenu;

import settings.Chr_Choice;
import settings.Dif_Choice;
import settings.Map_Choice;

public class EndGame extends JFrame {
	JPanel jpl = new JPanel();
	JPanel jpr = new JPanel();
	ImageIcon backPic=new ImageIcon("Images/endScreen.jpg");
	ImageIcon backPicRight=new ImageIcon("Images/endScreen.jpg");
	
	Image backPicScale = backPic.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	Image backPicScale2 = backPicRight.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	ImageIcon scaledBackPic=new ImageIcon(backPicScale);
	ImageIcon scaledBackPic2=new ImageIcon(backPicScale);
	JLabel backG = new JLabel(scaledBackPic);
	JLabel backG3 = new JLabel(scaledBackPic);
	EndGame end = this;
	Frame frame;
	Map_Choice map;
	Chr_Choice chr;
	Dif_Choice dif;

	public EndGame(Dif_Choice dif, Chr_Choice chr, Map_Choice map,Frame frame) {
		 this.frame=frame;
		 jpl = new JPanel();
		 backPic=new ImageIcon("Images/endScreen.jpg");
		 backPicScale = backPic.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		scaledBackPic=new ImageIcon(backPicScale);
		 backG = new JLabel(scaledBackPic);
		 
		 
		 jpr = new JPanel();
		 backPicRight=new ImageIcon("Images/endScreen.jpg");
		 backPicScale2 = backPicRight.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		scaledBackPic2=new ImageIcon(backPicScale2);
		 backG3 = new JLabel(scaledBackPic2);
		
//		ImageIcon buttonPic=new ImageIcon("Images/cheesepuff.png");
//		Image buttonPicscale = buttonPic.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//		ImageIcon scaledbutton=new ImageIcon(buttonPicscale);
//		JLabel buttonScale = new JLabel(scaledbutton);
		
		this.add(jpl,BorderLayout.WEST);
		this.add(jpr,BorderLayout.EAST);
		jpl.add(backG);
		jpr.add(backG3);
		//jp.add(buttonScale);

		jpl.setLayout(new GridBagLayout());
		jpr.setLayout(new GridBagLayout());

//		JButton button = new JButton("Click Me!");
//		button.setIcon(new ImageIcon("Images/dish.png"));
//		jp.add(button, new GridBagConstraints());
		

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false);
		
		backG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 backPic=new ImageIcon("Images/regame.jpg");
				 backPicScale = backPic.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
				 scaledBackPic=new ImageIcon(backPicScale);
				 backG.setIcon(scaledBackPic);
				 repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				 backPic=new ImageIcon("Images/endScreen.jpg");
				 backPicScale = backPic.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
				 scaledBackPic=new ImageIcon(backPicScale);
				 backG.setIcon(scaledBackPic);
				 repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				end.dispose();
				frame.window.dispose();
				System.gc();
				new Chr_Choice();
			}
		});
		
		backG3.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				backPicRight=new ImageIcon("Images/home.jpg");
				 backPicScale2 = backPicRight.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
				scaledBackPic2=new ImageIcon(backPicScale2);
				 backG3.setIcon(scaledBackPic2);
				 repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				backPicRight=new ImageIcon("Images/endScreen.jpg");
				 backPicScale2 = backPicRight.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
				scaledBackPic2=new ImageIcon(backPicScale2);
				 backG3.setIcon(scaledBackPic2);
				 repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frame.window.dispose();
	         	end.dispose();
	         	System.gc();
				new Main2();
			}
		});
		
	}

//	public void draw(Graphics g) {
//		background = new ImageIcon("Images/endScreen.jpg").getImage();
//		g.drawImage(background,0,0,400,400,null);
//	}

//	public static void main(String[] args) {
//		new EndGame();
//	}

}
