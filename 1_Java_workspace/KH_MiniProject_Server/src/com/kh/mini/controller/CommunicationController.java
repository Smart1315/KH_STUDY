package com.kh.mini.controller;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.kh.mini.model.vo.Board;
import com.kh.mini.model.vo.Comment;
import com.kh.mini.model.vo.Communication;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.StudentScore;
import com.kh.mini.view.Information;

public class CommunicationController {
	private BoardController bc = new BoardController();
	private CommentController cc = new CommentController();
	private MemberController mc = new MemberController();
	private ScoreController sc = new ScoreController();

	public void connectClient(Socket client) {
		try {
			ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			Communication message = (Communication) ois.readObject();

			String command = message.getCommand();
			Object data = message.getData();

			Information.logText.append(command + "\n");
			Information.scroll.getVerticalScrollBar().setValue(Information.scroll.getVerticalScrollBar().getMaximum());

			if (command.equals("readBoard")) {
				if (data == null) {
					message = new Communication("readBoard", bc.readBoard());
				} else {
					message = new Communication("readBoard", bc.readBoard((int) data));
				}
				oos.writeObject(message);
			} else if (command.equals("writeBoard")) {
				bc.writeBoard((Board) data);
			} else if (command.equals("loadBoard")) {
				message = new Communication("loadBoard", (Object) bc.loadBoard());
				oos.writeObject(message);
			} else if (command.equals("searchBoard")) {
				Object[] msg = (Object[]) data;
				message = new Communication("searchBoard", (Object) bc.searchBoard((int) msg[0], (String) msg[1]));
				oos.writeObject(message);
			} else if (command.equals("editBoard")) {
				bc.editBoard((Board) data);
			} else if (command.equals("deleteBoard")) {
				bc.deleteBoard((int) data);
			} else if (command.equals("writeComment")) {
				cc.writeComment((Comment) data);
			} else if (command.equals("readComment")) {
				message = new Communication("readComment", cc.readComment((int) data));
				oos.writeObject(message);
			} else if (command.equals("editComment")) {
				cc.editComment((Comment) data);
			} else if (command.equals("deleteComment")) {
				cc.deleteComment((Comment) data);
			} else if (command.equals("signUp")) {
				message = new Communication("signUp", mc.signUp((Member) data));
				oos.writeObject(message);
			} else if (command.equals("login")) {
				message = new Communication("login", mc.login((Member) data));
				oos.writeObject(message);
			} else if (command.equals("editMember")) {
				message = new Communication("editMember", mc.editMember((Member) data));
				oos.writeObject(message);
			} else if (command.equals("loadStudent")) {
				if (data == null) {
					message = new Communication("loadStudent", (Object) mc.loadStudent());
				} else {
					message = new Communication("loadStudent", mc.loadStudent((Member) data));
				}
				oos.writeObject(message);
			} else if (command.equals("loadStudentInfo")) {
				message = new Communication("loadStudentInfo", mc.loadStudent((Member) data));
				oos.writeObject(message);
			} else if (command.equals("confirmScore")) {
				sc.confirmScore((Member) data);
			} else if (command.equals("loadScore")) {
				message = new Communication("loadScore", (Object) sc.loadScore((Member) data));
				oos.writeObject(message);
			} else if (command.equals("saveScore")) {
				Object[] msg = (Object[]) data;
				message = new Communication("saveScore", sc.saveScore((Member) msg[0], (StudentScore) msg[1]));
				oos.writeObject(message);
			} else if (command.equals("editScore")) {
				Object[] msg = (Object[]) data;
				sc.editScore((Member) msg[0], (ArrayList<StudentScore>) msg[1]);
			}

			oos.flush();
			oos.writeObject(null);
			oos.close();
			ois.close();

			client.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
