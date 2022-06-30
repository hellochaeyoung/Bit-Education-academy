package main;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * final : const(상수), define
		 * 			변수, 메소드, 클래스
		 * 
		 */
		
		final int number = 10; // 변수 -> 상수 ( 변경 불가 )
		
		final int NUMBER_COUNT = 100;
		
		int num = NUMBER_COUNT;
		
		

	}

}

/*final */ class SuperClass { // -> final 클래스는 상속 금지
	
	public /*final*/ void method() { // -> final 메소드는 override 금지..!
		
	}
}

class ChildClass extends SuperClass {
	
	@Override
	public void method() {
		
	}
}
