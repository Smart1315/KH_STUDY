package com.kh.example.chap06_method.run;

import com.kh.example.chap05_constructor.model.vo.User;
import com.kh.example.chap06_method.controller.MethodController;
import com.kh.example.chap06_method.model.vo.Trainee;

public class Run {

	public static void main(String[] args) {
		MethodController mc = new MethodController();
		mc.method1();

//		System.out.println(mc.method2());
		int result = mc.method2();
		System.out.println(result);

		mc.method3(1, 10);

//		int result2 = mc.method4(2, 20);
//		System.out.println(result2);
		System.out.println(mc.method4(2, 20));

		int[] resultArr = mc.method5(); // 얕은 복사
		System.out.println("Run resultArr : " + resultArr);
		for (int i = 0; i < resultArr.length; i++) {
			System.out.print(resultArr[i] + " ");
		}
		System.out.println();
		
		User resultUser = mc.method6(); // 얕은 복사
		System.out.println("Run resultUser : " + resultUser);
		resultUser.inform();
		
		Trainee tt = new Trainee();
		System.out.println(tt.inform());
		tt.setName("안영재");
		tt.setTime("오후");
		tt.setClassRoom('G');
//		tt.setScore(80.0);
		Trainee.setScore(80.0);
		System.out.println(tt.inform());
	}

}
