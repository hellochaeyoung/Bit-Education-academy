package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Work02 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * Baseball
		 * 
		 * random 3개
		 * 
		 * 1~10 -> 3개
		 * 
		 * 3 7 2 -> r1 != r2 != r3 세 숫자 다 다르게
		 * 
		 * user input -> 3개, 10회
		 * 4 5 2 -> 1 strike
		 * 1 9 3 -> 1 ball
		 */
		
		/*
		int[] random = new int[3];
		
		// 랜덤 숫자 중복 없애기
		 * 이 방법은 야구 게임 에서는 쓸 수 없음 -> 입력값의 순서가 중요하기 때문에 입력 순서가 보장되지 않는 해시셋으로 할 수 없다
		HashSet<Integer> set = new HashSet<>();
		while(true) {
			int r = (int)(Math.random() * 10 + 1); 
			
			set.add(r);
			
			if(set.size() == 3) break;
		}
		
		*/
		
		
		Scanner sc = new Scanner(System.in);
		
	      int r_num[] = new int[3];
	      int u_num[] = new int[3];
	      boolean clear = false;
	      String nextGame = "";
	      
	      while (true) {
	         boolean swit[] = new boolean[10];
	         for (int i=0; i<swit.length; i++) {
	            swit[i] = false;
	         }
	         
	         int w = 0;
	         while (w < 3) {
	            int r = (int)(Math.random()*10); // 0 ~ 9
	            if (swit[r] == false) {
	               swit[r] = true;
	               r_num[w] = r + 1;
	               w++;
	            }
	         }
	         
	         System.out.println(Arrays.toString(r_num));
	         
	         // 판정
	         w = 0;
	         while (w < 10) {
	            for (int i=0; i<u_num.length; i++) {
	               System.out.print((i + 1) + "번째 수 = ");
	               u_num[i] = sc.nextInt();
	            }
	            
	            int strike = 0;
	            int ball = 0;
	            
	            // ball
	            for (int i=0; i<u_num.length; i++) {
	               for (int j=0; j<u_num.length; j++) {
	                  if (u_num[i] == r_num[j] && i != j) {
	                     ball++;
	                  }
	               }
	            }
	            
	            // strike
	            for (int i=0; i<u_num.length; i++) {
	               if (u_num[i] == r_num[i]) {
	                  strike++;
	               }
	            }
	            
	            if (strike > 2) {
	               clear = true;
	               break;
	            }
	            
	            System.out.println(strike + "스트라이크 " + ball + "볼 입니다");
	            
	            w++;
	         }
	         
	         if (clear) {
	            System.out.println("Game Clear !");
	         }
	         else {
	            System.out.println("Game Over ~");
	            break;
	         }
	         
	         System.out.println("play again(y/n) = ");
	         nextGame = sc.next();
	         
	         if (nextGame.equals("y")) {
	            System.out.println("Next Game Start!!");
	         }
	      }
		
		
		

	}

}
