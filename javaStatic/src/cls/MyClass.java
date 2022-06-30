package cls;

public class MyClass {
	
	// 변수의 종류
	private int number; // 멤버변수
	
	public static int glNumber; // static 변수, 전역변수 
	// -> static 영역은 다 같이 사용한다 즉 공유한다!, 프로세스/스레드 실행 시작할 때 생성되었다가 종료해야 삭제됨
	// 따라서 남말하면 메모리가 낭비됨
	
	public void method(int num, int[] arr) { // 매개변수 : 외부에서 값을 받는 변수, 단 arr 처럼 배열은 input 값이 아닌 output이다(포인터)
		
		int localNum = 0; // 지역변수 -> stack, 매개변수도 stack에 생성됨, 함수 호출 시 스택에 생겼다가 함수가 종료되는 즉시 stack에서 삭제됨
		
		localNum++;
		glNumber++;
		number++;
		
		System.out.println("localNum : " + localNum);
		System.out.println("static : " + glNumber);
		System.out.println("number : " + number);
		
		
		
	}

}
