package com.ict.edu2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class CopyClient extends Thread {
	Socket s;

	ObjectInputStream in;
	ObjectOutputStream out;
	// String ip;

	public CopyClient(Socket s, Gm_Server gm_Server) {
		this.s = s;

		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
			// ip = s.getInetAddress().getHostAddress();
		} catch (Exception e) {

		}

	}

	@Override
	public synchronized void run() {
		try {
			bk: while (true) {
				try {
					Object obj = in.readObject();
					if (obj != null) {
						Protocol p = (Protocol) obj;
						switch (p.getCmd()) {
						case 0:
							out.writeObject(p);
							out.flush();

							break bk;
						case 1: // 회원가입
							int result1 = DAO.getIns(p.getVo());
							Protocol p1 = new Protocol();
							p1.setCmd(5);
							if (result1 > 0) {
								p1.setResult(1);
							} else {
								p1.setResult(0);
							}
							try {
								out.writeObject(p1);
								out.flush();
							} catch (Exception e) {
							}
							break;
						case 2: // 내정보수정
							int result2 = DAO.getUp(p.getVo());
							if (result2 > 0) {
								Protocol p2 = new Protocol();
								p2.setCmd(2);
								p2.setResult(result2);

								out.writeObject(p2);
								out.flush();
							}
							break;
						case 3: // 아이디 찾기
							Customer_2VO cvo2 = DAO.getIdChk2(p.getVo());
							Protocol p4 = new Protocol();
							if (cvo2 != null) {
								p4.setCmd(3);
								p4.setVo(cvo2);
								p4.setResult(1);
							} else {
								p4.setCmd(3);
								p4.setResult(0);
							}
							out.writeObject(p4);
							out.flush();
							break;
						case 4: // 불러오기
							Customer_2VO cvo = DAO.getIdChk(p.getVo());
							Protocol p3 = new Protocol();
							p3.setCmd(4);
							p3.setVo(cvo);
							try {
								out.writeObject(p3);
								out.flush();
							} catch (Exception e) {
							}

							break;

						case 6: // 중복체크 
							String idchk = null;
							try {
								idchk = DAO.getCheck(p.getVo().getId());
								
							} catch (Exception e) {
								e.printStackTrace();
							}
							Protocol p7 = new Protocol();
							if (idchk == null) {
								p7.setCmd(6);
								p7.setResult(1);
							} else {
								p7.setCmd(6);
								p7.setResult(0);
							}
							out.writeObject(p7);
							out.flush();

							break;
						case 7: // 패스워드 찾기
							Customer_2VO cvo3 = DAO.getpwchk(p.getVo());
							Protocol p5 = new Protocol();
							if (cvo3 != null) {
								p5.setCmd(7);
								p5.setVo(cvo3);
								p5.setResult(1); // 성공
							} else {
								p5.setCmd(7);
								p5.setResult(0); // 실패
							}
							out.writeObject(p5);
							out.flush();
							break;
						case 8: // 로그인
							Customer_2VO cvo4 = DAO.getLogin(p.getVo());
							Protocol p6 = new Protocol();
							if (cvo4 != null) {
								p6.setCmd(8);
								p6.setVo(cvo4);
								p6.setResult(1);
							} else {
								p6.setCmd(8);
								p6.setResult(0);
							}
							out.writeObject(p6);
							out.flush();
							break;
						}
					}
				} catch (Exception e) {
				}

			}

			//
		} catch (Exception e) {

		}
	}

}
