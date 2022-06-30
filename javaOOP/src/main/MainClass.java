package main;

import cls.Human;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 절차지향 -> 순서를 중시
		 * 5만 라인을 초과하는 순간 작성자가 힘들어 진다. -> 비효율적이라는 말
		 * 
		 * OOP : Object Oriented Programming 객체 지향
		 * 
		 */
		
		Human h = new Human();
		// h : instance, object, 객체라 지칭  ( class 변수 )
		h.name = "홍길동";
		h.age = 24;
		h.address = "서울시";
		
		h.method();

	}

}
