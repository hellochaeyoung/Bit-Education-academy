package sample05;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 * 
		 *  Array : 배열, 같은 자료형의 묶음 <- 변수들 
		 *  		목적 : 데이터 관리
		 *  					<-> 다른 자료형의 묶음 : class(JAVA), struct(C) -> DTO, VO
		 *  
		 *  		자료형 변수명[] = new 자료형[배열의 총 수];
		 *  
		 *  		정적, 동적
		 *  		static, dynamic
		 *  
		 *  		동적 할당 -> 정적
		 *  
		 *  		memory 영역 : stack, heap, static, system
		 *  
		 *  		int array[] = new int[5]; -> 내부적으로 포인터 사용, new 생성 시 heap에 위치
		 *  
		 *  		delete[] array; <- 가비지 컬렉션
		 */
		
		// 배열과 포인터는 동일..!
		int[] array = new int[5]; // -> 4byte
		
		System.out.println(array);
		
		System.out.println(array[0]);
		
		System.out.println(array.length);
		
		int[] array1 = {2,3,5,7,9};
		
		for(int i=0;i<array1.length;i++) {
			System.out.println(array[i]);
		}
		
		// 배열 복사
		int[] array2 = array1; // 얕은 복사! 주소값
		/*
		 * for (int i = 0; i < array2.length; i++) { System.out.println(array2[i]); }
		 */
		
		array2[2] = 6;
		
		System.out.println("Array1[2] = " + array1[2]); // 얕은 복사로 인해 변경된 값 출력
		
		int[] number1 = {1,2,3};
		int[] number2 = {7,8,9};
		
		/*
		 * // swap int a, b; a=1; b=2;
		 * 
		 * int temp; temp = a; a = b; b = temp;
		 */
		
		// 배열 swap 하려면? - 배열 요소 하나씩 swap 하면 데이터 많을 때 불가능
		
		// 원본 데이터는 변경되면 안되기 때문에 새로운 배열 생성하여 사용
		int[] num1 = number1;
		int[] num2 = number2;
		
		int[] temp;
		temp = num1;
		num1 = num2;
		num2 = temp;
		
		for (int i = 0; i < num2.length; i++) {
			System.out.println("num2[" + i + "] " + num2[i]);
		}
		
		int numberArrayPosition[] = {1,2,3};
		
		int[] numArrPos = numberArrayPosition;
		
		// 2차원 배열 선언 방식, 4개 다 가능, 포인터와 거의 동일!
		//int[][] arr2 = new int[3][4];
		//int arr2[][] = new int[3][4];
		//int []arr2[] = new int[3][4];
		//int [][]arr2 = new int[3][4];
		
		int arr2[][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		
		/*
		 * int [][]arr2;
		 * int **arr2;
		 * => 둘이 동일!!
		 * 
		 * int **Array2 = arr2;
		 * 
		 *  = *(*(Arrays2 + 1) + 2) => 7!!!!
		 */
		
		System.out.println(arr2);
		System.out.println(arr2[1][2]);

		int arrNum[][] = null; // #define NULL (0) => 주소값을 0으로 지정해버리겠다
		
		arrNum = new int[3][];
		
		int a1[] = {1,2,3};
		arrNum[0] = a1;
		
		int a2[] = {4,5,6,7};
		arrNum[1] = a2;
		
		int a3[] = {8,9};
		arrNum[2] = a3;
		
		for (int i = 0; i < arrNum.length; i++) {
			for (int j = 0; j < arrNum[i].length; j++) {
				System.out.print(arrNum[i][j] + "\t");
			}
			System.out.println();
		}
		
		
	}

}
