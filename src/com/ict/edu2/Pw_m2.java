package com.ict.edu2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pw_m2 extends JPanel {
	JTextField nam2, quz, id1;
	JButton hwk2, bck, sett;
	JPanel main;
	CardLayout card;
	String[] items2 = { "본인 확인용 QUIZ  (click)", "어릴 적 추억이 담긴 물건 한가지", "내가 사는 곳은?", "가장 좋아하는 음식은?" };
	JComboBox<String> jcom2 = new JComboBox<>(items2);
	ImageIcon bg1 = new ImageIcon("src/image/pw.png");
	Main2 main2;
	JLabel birth, q1, q2, i1;
	String quiz2;

	public Pw_m2(Main2 main2) {
		this.main2 = main2;

		// JLabel img = new JLabel("");
		// img.setIcon(new ImageIcon(Login_m2.class.getResource("bg1.jpg")));

		birth = new JLabel("생년월일(6자리): ");
		q1 = new JLabel("QUIZ: ");
		q2 = new JLabel("QUIZ 답: ");
		i1 = new JLabel("아이디: ");
		id1 = new JTextField();
		id1.setColumns(20);
		nam2 = new JTextField();
		nam2.setColumns(20);
		quz = new JTextField();
		quz.setColumns(20);
		hwk2 = new JButton("확인");
		hwk2.setForeground(Color.BLACK);
		bck = new JButton("◀");
		bck.setForeground(Color.BLACK);
		sett = new JButton("◎");
		sett.setForeground(Color.BLACK);

		hwk2.setBackground(new Color(255, 255, 255));
		bck.setBackground(new Color(255, 255, 255));
		sett.setBackground(new Color(255, 255, 255));

		i1.setLayout(null);
		id1.setLayout(null);
		birth.setLayout(null);
		q1.setLayout(null);
		q2.setLayout(null);
		nam2.setLayout(null);
		jcom2.setLayout(null);
		quz.setLayout(null);
		hwk2.setLayout(null);
		bck.setLayout(null);
		sett.setLayout(null);

		i1.setBounds(170, 280, 300, 20);
		birth.setBounds(170, 310, 300, 20);
		q1.setBounds(170, 340, 300, 20);
		q2.setBounds(170, 380, 300, 20);
		id1.setBounds(270, 280, 300, 20);
		nam2.setBounds(270, 310, 300, 20);
		jcom2.setBounds(270, 340, 300, 20);
		quz.setBounds(270, 380, 300, 20);
		hwk2.setBounds(350, 440, 60, 30);
		bck.setBounds(20, 30, 50, 30);
		sett.setBounds(680, 30, 50, 30);
		// img.setBounds(0, 0, 768, 576);

		add(birth);
		add(q1);
		add(q2);
		add(i1);
		add(id1);
		add(nam2);
		add(jcom2);
		add(quz);
		add(hwk2);
		add(bck);
		add(sett);
		// add(img);

		setLayout(null);

		jcom2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> kkk = (JComboBox<String>) e.getSource();
				String item = (String) kkk.getSelectedItem();
				if (!items2.equals("본인 확인용 QUIZ  (click)")) {
					quiz2 = item;
				}
			}
		});

		hwk2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Protocol p = new Protocol();
				String births = nam2.getText().trim();
				String quiza = quz.getText().trim();
				String idd = id1.getText().trim();
				String quz2 = quiz2;

				if (births.length() == 6 && quiza.length() > 0 && idd.length() > 0) {
					Customer_2VO cvo = new Customer_2VO();
					cvo.setBirth(births);
					cvo.setId(idd);
					cvo.setQuiz_a(quiza);
					cvo.setQuiz(quz2);

					p.setCmd(7);
					p.setVo(cvo);

					try {
						main2.out.writeObject(p);
						main2.out.flush();
					} catch (IOException e1) {
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "id, 생년월일, 퀴즈를 확인하세요");
					id1.setText("");
					nam2.setText("");
					jcom2.setSelectedIndex(0);
					quz.setText("");
				}

			}
		});

		bck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				id1.setText("");
				nam2.setText("");
				jcom2.setSelectedIndex(0);
				quz.setText("");
				main2.card.show(main2.main, "login");

			}
		});
		sett.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((JButton) obj == sett) {
					id1.setText("");
					nam2.setText("");
					jcom2.setSelectedIndex(0);
					quz.setText("");
					// main, card 추가
					new Sett_notLog(main2);
				}

			}
		});
	}

	public void exec(Customer_2VO cvo2) {
		JOptionPane.showMessageDialog(getParent(), "PW: " + cvo2.getPw());
		id1.setText("");
		nam2.setText("");
		jcom2.setSelectedIndex(0);
		quz.setText("");
	}

	public void exec2() {
		JOptionPane.showMessageDialog(getParent(), "id, 생년월일, 퀴즈를 확인하세요");
		id1.setText("");
		nam2.setText("");
		jcom2.setSelectedIndex(0);
		quz.setText("");
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg1.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
