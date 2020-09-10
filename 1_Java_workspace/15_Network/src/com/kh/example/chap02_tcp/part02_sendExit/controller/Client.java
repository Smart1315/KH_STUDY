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
			// 0. ������ IP�ּ� �� ��Ʈ ��ȣ �˱�
			int port = 8600;
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			// 1. ������ IP�ּҿ� ��Ʈ��ȣ�� �Ű������� Ŭ���̾�Ʈ�� ���� ��ü ����
			Socket socket = new Socket(serverIP, port);

			if (socket != null) {
				// 2. ������ ����� ��Ʈ�� ����
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();

				// 3. ������Ʈ������ ���� ����
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				PrintWriter pw = new PrintWriter(output);

				Scanner sc = new Scanner(System.in);

				do {
					System.out.print("��ȭ �Է� : ");
					String message = sc.nextLine();
					
					// 4. �а� ����
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
