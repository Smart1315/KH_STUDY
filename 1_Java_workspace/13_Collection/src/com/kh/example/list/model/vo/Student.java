package com.kh.example.list.model.vo;

public class Student implements Comparable<Student> {
	/*
	 * - name : String 
	 * - score : int
	 * 
	 * + Student() 
	 * + Student(name : String, score : int)
	 * 
	 * + getter/setter 
	 * + toString() : String 
	 * 		이름(00점)
	 */

	private String name;
	private int score;

	public Student() {

	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + "(" + score + "점)";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// 객체 자체 비교
		if (this == obj) { // 매개변수로 들어온 객체와 주소값을 비교
			return true;
		}
		if (obj == null) { // equals가 실행되었다는 것은 객체가 생성된 것이기 때문에
			return false;
		}
		if (getClass() != obj.getClass()) { // 클래스 정보 비교
			return false;
		}
		
		// 필드 비교
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (score != other.score) {
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(Student o) {
		// 이름 오름차순
		String otherName = o.name;
		
		int result = name.compareTo(otherName);
		/*
		 *  비교 주체가 비교 대상과 같으면 0 반환,
		 *  비교 주체가 비교 대상보다 크면 1 반환, // 양수
		 *  비교 주체가 비교 대상보다 작으면 -1 반환 // 음수
		 */
		return result;
	}
}
