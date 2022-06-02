package sample03;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1, num2;
		num1 = 3;
		num2 = 2; // exception 발생
		
		int result = num1 / num2;
		
		System.out.println(num1 + " / " + num2 + " = " + result);
		
		// increment(++), decrement(--)
		
		int num = 1;
		
		System.out.println(num++);
		System.out.println(++num);
		
		int a = 0;
		int b = 0;
		
		b = (a++); // 괄호를 해도 우선순위로 되지 않는다
		
		System.out.println(a + "," + b);
		
		// 논리 연산자
		// &&, ||, !
		
		
		int n = 5;
		
		System.out.println(n > 5);
		
		System.out.println(n > 0 && n <= 5);
		
		System.out.println(n < 0 || n <= 5);
		
		System.out.println(n > 0 && n < 10);
		
		System.out.println(n != 9);
		
		// 삼항 연산자 --> 여기서 더 발전된 것이 람다식!!
		// ( 조건 ) ? 값1 : 값2
		
		int m;
		m = (n > 0) ? 100 : 200;
		System.out.println("m = " + m);
		
		char c;
		c = (n < 0) ? 'Y' : 'N';
		System.out.println("c = " + c);
		
		
		// 비트 연산 : 0, 1
		/*
		 * & 	AND
		 * | 	OR
		 * ^ 	XOR
		 * << 	left shift
		 * >> 	right shift
		 * ~ 	NOT
		 * 
		 */
		
		//AND
		int number = 0x71 & 0x85;
		
		/*
		 * 7	1
		 * 8421	8421
		 * 0111	0001
		 * 
		 * 8	5
		 * 8421	8421
		 * 1000	0101
		 * 
		 * 
		 * 0111	0001	
		 * 1000	0101	
		 * 
		 * and
		 * 0000	0001	
		 * 				
		 * 
		 * or
		 * 1111	0101
		 * 
		 * xor
		 * 1111	0101
		 * 
		 * 
		 * data 0111 0001
		 * key  1000 0101
		 * 암호화 1111 0100
		 * 
		 * 
		 * 		1111 0100
		 * 		1000 0101
		 * 복호화 0111 0001
		 */
		

		System.out.println("number = " + number);
		System.out.printf("0x%x\n", number);
		
		number = 0x71 | 0x85;
		System.out.printf("0x%x\n", number);
		
		
		// xor 연산을 가장 많이 쓴다.(보안쪽에서)
		
		number = 0x71 ^ 0x85;
		System.out.printf("0x%x\n", number);
		
		number = 0xf4 ^ 0x85;
		System.out.printf("0x%x\n", number);
		
		// left shift == *2
		
		byte by;
		by = 0x1 << 2;
		System.out.println("by = " + by);
		
		//right shift == /2
		by = 0x4 >> 1;
		System.out.println("by = " + by);
		
		
		// ~ 반전 0 -> 1 1 -> 0
		by = ~0x55;
		
		/*
		 * 0101	0101
		 * 8421 8421
		 * 1010 1010
		 * 10 A	10 A
		 * 
		 */
		
		System.out.println("by = " + by);
		System.out.printf("0x%x\n", by);
		
	}

}
