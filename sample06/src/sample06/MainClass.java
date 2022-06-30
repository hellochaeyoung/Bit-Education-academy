package sample06;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 제어문
		 * 
		 * if( 조건 ) { == true/false
		 *		처리 
		 * }
		 * 
		 * > <= == >= <= != 
		 * && || !
		 */
		
		int number = 5;
		
		if(number > 0) {
			System.out.println("number > 0");
		}
		
		if(number > 0 && number < 10) {
			System.out.println("number > 0 && number < 10");
		}
		
		if(number < 0 || number > 10) {
			System.out.println("number < 0 || number > 10");
		}
		
		if(number < 0) {
			System.out.println("number < 0");
		}else {
			System.out.println("number > 0");
		}
		
		String str = (number < 0) ? "number < 0" : "number > 0";
		System.out.println("str = " + str);
		
		number = 90;
		
		if(number > 90) {
			System.out.println("number > 90");
		}else if(number > 80) {
			System.out.println("number > 80");
		}else if(number > 70) {
			System.out.println("number > 70");
		}else {
			System.out.println("number <= 70");
		}
		
		number = 95;
		
		if(number >= 90 && number <= 100) {
			if(number >= 95) {
				System.out.println("A+");
			}else {
				System.out.println("A");
			}
		}
		
		boolean b = false;
		if(b == false) {
			
		}
		
		String _str = "hello";
		
		if(!_str.equals("world")) {
			System.out.println("_str은 hello가 아닙니다.");
		}
		
		if(_str.contains("he")) {
			System.out.println("_str은 he를 포함하고 있습니다.");
		}
		
		// switch
		/*
		 * 조건문 보다 속도가 빠르다.
		 * 하지만 사용 권장하지 않음
		 * 조건문과 비슷
		 * 범위 지정 불가
		 * 실수 사용 불가
		 * 조건 사용 불가
		 * 
		 */
		
		int n = 2;
		
		switch(n) {
			case 1 : 
				System.out.println("n은 1");
				break;
			case 2 :
				System.out.println("n은 2");
				break;
			default :
				System.out.println("n은 1도 2도 아님");
				break;
		}
		
		String str1 = "hello";
		
		// C에서는 char은 되지만 문자열은 switch문에서 사용 불가, 자바에서부터 가능해짐
		switch(str1) { 
			case "hello" :
				System.out.println("str1은 hello");
				break;
		}
		
		
	}

}
