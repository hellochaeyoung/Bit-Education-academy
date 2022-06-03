package sample07;

public class MainClass {

	public static void main(String[] args) {
		
		// for loop 반복문, 순환문, 루프문
		// for
		// foreach
		
		int n;
		for (n=0;n<10;n++) {
			System.out.println("n = " + n);
		}
		
		for(int i=0;i<10;i++) {
			System.out.println("i = " + i);
		}
		
		for(int i=1;i<=100;i++) { // 위험
			
		}
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(i + ":" +  j + " ");
			}
			System.out.println();
		}
		
		int array[][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print("array[" + i + "][" + j + "] = " + array[i][j] + " ");
			}
			System.out.println();
		}
		
		int arr[] = {1,2,3};
		
		for(int num : arr) {
			System.out.println(num);
		}
		
		// while, do while
		int w;
		w = 0;
		while(w < 10) {
			System.out.println("while loop " + w);
			w++;
		}
		
		// initialize
		
		// loop
		
		// release
		
		int w1,w2;
		w1 = w2 = 0;
		
		while(w1 < 5) {
			System.out.println("w1 : " + w1);
			w2 = 0;
			while(w2 < 3) {
				System.out.println("\tw2 : " + w2);
				w2++;
			}
			w1++;
		}
		
		int w3 = 0;
		
		do {
			System.out.println("w3 : " + w3);
			w3++;
		}while(w3 < 5);
		

	}

}
