package work;

import java.util.Scanner;

public class Work01 {

	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		System.out.println("어느 작업을 하시겠습니까?");
		Scanner s = new Scanner(System.in);
		
		int num = s.nextInt();
		
		if(num == 1) {
			from10to2();
		}else if(num == 2) {
			from2to10();
		}else if(num == 3) {
			from10to16();
		}else if(num == 4){
			from16to10();
		}else {
			checkNumber();
		}
		

	}
	
	static void from10to2() {
		
		// 1. 10진수 입력 -> 2진수(String)
		int num = sc.nextInt();
		
		while(true) {
			int r = num % 2;
			sb.insert(0, r);
			
			// numStr = r + numStr -> 자동 형변환 및 뒤에 붙이기
			
			num /= 2;
			
			if(num < 2) {
				sb.insert(0, num);
				break;
			}
		}
		
		System.out.println(sb);
		
		//
		String numStr = Integer.toBinaryString(10);
	}
	
	static void from2to10() {
		
		// 2. 2진수(String) -> 10진수 출력
		String str = sc.next();
		
		int len = str.length() / 4;
		String[] arr = new String[len];
		
		int z=0;
		for(int i=0;i<len;i++) {
			String temp = str.substring(z, z+4);
			
			arr[i] = temp;
			z += 4;
		}
		
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			int tempSum = 0;
			for(int j=0;j<arr[i].length();j++) {
				int tmp = (int) Math.pow(2, 3-j);
				char indexStr = arr[i].charAt(j);
				if(indexStr == '1') {
					tempSum += tmp;
				}
			}
			
			int total = (int) Math.pow(16, len-1-i);
			sum += total * tempSum;
		}
		
		System.out.println(sum);
		
		////
		int number = 0;
		len = str.length();
		int oldLen = len;
		for(int i=0;i<oldLen;i++) {
			char c = str.charAt(i);
			
			int n = Integer.parseInt(c + "");
			int nm = (int)Math.pow(2, len-1);
			
			n *= nm;
			
			number += n;
			len--;
		}
		
		//
		number = Integer.parseInt(str,10);
	}
	
	static void from10to16() {
		
		// 3. 10진수 입력 -> 16진수(String)
		int n = sc.nextInt();
		sb = new StringBuilder();
		while(true) {
			int r = n % 16;
			
			if(r >= 10) {
				char c = (char) ('a' +  (r - 10));
				sb.insert(0, c);
			}else {
				sb.insert(0, r);
			}
			
			n /= 16;
			
			if(n < 16) {
				if(n >= 10) {
					char c = (char) ('a' +  (n - 10));
					sb.insert(0, c);
				}else {
					sb.insert(0, n);
				}
				break;
			}
		}
		
		System.out.println(sb.toString());
		
		String result = Integer.toHexString(n);
		
	}
	
	static void from16to10() {
		
		// 16진수 입력(String) -> 10진수 출력
		
		String st = sc.next();
		
		int sum = 0;
		
		String[] arr = st.split("");
		for(int i=0;i<arr.length;i++) {
			int r = (int)Math.pow(16, st.length() - 1 - i);
			
			if(st.charAt(i) >= 65) {
				int n = st.charAt(i) - 55;
				sum += n;
			}else {
				int num = Integer.parseInt(arr[i]);
				sum += num * r;
			}
			
		}
		
		System.out.println(sum);
		
		/*
		String str = "3A";
		int len16 = str.length();
		
		String n16;
		int oldLen = len16;
		int powNum;
		int number16 = 0;
		int num16;
		
		for (int i = 0; i < str.length(); i++) {
			
			n16 = str.charAt(i) + ""; // char -> String
			if(n16.equals("A")) {
				
			}
			
		}*/
		
		//
		int result = Integer.parseInt(st, 16);
		
	}
	
	static void checkNumber() {
		
		/*
		 * 입력받은 문자열이 모두 숫자로 되어있는지 확인
		 * 
		 */
		
		String inputStr = sc.next();
		
		String[] arr = inputStr.split("");
		for(String s : arr) {
			try {
				Integer.parseInt(s);
			}catch(Exception e) {
				System.out.println("숫자가 아닙니다");
				return;
			}
		}
		
		System.out.println("숫자로 되어 있습니다.");
		
		
		////
		String strNum = "1234";
		boolean numTrue = true;
		
		for (int i = 0; i < strNum.length(); i++) {
			char c = strNum.charAt(i);
			
			int asc = (int)c;
			if(asc < 48 || asc > 57) {
				numTrue = false;
				break;
			}
		}
		
		if(numTrue) {
			System.out.println("숫자입니다.");
		}else {
			System.out.println("문자입니다.");
		}
	}

}
