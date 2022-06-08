package javaOOPAccess;

public class Human {
	
	// 접근지정자 지정 안해줬을 때 기본적으로 private로 지정됨
	
	private int number;
	private String name;
	private double height;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	
	/*
	 * private : 개인적인
	 * public : 대중적인
	 * 
	 * variable : private -> java, c++
	 * method : public
	 * 
	 * python, kotlin -> default가 public!
	 */

	// 메소드는 public이 기본 접근지정자
}
