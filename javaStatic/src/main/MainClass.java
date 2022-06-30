package main;

import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 
		 * static : 정적 => 변하지 않는다.
		 * <-> dynamic
		 */

		MyClass cls = new MyClass();
		cls.method(0, null);
		cls.method(0, null);
		cls.method(0, null);
		
		MyClass mycls = new MyClass();
		mycls.method(0, null);
	}

}
