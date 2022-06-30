package main;

public class MyClass {
	
	public void method() {
		System.out.println("MyClass method()");
	}
	
	public static void staticMethod() {
		System.out.println("MyClass staticMethod()");
	}
	
	// 언제 static 메소드를 사용?
	public static MyClass getObject() {
		
		// 처리가 많을 때 -> 모바일, 게임 쪽에서 이런 코드를 많이 사용
		MyClass my = new MyClass();
		
		my.method();
		
		// 처리1
		
		// 처리2
		
		return my;
	}

}
