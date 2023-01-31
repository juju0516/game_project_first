package com.ict.edu2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.*;

public class MainMenu extends JPanel {
	JButton play, sett;
	JLabel niklabel;
	JPanel main;
	CardLayout card;
	// Main2 main2;
	ImageIcon bg1 = new ImageIcon("src/image/menu.png");
	Main2 main2;
	
	public MainMenu(Main2 main2) {
		this.main2 = main2;
		
		Customer_2VO cvo = new  Customer_2VO();
		
		play = new JButton("PLAY");
		play.setForeground(Color.BLACK);
		sett = new JButton("◎");
		sett.setForeground(Color.BLACK);
		
		niklabel = new JLabel();
		niklabel.setLayout(null);
		niklabel.setBounds(295, 100, 200, 90);
		
		Font font = new Font("굴림", Font.BOLD, 15);
		niklabel.setFont(font);
		niklabel.setForeground(new Color(153,102,000));

		play.setBackground(new Color(255, 255, 255));
		sett.setBackground(new Color(255, 255, 255));

		play.setLayout(null);
		sett.setLayout(null);

		play.setBounds(340, 430, 90, 40);
		sett.setBounds(680, 30, 50, 30);


		add(niklabel);
		add(play);
		add(sett);


		setLayout(null);
		

		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Chr_Choice choice = new Chr_Choice();
				String ch = choice.c("");
			}
		});
		sett.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((JButton) obj == sett) {
					//
					new Sett_Log(main2);
				}

			}
		});

	}
	public void exec() {
		niklabel.setText("♥"+main2.nick+"님 환영합니다♥");
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg1.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
