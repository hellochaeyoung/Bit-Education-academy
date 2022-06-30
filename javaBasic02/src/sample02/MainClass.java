package sample02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//input
		Scanner sc = new Scanner(System.in);
		
		/*
		// boolean
		boolean b;
		System.out.println("b = ");
		b = sc.nextBoolean();
		System.out.println("input b = " + b);
		*/
		
		/*
		 * // integer int num; System.out.println("num = "); num = sc.nextInt();
		 * System.out.println("input num = " + num);
		 */
		// double
		
//		
//		// String
//		String str;
//		System.out.println("str = ");
//		str = sc.next();
//		System.out.println("str = " + str);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("str = ");
		String str = br.readLine();
		System.out.println("str = " + str);
		

	}

}
