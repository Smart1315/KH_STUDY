package com.kh.example.chap01_thread.thread;

public class Thread1 extends Thread {

	@Override
	public void run() {
		setName("������ Thread1");
		for (int i = 0; i < 10; i++) {
			// getName() : ������ �̸� ��ȯ �޼ҵ�
			System.out.println(getName() + " ON...");
			try {
				Thread.sleep(1000); // ������ ���� �޼ҵ� (1000 = 1��)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
