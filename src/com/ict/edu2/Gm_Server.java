package com.ict.edu2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Gm_Server {
	ServerSocket ss;

	public Gm_Server() {
		try {
			ss = new ServerSocket(4444);
			System.out.println("서버 시작");
			exec();
		} catch (Exception e) {
		}

	}

	private void exec() {
		while (true) {
			try {
				Socket s = ss.accept();
				CopyClient cc = new CopyClient(s, this);
				cc.start();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new Gm_Server();
	}
}
