package com.ict.edu2;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main2 extends JFrame implements Runnable {
	JPanel main;
	CardLayout card;

	ServerSocket ss;
	ArrayList<CopyClient> list;

	Socket s;
	ObjectInputStream in;
	ObjectOutputStream out;

	Customer_2VO cvo = new Customer_2VO();
	Info info;
	Id_m2 id;
	Login_m2 login;
	Pw_m2 pw;
	Sign_m2 sign;
	MainMenu menu;
	
	String nick;

	public Main2() {
		super("2조");
		card = new CardLayout();
		main = new JPanel();
		main.setLayout(card);

		login = new Login_m2(this);
		id = new Id_m2(this);
		pw = new Pw_m2(this);
		sign = new Sign_m2(this);
		info = new Info(this);
		menu = new MainMenu(this);

		main.add("login", login);
		main.add("id", id);
		main.add("pw", pw);
		main.add("sign", sign);
		main.add("info", info);
		main.add("menu", menu);

		add(main);

		connected();

		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width / 2 - 384, ds.height / 2 - 288, 768, 576);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void connected() {
		try {
			s = new Socket("192.168.0.34", 4444);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());

			new Thread(this).start();
		} catch (Exception e) {
		}

	}

	private void closed() {
		try {
			in.close();
			out.close();
			s.close();
			System.exit(0);
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		bk: while (true) {
			try {
				Object obj = in.readObject();
				if (obj != null) {
					Protocol p = (Protocol) obj;
					switch (p.getCmd()) {
					case 0:
						break bk;

					case 2: // 업데이트
						int result2 = p.getResult();
						if (result2 == 0) {
							// 실패 exec3();
							info.exec3(result2);
						} else {
							// 성공 exec4();
							info.exec4(result2);
						}
						break;

					case 3: // 아이디 찾기
						Customer_2VO cvo2 = p.getVo();
						int result5 = p.getResult();
						if (result5 == 1) {
							id.exec(cvo2);
						} else {
							id.exec2();
						}
						break;

					case 4: // 불러오기
						Customer_2VO cvo = p.getVo();
						if (cvo != null) {
							info.exec(cvo);
						} else {
							info.exec2();
						}

						break;
					case 5: // 가입 결과
						int result = p.getResult();
						if (result > 0) {
							JOptionPane.showMessageDialog(getParent(), "가입성공!");
							card.show(main, "login");
						} else {
							JOptionPane.showMessageDialog(getParent(), "가입실패!");
						}
						break;

					case 6: // 중복검사
						int result6 = p.getResult();
						if (result6 == 1) {
							JOptionPane.showMessageDialog(getParent(), "사용 가능한 ID 입니다");
							sign.suc.setEnabled(true);
							sign.j1.setEditable(false);
						} else {
							JOptionPane.showMessageDialog(getParent(), "이미 존재하는 ID입니다");
							sign.exec();
						}
						break;
					case 7: // 패스워드 찾기
						Customer_2VO cvo3 = p.getVo();
						int result4 = p.getResult();
						if (result4 == 1) {
							pw.exec(cvo3);
						} else {
							pw.exec2();
						}
						break;

					case 8: // 로그인
						Customer_2VO cvo4 = p.getVo();
						int result3 = p.getResult();
						if (result3 == 1) {
							
							login.exec();
							nick = cvo4.getNickname();
							menu.exec();
							JOptionPane.showMessageDialog(getParent(), "로그인 성공!");
							card.show(main, "menu");
						} else {
							login.exec2();
							JOptionPane.showMessageDialog(getParent(), "입력 정보를 확인하세요.");
						}
						break;
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("hello world");
		new Main2();
	}
}
