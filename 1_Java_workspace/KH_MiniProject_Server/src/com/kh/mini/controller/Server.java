package com.kh.mini.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import com.kh.mini.view.Information;

public class Server extends Thread {
	public static boolean stop = false;

	public static ServerSocket server;
	private CommunicationController cc = new CommunicationController();

	@Override
	public void run() {
		int port = 8600;
		try {
			server = new ServerSocket(port);
			Information.logText.append(InetAddress.getLocalHost().getHostAddress() + "/" + port + "\n");

			while (!stop) {
				Socket client = server.accept();
				Information.logText.append(client.getInetAddress() + " / " + client.getPort() + " / ");
				
				cc.connectClient(client);

			}
		} catch (SocketException e) {
			try {
				server.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
