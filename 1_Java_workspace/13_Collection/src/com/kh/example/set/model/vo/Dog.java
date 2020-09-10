package com.kh.example.set.model.vo;

public class Dog implements Comparable<Dog> {
	/*
	 * - name : String 
	 * - weight : double
	 * 
	 * + Dog() 
	 * + Dog(name : String, weight : String)
	 * 
	 * + getter/setter 
	 * + toString() : String 
	 * ÀÌ¸§(¸ö¹«°Ôkg)
	 */

	private String name;
	private double weight;

	public Dog() {

	}

	public Dog(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return name + "(" + weight + "kg)";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) weight;

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Dog other = (Dog) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(Dog o) {
		return name.compareTo(o.name);
	}
}
