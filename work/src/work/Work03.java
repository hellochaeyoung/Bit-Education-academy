package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Work03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/*
		 * 
		 * 학생 성적 관리
		 * 
		 * >> 학생 수
		 * 2차원 배열 할당
		 * 
		 * 입력
		 * 학생 이름, 번호, 국어, 영어, 수학
		 * 
		 * 국어의 최고점수는 몇점? 누구?
		 *
		 * 영어의 최하점수는 몇점? 누구?
		 * 
		 * 각 학생들의 총점, 평균
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int n = 5;
		String[][] students = new String[N][n];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n;j++) {
				students[i][j] = st.nextToken();
			}
		}
		
		int maxKor = Integer.MIN_VALUE;
		String maxKorPerson = "";
		
		int minEng = Integer.MAX_VALUE;
		String minEngPerson = "";
		
		int[][] result = new int[N][2];
		
		
		for(int i=0;i<N;i++) {
			int korScore = Integer.parseInt(students[i][2]);
			int engScore = Integer.parseInt(students[i][3]);
			int mathScore = Integer.parseInt(students[i][4]);
			
			if(korScore > maxKor) {
				maxKor = korScore;
				maxKorPerson = students[i][0];
			}
			
			if(engScore < minEng) {
				minEng = engScore;
				minEngPerson = students[i][0];
			}
			
			int sum = korScore + engScore + mathScore;
			int avg = sum / 3;
			
			result[i][0] = sum;
			result[i][1] = avg;
			
		}
		
		System.out.println("국어 최고 점수 = " + maxKor + "점, 학생이름 = " + maxKorPerson);
		System.out.println("영어 최하 점수 = " + minEng + "점, 학생이름 = " + minEngPerson);
		
		for(int i=0;i<result.length;i++) {
			System.out.println("학생 이름 : " + students[i][0] + ", 총점 : " + result[i][0] + "점, 평균 : " +  result[i][1]);
		} 

	}

}
