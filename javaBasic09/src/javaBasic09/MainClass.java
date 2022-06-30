package javaBasic09;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * 
		 * Sorting : 정렬
		 * 			 선택, 버블, 합병, 퀵
		 * 
		 * 1. 몇 개를 정렬?
		 * >> 10
		 * 2. 갯수에 맞도록 배열 할당
		 * 3. 숫자들을 입력받는다.
		 * 4. 오름/내림 입력
		 * 5. 정렬 처리
		 * 6. 결과 출력
		 */
		
		int[] number = {4,3,5,2,1};
		
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i+1; j < number.length; j++) {
				if(number[i] < number[j]) { // swap
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(number));
		
		sort();

	}
	
	static void sort() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 개를 정렬하시겠습니까?");
		int N = sc.nextInt();
		
		
		int[] numbers = new int[N];
		
		/*
		for(int i=0;i<N;i++) {
			numbers[i] = sc.nextInt();
		}*/
		
		int w=0;
		while(w < N) {
			
			System.out.println((w+1) + "번째 수 = ");
			String numStr = sc.next(); // 잘못된 입력값일 경우 처리를 위해 입력은 문자열로 받는 것이 맞다.
			
			boolean b = true;
			for (int i = 0; i < numStr.length(); i++) {
				int asc = (int)numStr.charAt(i);
				
				if(asc < 48 || asc > 57) {
					b = false;
					break;
				}
			}
			
			if(!b) {
				System.out.println("숫자만 입력해주세요.");
				continue; // 조건문 남발은 코드가 지저분해짐! 최소한의 조건문만 사용하는 것이 좋다.
			}
			
			numbers[w] = Integer.parseInt(numStr);
			w++;
		}
		
		System.out.println("번호를 선택하세요. 1 : 오름차순, 2 : 내림차순");
		int n = sc.nextInt();
		
		if(n == 1) {
			for (int i = 0; i < numbers.length - 1; i++) {
				for (int j = i+1; j < numbers.length; j++) {
					if(numbers[i] > numbers[j]) {
						int temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}
			}
		}else {
			for (int i = 0; i < numbers.length - 1; i++) {
				for (int j = i+1; j < numbers.length; j++) {
					if(numbers[i] < numbers[j]) {
						int temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(numbers));
		
	}

}
