package com.kh.example.chap02_tcp.part01_sendMsg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public void clientStart() {
		// 클라이언트 용 TCP소켓 프로그래밍 순서
		// 1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
		// 2. 서버와의 입출력 스트림 생성
		// 3. 보조 스트림을 통해 성능 개선
		// 4. 스트림을 통해 읽고 쓰기
		// 5. 통신 종료

		try {
			// 0. 서버의 IP주소와 서버가 정한 포트번호를 먼저 알아야 함
			int port = 8500;
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			// 1. 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
			Socket socket = new Socket(serverIP, port);
			if (socket != null) { // 서버와의 연결이 성공한 경우
				// 2. 서버와의 입출력 스트림 생성
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				// 3. 보조 스트림을 통해 성능 개선
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				PrintWriter pw = new PrintWriter(output);
				// 4. 스트림을 통해 읽고 쓰기
				// 클라이언트가 -> 서버 메세지 전송 
				pw.println("반가워요");
				pw.flush();
				
				// 서버 -> 클라이언트 메세지 읽기
				System.out.println(br.readLine());
				// 5. 통신 종료
				pw.close();
				br.close();
				socket.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
