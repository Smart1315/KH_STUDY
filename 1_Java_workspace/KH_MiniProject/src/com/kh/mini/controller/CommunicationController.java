package com.kh.mini.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import com.kh.mini.model.vo.Communication;
import com.kh.mini.view.Connect;

public class CommunicationController {

	public Communication connect(String command, Object data) {

		Communication result = null;

		Socket socket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			socket = new Socket(Connect.ip, Connect.port);
			if (socket != null) {
				oos = new ObjectOutputStream(socket.getOutputStream());
				Communication c = new Communication(command, data);

				oos.writeObject(c);
				oos.flush();

				ois = new ObjectInputStream(socket.getInputStream());
				result = ((Communication) ois.readObject());
			}

			oos.close();
			ois.close();
			socket.close();
		} catch (ConnectException e) {
			JOptionPane.showMessageDialog(null, "서버 응답없음", "알림", JOptionPane.INFORMATION_MESSAGE);
			result = new Communication("ServerError", null);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
