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

public class Info extends JPanel {
	JTextField j1;
	JTextField j2;
	JTextField j3;
	JTextField wid;
	JTextField wpw;
	JTextField wsuc;
	JTextField item;
	JButton suc, bck, sett;
	JLabel jl1, jl2, jl3, jwid, jwpw;
	ImageIcon bg1 = new ImageIcon("src/image/info.png");

	Main2 main2;
	String str1, str2;

	public Info(Main2 main2) {
		this.main2 = main2;

		j1 = new JTextField();
		j1.setColumns(20);
		j2 = new JTextField();
		j2.setColumns(20);
		j3 = new JTextField();
		j3.setColumns(20);
		wid = new JTextField();
		wid.setColumns(20);
		wpw = new JTextField();
		wpw.setColumns(20);
		item = new JTextField();
		item.setColumns(20);

		JLabel jwid = new JLabel("id 입력: ");
		JLabel jwpw = new JLabel("pw 입력: ");
		JLabel jl1 = new JLabel("닉네임: ");
		JLabel jl2 = new JLabel("전화번호: ");
		JLabel jl3 = new JLabel("QUIZ 답: ");

		JButton suc = new JButton("수정");
		suc.setForeground(Color.BLACK);
		JButton bck = new JButton("◀");
		bck.setForeground(Color.BLACK);
		JButton sett = new JButton("◎");
		sett.setForeground(Color.BLACK);
		JButton wsuc = new JButton("입력완료");
		wsuc.setForeground(Color.BLACK);

		suc.setBackground(new Color(255, 255, 255));
		bck.setBackground(new Color(255, 255, 255));
		sett.setBackground(new Color(255, 255, 255));
		wsuc.setBackground(new Color(255, 255, 255));

		jwid.setLayout(null);
		jwpw.setLayout(null);
		wid.setLayout(null);
		wpw.setLayout(null);
		wsuc.setLayout(null);

		j1.setLayout(null);
		j2.setLayout(null);
		j3.setLayout(null);
		jl1.setLayout(null);
		jl2.setLayout(null);
		jl3.setLayout(null);
		item.setLayout(null);
		suc.setLayout(null);
		bck.setLayout(null);
		sett.setLayout(null);

		jwid.setBounds(210, 180, 250, 20);
		jwpw.setBounds(210, 210, 250, 20);

		wid.setBounds(270, 180, 250, 20);
		wpw.setBounds(270, 210, 250, 20);
		wsuc.setBounds(320, 240, 90, 40);

		j1.setBounds(270, 310, 250, 20);
		j2.setBounds(270, 340, 250, 20);
		j3.setBounds(270, 400, 250, 20);
		jl1.setBounds(210, 310, 250, 20);
		jl2.setBounds(210, 340, 250, 20);
		jl3.setBounds(210, 400, 250, 20);
		item.setBounds(210, 370, 310, 20);
		suc.setBounds(340, 425, 60, 40);
		bck.setBounds(20, 30, 50, 30);
		sett.setBounds(680, 30, 50, 30);

		add(jwid);
		add(jwpw);
		add(wid);
		add(wpw);
		add(wsuc);
		add(j1);
		add(j2);
		add(j3);
		add(jl1);
		add(jl2);
		add(jl3);
		add(item);
		add(suc);
		add(bck);
		add(sett);

		setLayout(null);

		bck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wid.setText("");
				wpw.setText("");
				j1.setText("");
				j2.setText("");
				item.setText("");
				j3.setText("");
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
		wsuc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Protocol p = new Protocol();
				String id = wid.getText().trim();
				String pw = wpw.getText().trim();

				Customer_2VO cvo = new Customer_2VO();
				if (id.length() > 0 && pw.length() > 0) {
					cvo.setId(id);
					cvo.setPw(pw);
					p.setCmd(4);
					p.setVo(cvo);
					try {
						main2.out.writeObject(p);
						main2.out.flush();
					} catch (Exception e2) {
						System.out.println(e2);
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "ID, PW를 제대로 입력하세요");
					wid.setText("");
					wpw.setText("");
				}

			}
		});
		suc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nick = j1.getText().trim();
				String phone = j2.getText().trim();
				String quiza = j3.getText().trim();

				Customer_2VO cvo = new Customer_2VO();
				cvo.setNickname(nick);
				cvo.setPhone(phone);
				cvo.setQuiz_a(quiza);
				cvo.setId(str1);
				cvo.setPw(str2);
				str1 = null;
				str2 = null;
				Protocol p = new Protocol();
				p.setCmd(2);
				p.setVo(cvo);

				System.out.println(cvo);

				try {
					main2.out.writeObject(p);
					main2.out.flush();
				} catch (Exception e2) {
				}

			}
		});

	}

	// main2 case4에 보낸 정보를 받을 메서드
	public void exec(Customer_2VO cvo) {

		wid.setText("");
		wpw.setText("");
		j1.setText(cvo.getNickname());
		j2.setText(cvo.getPhone());
		item.setText(cvo.getQuiz());
		item.setEnabled(false);
		j3.setText(cvo.getQuiz_a());
		str1 = cvo.getId();
		str2 = cvo.getPw();
	}

	public void exec2() {
		wid.setText("");
		wpw.setText("");
		j1.setText("");
		j2.setText("");
		item.setText("");
		j3.setText("");
		JOptionPane.showMessageDialog(getParent(), "id나 pw가 틀립니다.");
	}

	// case2
	public void exec3(int result2) {
		if (result2 == 0) {
			wid.setText("");
			wpw.setText("");
			j1.setText("");
			j2.setText("");
			item.setText("");
			j3.setText("");
			JOptionPane.showMessageDialog(getParent(), "업데이트 실패");
		}
	}

	public void exec4(int result2) {
		if (result2 == 1) {
			wid.setText("");
			wpw.setText("");
			j1.setText("");
			j2.setText("");
			item.setText("");
			j3.setText("");
			JOptionPane.showMessageDialog(getParent(), "업데이트 성공");
		}
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg1.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
