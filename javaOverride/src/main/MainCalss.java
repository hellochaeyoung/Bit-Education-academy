package main;

import cls.ChildClass;
import overridecls.ChildOne;
import overridecls.ChildTwo;
import overridecls.SuperClass;

public class MainCalss {

	public static void main(String[] args) {
		
		/*
		 * 
		 * Override : 부모 클래스로부터 상속 받은 메소드를 고쳐 기입하는 것
		 */
		
		/*
		 * ChildClass cc = new ChildClass(); cc.method();
		 */
		
		/*
		ChildOne one = new ChildOne();
		ChildTwo two = new ChildTwo();
		
		one.method();
		two.method();
		*/
		
		
		/*
		ChildOne[] arrOne = new ChildOne[10];
		ChildTwo[] arrTwo = new ChildTwo[10];
		
		for (int i = 0; i < arrTwo.length; i++) {
			arrOne[i] = new ChildOne();
			arrTwo[i] = new ChildTwo();
		}
		
		// 입력도 다 나눠서 해야 함
		arrOne[0] = new ChildOne();
		arrOne[1].method();
		arrOne[2].method();
		arrTwo[0] = new ChildTwo();
		
		// 출력도 마찬가지
		
		*/
		
		// 지만 부모 클래스로 자식 클래스들을 관리해버리면 하나의 포인터로 여러 개를 관리 가능
		SuperClass sc = new ChildOne();
		sc.method();
		
		
		// 하나의 인스턴스로 여러 종류의 인스턴스 관리 가능
		SuperClass[] arraySuper = new SuperClass[3];
		
		arraySuper[0] = new ChildOne();
		arraySuper[1] = new ChildOne();
		arraySuper[2] = new ChildTwo();
		
		for (int i = 0; i < arraySuper.length; i++) {
			arraySuper[i].method();
			
			if(arraySuper[i] instanceof ChildOne) {
				ChildOne co = (ChildOne)arraySuper[i];
				co.childOneMethod();
			}
		}
	}

}
