package main;

import java.util.Calendar;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * MyClass cls = new MyClass(); cls.method(); // 인스턴스 메소드
		 * 
		 * cls.staticMethod(); // 인스턴스를 통해서도 static 메소드 호출은 됨
		 */
		
		// MyClass.staticMethod();
		
		MyClass mycls = MyClass.getObject();
		
		Calendar cal = Calendar.getInstance();
	}

}
