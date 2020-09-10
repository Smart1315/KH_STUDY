package com.kh.example.chap02_tcp.part02_sendExit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public void startServer() {
		// 1. 서버 포트 번호 정하기
		int port = 8600;

		try {
			// 2. 서버용 소켓 객체 생성 후 포트와 결합
			ServerSocket server = new ServerSocket(port);

			// 3. 클라이언트의 요청을 기다림
			System.out.println("클라이언트의 요청을 기다리고 있습니다.");

			// 4. 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			Socket client = server.accept();

			String clintIP = client.getInetAddress().getHostAddress();
			System.out.println(clintIP + "가 연결을 요청함...");

			// 5. 입출력 스트림 생성
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();

			// 6. 보조 스트림으로 성능 향상
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);

			// 7. 읽고 쓰기
			while (true) {
				String message = br.readLine();
				
				if(!message.equalsIgnoreCase("exit")) {
					System.out.println(clintIP + "가 보낸 메세지 : " + message);
					pw.println("메세지 받기 성공");
					pw.flush();
				} else {
					System.out.println("접속 종료");
					break;
				}
			}
			
			br.close();
			pw.close();
			server.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
