package main;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

	// 정렬할 숫자 변수
	int[] number = null;
	boolean updown;
	
	// 처리
	// 1. 초기화
	public void init() {
		updown = true;
	}
	
	
	// 2. 입력
	public int input() {
		//		총수
		//		숫자들
		//		오름/내림
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 개를 정렬하시겠습니까?");
		int N = sc.nextInt();
		
		number = new int[N];
		
		int w=0;
		while(w < number.length) {
			System.out.println((w+1) + "번째 수 = ");
			
			String numStr = sc.next();
			boolean b = checkMethod(numStr);
			
			if(!b) {
				System.out.println("숫자만 입력해주세요.");
				continue; // 조건문 남발은 코드가 지저분해짐! 최소한의 조건문만 사용하는 것이 좋다.
			}
			
			number[w] = Integer.parseInt(numStr);
			w++;
			
		}
		
		System.out.println("번호를 선택하세요. 1 : 오름차순, 2 : 내림차순");
		int n = sc.nextInt();
		
		return n;
	}
	
	
	// 3. 정렬
	public void sorting() {
		
		int n = input();
		
		if(n == 1) {
			for (int i = 0; i < number.length - 1; i++) {
				for (int j = i+1; j < number.length; j++) {
					if(number[i] > number[j]) {
						swap(i,j);
					}
				}
			}
		}else {
			for (int i = 0; i < number.length - 1; i++) {
				for (int j = i+1; j < number.length; j++) {
					if(number[i] < number[j]) {
						swap(i,j);
					}
				}
			}
		}
	}
	
	// 4. 결과 출력
	public void result() {
		
		if(updown) {
			System.out.println("오름차순 정렬");
		}else {
			System.out.println("내림차순 정렬");
		}
		
		System.out.println(Arrays.toString(number));
	}
	
	public boolean checkMethod(String numStr) {
		
		boolean b = true;
		for (int i = 0; i < numStr.length(); i++) {
			int asc = (int)numStr.charAt(i);
			
			if(asc < 48 || asc > 57) {
				b = false;
				break;
			}
		}
		
		return b;
		
	}
	
	public void swap(int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}
}
