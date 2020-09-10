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
	 * 		�̸�(00��)
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
		return name + "(" + score + "��)";
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
		// ��ü ��ü ��
		if (this == obj) { // �Ű������� ���� ��ü�� �ּҰ��� ��
			return true;
		}
		if (obj == null) { // equals�� ����Ǿ��ٴ� ���� ��ü�� ������ ���̱� ������
			return false;
		}
		if (getClass() != obj.getClass()) { // Ŭ���� ���� ��
			return false;
		}
		
		// �ʵ� ��
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
		// �̸� ��������
		String otherName = o.name;
		
		int result = name.compareTo(otherName);
		/*
		 *  �� ��ü�� �� ���� ������ 0 ��ȯ,
		 *  �� ��ü�� �� ��󺸴� ũ�� 1 ��ȯ, // ���
		 *  �� ��ü�� �� ��󺸴� ������ -1 ��ȯ // ����
		 */
		return result;
	}
}
