package main;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * abstract class : 일반메소드 + 추상메소드 + 멤버변수
		 * 
		 * interface : 추상메소드
		 * 				포함하는 메소드가 선언만 되어 있다 -> 정의가 되어 있는게 아님
		 * 				다중 상속이 가능
		 * 				선언을 통해서 클래스의 내용 파악이 빠르다
		 * 				부모 클래스의 instance형으로는 많이 사용됨
		 */
		
		// new 생성 안됨
		
		MyClass mycls = new MyClass();
		mycls.method(0);
		
		YouClass ycls = new YouClass();
		ycls.func("aaa");
		ycls.method(99);
		
		MyInterface my = new MyClass();
		my.method(100);
		
		MyInterface my2 = new YouClass();
		my2.method(200);
		//my2.func(); -> 불가
		
		((YouInterface)my2).func("hello");

	}

}
