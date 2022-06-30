package javaBasic10;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 
		 * function : 함수			c언어
		 * method : class에 소속된 함수 java
		 * 
		 * return 값의 자료형 함수명( 인수, 인자, parameter ) {
		 * 
		 * 		//  처리
		 * 
		 * 		return 값;
		 * 
		 * }
		 * 
		 * parameter : num -> 가인수
		 * argument : 123 -> 실인수
		 * 
		 * func( 123);
		 * 
		 * void func(int num) {
		 * 
		 * }
		 */
		
		func();
		func(123);
		
		int n = 1;
		char c = 'A';
		int[] array = {1,2,3};
		func(n, c, array);
		
		System.out.println("n = " + n);
		System.out.println("array[1] = " + array[1]);
		
		// 문자열 -> 모두 숫자로 되어 있는지? (소수)
		//		-> 정수, 소수
		// boolean isNumber
		// String isDouble
		
		System.out.println(isNumber("123.3345"));
		
		System.out.println(isDouble("123"));
		
		// 문자열에 소문자가 포함되어 있는지?
		System.out.println(checkSmallAlpha("2333aaa"));
		
		// 두 수를 나눈 몫과 나머지를 구하는 함수 => 1개의 함수 만을 사용
		int num1 = 9, num2 = 2;
		int[] tag = new int[1];
		
		int result = div(num1, num2, tag);
		System.out.println("몫 : " + result + " 나머지 : " + tag[0]);
	}
	
	static void func() {
		System.out.println("func() 호출");
	}
	
	static void func(int i) { // over loading
		System.out.println("func(int i) i = " + i);
	}

					 // value의 할당	address의 할당
	static void func(int i, char c, int[] arr) {
		System.out.println("func(int i, char c, int[] arr)");
		
		arr[1] = 22; // 값이 아닌 배열의 주소값이 넘어오기 때문에 원본에도 영향을 미친다.
	}
	
	static boolean isNumber(String str) {
		
		int cnt = 0;
		for(int i=0;i<str.length();i++) {
			int c = (int)str.charAt(i);
			
			if(c == 46 && (cnt + 1) == 1 && i != 0 && i != str.length()-1) {
				cnt++;
				continue;
			}
			
			if(c < 48 || c > 57) {
				return false;
			}
		}
		
		return true;
	}
	
	static String isDouble(String str) {
		
		if(isNumber(str)) {
			if(str.contains(".")) {
				return "소수";
			}
			
			return "정수";
		}
		
		return "숫자 아님";
	}
	
	static boolean checkSmallAlpha(String s) {
		
		for(int i=0;i<s.length();i++) {
			int c = (int)s.charAt(i);
			
			if(c >= 97 && c <= 122) {
				return true;
			}
		}
		
		return false;
		
	}
	
	static int[] divide(int n1, int n2) {
		return new int[] {n1 / n2, n1 % n2};
	}
	
	static int div(int n1, int n2, int[] t) { // 배열은 input 값이 아닌 output 값이다!
		int val = n1 / n2;
		t[0] = n1 % n2;
		
		return val;
	}
}
