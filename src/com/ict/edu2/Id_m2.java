package com.ict.edu2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Id_m2 extends JPanel {
	JTextField nam, phn;
	JButton hwk, bck, sett, datadel, dataset;
	Main2 main2;
	ImageIcon bg1 = new ImageIcon("src/image/id.png");
	JLabel name, pone;

	public Id_m2(Main2 main2) {
		this.main2 = main2;

		// JLabel img = new JLabel("");
		// img.setIcon(new ImageIcon(Login_m2.class.getResource("bg1.jpg")));

		name = new JLabel("이름:");
		pone = new JLabel("전화번호: ");

		nam = new JTextField();
		nam.setColumns(20);
		phn = new JTextField();
		phn.setColumns(20);
		hwk = new JButton("확인");
		hwk.setForeground(Color.BLACK);
		bck = new JButton("◀");
		bck.setForeground(Color.BLACK);
		sett = new JButton("◎");
		sett.setForeground(Color.BLACK);
		datadel = new JButton("계정삭제");
		datadel.setForeground(Color.BLACK);
		dataset = new JButton("회원수정");
		dataset.setForeground(Color.BLACK);

		hwk.setBackground(new Color(255, 255, 255));
		bck.setBackground(new Color(255, 255, 255));
		sett.setBackground(new Color(255, 255, 255));

		nam.setLayout(null);
		phn.setLayout(null);
		hwk.setLayout(null);
		bck.setLayout(null);
		sett.setLayout(null);
		name.setLayout(null);
		pone.setLayout(null);

		nam.setBounds(250, 300, 300, 20);
		phn.setBounds(250, 340, 300, 20);
		name.setBounds(180, 300, 300, 20);
		pone.setBounds(180, 340, 300, 20);
		hwk.setBounds(345, 440, 60, 30);
		bck.setBounds(20, 30, 50, 30);
		sett.setBounds(680, 30, 50, 30);

		// img.setBounds(0, 0, 768, 576);

		add(nam);
		add(phn);
		add(name);
		add(pone);
		add(hwk);
		add(bck);
		add(sett);
		// add(img);

		setLayout(null);

		hwk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Protocol p = new Protocol();
				String name = nam.getText().trim();
				String phone = phn.getText().trim();

				if (name.length() > 0 && phone.length() > 0) {
					Customer_2VO cvo = new Customer_2VO();
					cvo.setName(name);
					cvo.setPhone(phone);
					p.setCmd(3);
					p.setVo(cvo);

					try {
						main2.out.writeObject(p);
						main2.out.flush();
					} catch (Exception e2) {
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "잘못입력하셨습니다.");
					nam.setText("");
					phn.setText("");
				}

			}
		});

		bck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nam.setText("");
				phn.setText("");
				main2.card.show(main2.main, "login");

			}
		});
		sett.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((JButton) obj == sett) {
					nam.setText("");
					phn.setText("");
					// 메인, 카드 -> sett_m2 의 tmain버튼에
					// card.show(main, "menu") 를 넣기 위해
					// main, card 추가
					new Sett_notLog(main2);
				}

			}
		});

	}

	public void exec(Customer_2VO cvo2) {
		JOptionPane.showMessageDialog(getParent(), "ID: " + cvo2.getId());
		nam.setText("");
		phn.setText("");
	}

	public void exec2() {
		JOptionPane.showMessageDialog(getParent(), "이름과 전화번호를 확인하세요");
		nam.setText("");
		phn.setText("");
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg1.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
