package com.ict.edu2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sign_m2 extends JPanel {
	JTextField j1, j2, j3, j4, j5, j6, j7;
	String[] items = { "본인 확인용 QUIZ  (click)", "어릴 적 추억이 담긴 물건 한가지", "내가 사는 곳은?", "가장 좋아하는 음식은?" };
	JButton suc, bck, sett, img, chk, re;
	JLabel l1, l2, l3, l4, l5, l6, l7, re_label, quizz;
	JComboBox<String> jcom = new JComboBox<>(items);
	ImageIcon bg1 = new ImageIcon("src/image/signn.png");

	Main2 main2;
	String quiz;

	public Sign_m2(Main2 main2) {
		this.main2 = main2;

		j1 = new JTextField();
		l1 = new JLabel("사용할 ID:");
		j1.setColumns(20);
		j2 = new JTextField();
		l2 = new JLabel("사용할 PW:");
		j2.setColumns(20);
		j3 = new JTextField();
		l3 = new JLabel("이름  입력:");
		j3.setColumns(20);
		j4 = new JTextField();
		l4 = new JLabel("사용할 닉네임:");
		j4.setColumns(20);
		j5 = new JTextField();
		l5 = new JLabel("전화번호:");
		j5.setColumns(20);
		j6 = new JTextField();
		l6 = new JLabel("생년월일(6자리):");
		j6.setColumns(20);
		j7 = new JTextField();
		l7 = new JLabel("QUIZ 답:");
		j7.setColumns(20);
		re_label = new JLabel("♥체크를 누르시면 더 이상 수정할 수 없습니다");
		quizz = new JLabel("QUIZ: ");

		re = new JButton("초기화");
		re.setForeground(Color.BLACK);
		re_label.setForeground(Color.RED);
		suc = new JButton("완료");
		suc.setForeground(Color.BLACK);
		bck = new JButton("◀");
		bck.setForeground(Color.BLACK);
		sett = new JButton("◎");
		sett.setForeground(Color.BLACK);
		img = new JButton("이미지");
		chk = new JButton("체크");
		chk.setForeground(Color.BLACK);

		ImageIcon img1 = new ImageIcon("src/image/sm.png");
		img.setIcon(img1);

		suc.setBackground(new Color(255, 255, 255));
		bck.setBackground(new Color(255, 255, 255));
		sett.setBackground(new Color(255, 255, 255));
		chk.setBackground(new Color(255, 255, 255));
		re.setBackground(new Color(255, 255, 255));

		j1.setLayout(null);
		j2.setLayout(null);
		j3.setLayout(null);
		j4.setLayout(null);
		j5.setLayout(null);
		j6.setLayout(null);
		jcom.setLayout(null);
		j7.setLayout(null);
		l1.setLayout(null);
		l2.setLayout(null);
		l3.setLayout(null);
		l4.setLayout(null);
		l5.setLayout(null);
		l6.setLayout(null);
		l7.setLayout(null);
		suc.setLayout(null);
		bck.setLayout(null);
		sett.setLayout(null);
		img.setLayout(null);
		chk.setLayout(null);
		re.setLayout(null);
		re_label.setLayout(null);
		quizz.setLayout(null);

		re_label.setBounds(120, 210, 250, 20);
		re.setBounds(380, 210, 80, 20);
		j1.setBounds(210, 240, 180, 20);
		j2.setBounds(210, 270, 250, 20);
		j3.setBounds(210, 300, 250, 20);
		j4.setBounds(210, 330, 250, 20);
		j5.setBounds(210, 360, 250, 20);
		j6.setBounds(210, 390, 250, 20);
		quizz.setBounds(110, 420, 340, 20);
		jcom.setBounds(210, 420, 340, 20);
		j7.setBounds(210, 445, 340, 20);
		l1.setBounds(110, 240, 340, 20);
		l2.setBounds(110, 270, 340, 20);
		l3.setBounds(110, 300, 340, 20);
		l4.setBounds(110, 330, 340, 20);
		l5.setBounds(110, 360, 340, 20);
		l6.setBounds(110, 390, 340, 20);
		l7.setBounds(110, 445, 340, 20);
		suc.setBounds(570, 423, 60, 40);
		bck.setBounds(20, 30, 50, 30);
		sett.setBounds(680, 30, 50, 30);
		img.setBounds(480, 220, 150, 170);
		chk.setBounds(400, 240, 60, 20);
		// img.setBounds(0, 0, 768, 576);
		// img2.setBounds(180, 250, 150, 170);

		add(j1);
		add(j2);
		add(j3);
		add(j4);
		add(j5);
		add(j6);
		add(jcom);
		add(j7);
		add(suc);
		add(bck);
		add(sett);
		add(img);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(chk);
		add(re);
		add(re_label);
		add(quizz);
		// add(img);
		// add(img2);

		setLayout(null);

		suc.setEnabled(false);

		re.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				j1.setText("");
				j2.setText("");
				j3.setText("");
				j4.setText("");
				j5.setText("");
				j6.setText("");
				jcom.setSelectedIndex(0);
				j7.setText("");
				j1.setEditable(true);
				suc.setEnabled(false);

			}
		});

		chk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Customer_2VO cvo = new Customer_2VO();
				Protocol p = new Protocol();
				String cid = j1.getText().trim();
				System.out.println(cid);
				if (cid.length() > 0) {

					cvo.setId(cid);
					p.setCmd(6);
					p.setVo(cvo);

					try {
						main2.out.writeObject(p);
						main2.out.flush();
						cvo.setId("");
					} catch (Exception e2) {
						System.out.println(e2);
					}

				} else {
					JOptionPane.showMessageDialog(getParent(), "ID를 입력하세요");
				}
			}
		});

		jcom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JComboBox<String> kkk = (JComboBox<String>) e.getSource();
				String item = (String) kkk.getSelectedItem();
				quiz = item;
			}
		});

		suc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sid = j1.getText().trim();
				String spw = j2.getText().trim();
				String sname = j3.getText().trim();
				String snkname = j4.getText().trim();
				String sphone = j5.getText().trim();
				String sbirth = j6.getText().trim();
				String sans = j7.getText().trim();

				if (sid.length() > 0 && spw.length() > 0 && sname.length() > 0 && snkname.length() > 0
						&& sphone.length() > 0 && sbirth.length() == 6 && sans.length() > 0) {
					Customer_2VO cvo = new Customer_2VO();
					cvo.setId(sid);
					cvo.setPw(spw);
					cvo.setName(snkname);
					cvo.setNickname(snkname);
					cvo.setPhone(sphone);
					cvo.setBirth(sbirth);
					cvo.setQuiz(quiz);
					cvo.setQuiz_a(sans);

					Protocol p = new Protocol();
					p.setCmd(1);
					// p.setCmd(6);
					p.setVo(cvo);
					try {
						main2.out.writeObject(p);
						main2.out.flush();
					} catch (Exception e2) {
						System.out.println(e2);
					}

					// 내용 지우기

					j1.setText("");
					j2.setText("");
					j3.setText("");
					j4.setText("");
					j5.setText("");
					j6.setText("");
					jcom.setSelectedIndex(0);
					j7.setText("");

				} else {
					JOptionPane.showMessageDialog(getParent(), "회원 정보를 정확하게 입력하세요");
					j1.setText("");
					j2.setText("");
					j3.setText("");
					j4.setText("");
					j5.setText("");
					j6.setText("");
					jcom.setSelectedIndex(0);
					j7.setText("");
					j1.setEditable(true);
					suc.setEnabled(false);
				}
			}
		});

		bck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			    j2.setText("");
                j3.setText("");
                j4.setText("");
                j5.setText("");
                j6.setText("");
                jcom.setSelectedIndex(0);
                j7.setText("");
                j1.setEditable(true);
                suc.setEnabled(false);
				main2.card.show(main2.main, "login");

			}
		});
		sett.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((JButton) obj == sett) {
					// main, card 추가
					new Sett_notLog(main2);
				}

			}
		});

	}

	public void exec() {
		j1.setText("");
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg1.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
