package com.kh.example.chap02_tcp.part02_sendExit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public void startClient() {
		try {
			// 0. 서버의 IP주소 및 포트 번호 알기
			int port = 8600;
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			// 1. 서버의 IP주소와 포트번호를 매개변수로 클라이언트용 소켓 객체 생성
			Socket socket = new Socket(serverIP, port);

			if (socket != null) {
				// 2. 서버와 입출력 스트림 오픈
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();

				// 3. 보조스트림으로 성능 개선
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				PrintWriter pw = new PrintWriter(output);

				Scanner sc = new Scanner(System.in);

				do {
					System.out.print("대화 입력 : ");
					String message = sc.nextLine();
					
					// 4. 읽고 쓰기
					pw.println(message);
					pw.flush();
					
					if (message.equalsIgnoreCase("exit")) {
						break;
					}
					
					String serverMsg = br.readLine();
					System.out.println(serverMsg);
				} while (true);

				br.close();
				pw.close();
				sc.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
