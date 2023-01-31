package com.ict.edu2;

import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Line;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login_m2 extends JPanel {
	JButton login, signup, f_id, f_pw, bck, sett, binfo;
	JTextField w_id1, w_pw1;
	JLabel idd, pww;

	Main2 main2;
	ImageIcon bg1 = new ImageIcon("src/image/log.png");

	public Login_m2(Main2 main2) {
		this.main2 = main2;

		login = new JButton("로그인");
		login.setForeground(Color.BLACK);
		signup = new JButton("회원가입");
		signup.setForeground(Color.BLACK);
		f_id = new JButton("ID찾기");
		f_id.setForeground(Color.BLACK);
		f_pw = new JButton("PW찾기");
		f_pw.setForeground(Color.BLACK);
		bck = new JButton("◀");
		bck.setForeground(Color.BLACK);
		sett = new JButton("◎");
		sett.setForeground(Color.BLACK);
		binfo = new JButton("내정보");
		binfo.setForeground(Color.BLACK);

		binfo.setBackground(new Color(255, 255, 255));
		sett.setBackground(new Color(255, 255, 255));
		bck.setBackground(new Color(255, 255, 255));
		login.setBackground(new Color(255, 255, 255));
		signup.setBackground(new Color(255, 255, 255));
		f_id.setBackground(new Color(255, 255, 255));
		f_pw.setBackground(new Color(255, 255, 255));

		idd = new JLabel("id: ");
		pww = new JLabel("pw: ");
		w_id1 = new JTextField();
		w_pw1 = new JTextField();
		w_id1.setColumns(30);
		w_pw1.setColumns(30);

		idd.setLayout(null);
		pww.setLayout(null);
		login.setLayout(null);
		signup.setLayout(null);
		w_id1.setLayout(null);
		w_pw1.setLayout(null);
		bck.setLayout(null);
		sett.setLayout(null);
		binfo.setLayout(null);

		idd.setBounds(270, 280, 170, 20);
		pww.setBounds(270, 320, 170, 20);
		login.setBounds(340, 430, 90, 40);
		signup.setBounds(620, 430, 90, 40);
		w_id1.setBounds(300, 280, 170, 20);
		w_pw1.setBounds(300, 320, 170, 20);
		f_id.setBounds(45, 430, 80, 40);
		f_pw.setBounds(130, 430, 80, 40);
		bck.setBounds(20, 30, 50, 30);
		sett.setBounds(680, 30, 50, 30);
		binfo.setBounds(45, 380, 80, 40);

		// img.setBounds(0, 0, 768, 576);
		add(idd);
		add(pww);
		add(binfo);
		add(login);
		add(signup);
		add(w_id1);
		add(w_pw1);
		add(f_id);
		add(f_pw);
		add(bck);
		add(sett);

		// add(img);
		// add(mcan);

		setLayout(null);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Protocol p = new Protocol();
				String wid = w_id1.getText().trim();
				String wpw = w_pw1.getText().trim();

				Customer_2VO cvo = new Customer_2VO();

				if (wid.length() > 0 && wpw.length() > 0) {
					cvo.setId(wid);
					cvo.setPw(wpw);
					p.setCmd(8);
					p.setVo(cvo);

					try {
						main2.out.writeObject(p);
						main2.out.flush();

					} catch (Exception e2) {
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "로그인 정보를 다시 확인하세요");
					w_id1.setText("");
					w_pw1.setText("");
				}

			}
		});

		bck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		binfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				w_id1.setText("");
                w_pw1.setText("");
				main2.card.show(main2.main, "info");

			}
		});

		f_id.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				w_id1.setText("");
                w_pw1.setText("");
				main2.card.show(main2.main, "id");

			}
		});
		f_pw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				w_id1.setText("");
                w_pw1.setText("");
				main2.card.show(main2.main, "pw");

			}
		});
		signup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				w_id1.setText("");
                w_pw1.setText("");
				main2.card.show(main2.main, "sign");

			}
		});
		sett.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				w_id1.setText("");
                w_pw1.setText("");
				Object obj = e.getSource();
				if ((JButton) obj == sett) {
					//
					new Sett_notLog(main2);
				}
			}
		});

	}

	public void exec() {
		w_id1.setText("");
		w_pw1.setText("");
	}

	public void exec2() {
		w_id1.setText("");
		w_pw1.setText("");
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg1.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
