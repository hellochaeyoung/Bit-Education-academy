package work;

import java.util.Scanner;

public class Work05 {

	public static void main(String[] args) {
		
		// 함수 -> 숫자가 입력이 안되면 다시 입력
		// 첫번째 수 입력
		
		
		// 연산자 입력 -> 연산자가 정상입력
		
		// 두번째 수 입력
		
		// 연산
		
		// 결과 출력
		
		int[] number = new int[2];
		
		int n1 = inputNumber();
		String op = inputOperator();
		int n2 = inputNumber();
		
		int result = calc(n1, n2, op);
		
		System.out.println("연산 결과 = " + result);

	}
	
	static int inputNumber() {
		
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			boolean check = true;
			System.out.println("숫자를 입력하세요 : ");
			String n1 = sc.next();
			
			if(n1.trim().equals("")) { // 빈 문자열 처리
				System.out.println("숫자를 정확히 입력해주세요");
				continue;
			}
			
			for(int i=0;i<n1.length();i++) {
				int c = (int)n1.charAt(i);
				
				if(c < 48 || c > 57) {
					check = false;
					System.out.println("숫자로 입력하세요");
					break;
				}
			}
			
			if(check) {
				num = Integer.parseInt(n1);
				break;
			}
			
		}
		
		return num;
		
	}
	
	static String inputOperator() {
		
		Scanner sc = new Scanner(System.in);
		
		String op = "";
		while(true) {
			System.out.println("연산자를 입력하세요 : ");
			op = sc.next();
			
			if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
				break;
			}
			
			System.out.println("올바른 연산자가 아닙니다.");
			
		}
		
		return op;
		
	}
	
	static int calc(int n, int m, String op) {
		
		switch(op) {
			case "+" : return n+m;
			case "-" : return n-m;
			case "*" : return n*m;
			case "/" : {
				if(m != 0) {
					return n/m;
				}
			}
		}
		
		return 0;
	}

}
