package com.kh.example.chap01_thread.thread;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		Thread.currentThread().setName("Á¹¸° Thread2");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " ON...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
