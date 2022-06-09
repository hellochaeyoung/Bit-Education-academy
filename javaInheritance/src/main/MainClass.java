package main;

import cls.Child;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 은닉성(캡슐화), (상속성, 다형성)
		 * 
		 * inheritance : 상속
		 * 
		 * (기본)class -> 상속
		 * 부모 클래스		 자식 클래스
		 * 
		 * variable
		 * function
		 */
		
		/*
		 * Child c = new Child();
		 * 
		 * c.parentMethod(); c.func();
		 */
		
		Child cc = new Child("aaa", 150.2, 12);

	}

}
