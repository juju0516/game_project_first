package com.ict.edu2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sett_Log extends JFrame implements ActionListener {
	JButton tmain, texit, back;
	JPanel  jp1;
	
	//
	Main2 main2;
	public Sett_Log(Main2 main2) {
		super("환경설정");
		this.main2 = main2;
		ImageIcon bg1 = new ImageIcon("src/image/sett.png");

		jp1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bg1.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		// JLabel img = new JLabel("");
		// img.setIcon(new ImageIcon(Login_m2.class.getResource("bg2.jpg")));

		jp1.setLayout(null);

		tmain = new JButton("main");
		tmain.setForeground(Color.BLACK);
		texit = new JButton("exit");
		texit.setForeground(Color.BLACK);
		back = new JButton("◀◀");

		tmain.setBackground(new Color(255, 255, 255));
		texit.setBackground(new Color(255, 255, 255));
		back.setBackground(new Color(255, 255, 255));

		tmain.setLayout(null);
		texit.setLayout(null);
		back.setLayout(null);

		tmain.setBounds(160, 150, 90, 60);
		texit.setBounds(330, 150, 90, 60);
		back.setBounds(500, 30, 60, 40);

		jp1.add(texit);
		jp1.add(tmain);
		jp1.add(back);

		add(jp1);
		// add(img);

		this.setLocation(1100, 300);
		super.setVisible(true);
		super.setSize(600, 400);
		super.setResizable(false);

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.exit(0);
				setVisible(false);
				dispose();

			}
		});
		texit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		tmain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Login_m2 lm = new Login_m2(card, main);
				setVisible(false);
				dispose();
				//
				main2.card.show(main2.main, "menu");

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
