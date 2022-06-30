package work;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Work00 {

	public static void main(String[] args) {
		
		/*
		 * Scanner sc = new Scanner(System.in); int price = sc.nextInt(); int money =
		 * sc.nextInt();
		 */
		
		int price = 3210;
		int money = 10000;
		
		int rest = money - price;
		//System.out.println(rest);
		
		int[] moneys = {5000, 1000, 500, 100, 50, 10};
		int[] restArr = new int[moneys.length];
		
		for(int i=0;i<moneys.length;i++) {
			int r = rest / moneys[i];
			if(r != 0) {
				restArr[i] += r;
				rest %= moneys[i];
			}
		}
		
		for(int i=0;i<moneys.length;i++) {
			System.out.println(moneys[i] + "원 -> " + restArr[i]);
		}
		
		
		// Random : 무작위, 난수
		// Random <--> Pattern
		
		// 0 ~ 9
		int r = (int)(Math.random() * 10);
		System.out.println("r = " + r);
		
		// 10 20 30 40 50
		r = ((int)(Math.random() * 5) + 1) * 10;
		
		// -1 0 1
		int x = (int)(Math.random() * 3) - 1;
		int y = (int)(Math.random() * 3) - 1;
		
		// 3,7,4,5,9
		int[] arr = {3, 7, 4, 5, 9};

	}

}
