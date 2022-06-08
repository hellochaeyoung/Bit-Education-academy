package javaException;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 	Exception != error
		 *  에러를 잡아낼 수 있는 수단
		 *  
		 *  ex) 
		 *  number -> ABC
		 *  array -> out of index
		 *  class -> 없음
		 *  file -> 없음
		 *  
		 *  형식 : 
		 *  
		 *  try {
		 *  
		 *  	예외 발생 가능 코드
		 *  
		 *  } catch ( 예외클래스1 e) {
		 *  	메시지 출력
		 *  } catch ( 예외클래스1 e) {
		 *  	메시지 출력
		 *  } catch ( 예외클래스1 e) {
		 *  	메시지 출력
		 *  } finally {
		 *  
		 *  	무조건 실행
		 *  	rollback 수행
		 *  }
		 *  
		 *  void method() throws 예외클래스 {
		 *  	
		 *  }
		 *  
		 *
		 */
		
		/*
		 * int[] array = {1,2,3};
		 * 
		 * System.out.println("start");
		 * 
		 * try { for(int i=0;i<4;i++) { System.out.println(array[i]); } }
		 * catch(Exception e) { e.printStackTrace(); System.out.println(e.getMessage());
		 * System.out.println("배열 범위 초과");
		 * 
		 * //return;
		 * 
		 * } finally { System.out.println("finally"); }
		 * 
		 * System.out.println("end");
		 * 
		 */
		
		method();
		
		try {
			callClass();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void method() throws IndexOutOfBoundsException {
		
		int[] array = {1,2,3};
		
		for(int i=0;i<4;i++) {
			System.out.println(array[i]);
		}
	}
	
	static void callClass() throws ClassNotFoundException {
		
		Class.forName("myClass");
		System.out.println("myclass callClass()");
		
	}
	

}
