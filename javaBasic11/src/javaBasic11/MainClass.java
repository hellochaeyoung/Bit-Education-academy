package javaBasic11;

import cls.MyClass;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 절차 지향 : 변수 선언, 함수 -> 연산
		 * 					 순서 지향 1 2 3 4
		 * 					 유지보수 매우 안좋음, 재사용성 X
		 * 					 속도 우수, C언어
		 * 
		 * 객체 지향 : class(object 설계도)
		 * 			유지보수에 매우 우수, 재사용성,
		 * 			가독성, Java, C#
		 * 
		 */
		
		// 초기화
		int[] array = {1,2,3};
		
		// MyClass mycls = {1, "홍길동", 180}; -> 클래스 이런 방식으로 생성 불가능
		
		/*
		 * 
		 * 따라서 생성자 필요! Constructor != initialize(init 메소드는 여러 번 호출 가능하기 때문)
		 * -> class 생성 시 자동으로 한번만 호출되는 함수, 초기화
		 * -> 클래스명과 같은 함수, 리턴값 없음, 오버로드 가능
		 * -> 생략 가능
		 * 
		 * stack  heap  static  system
		 * class  new
		 * 
		 */

		// MyClass mycls = new MyClass();
		
		// mycls = new MyClass(1, "asd");
		
		MyClass mycls = new MyClass(1, "asd", 190.2);
		
		System.out.println(mycls.toString());
		
		System.out.println(mycls);
		
		System.out.println(mycls.getThis());
	}

}
