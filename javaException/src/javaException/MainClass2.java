package javaException;

import java.io.File;

public class MainClass2 {

	public static void main(String[] args) {
		
		// NPE
		String str = null;
		
		try {
			System.out.println(str.length());
		}catch(Exception e) { // 부모 클래스로 선언해도 익셉션 동일하게 다 잡힌다.
			System.out.println("str은 null입니다.");
			str = "hello"; //  예를 들어, 사용자의 입력값이 잘못되었을 때 이렇게 디폴트 값을 넣어줘서 처리해준다.
		}

		System.out.println("str = " + str);
		
		// ArrayIndexOutOfBoundsException
		
		int[] arr = {1,2,3};
		
		try {
			arr[3] = 4; //
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// FileNotFountException
		
		
		// NumberFormatException
		try {
			int i = Integer.parseInt("12a3fg");
		}catch(NumberFormatException e) {
			System.out.println("숫자가 아닙니다.");
		}
	}

}
