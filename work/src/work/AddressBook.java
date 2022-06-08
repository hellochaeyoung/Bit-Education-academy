package work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AddressBook {

	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		/*
		 * 주소록
		 * 
		 * column : 이름, 나이, 전화번호, 주소, 메모
		 * 
		 * 2차원 배열로 관리 : row = 100
		 * 
		 * 데이터 파일에서 불러오기 -> 배열에 넣기
		 * 
		 * Menu
		 * 1. 추가
		 * 2. 삭제
		 * 3. 검색 이름, 전화번호
		 * 4. 수정
		 * 5. 모든 데이터 출력
		 * 6. 데이터 파일저장
		 * 7. 종료
		 */
		
		
		String[][] phoneBook = new String[100][5];
		
		load(phoneBook);
		
		while(true) {
			
			System.out.println("주소록 메뉴 : (1)추가, (2)삭제, (3)검색, (4)수정, (5)출력, (6)파일저장, (7)종료");
			
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			if(n == 7) break;
			
			switch(n) {
				case 1 : {
					insert(phoneBook);
					break;
				}
				case 2 : {
					delete(phoneBook);
					break;
				}
				case 3 : {
					select(phoneBook);
					break;
				}
				case 4 : {
					update(phoneBook);
					break;
				}
				case 5 : {
					print(phoneBook);
					break;
				}
				case 6 : {
					fileSave(phoneBook);
					break;
				}
				default : {
					System.out.println("번호를 다시 입력하세요");
					break;
				}
			}
		}
		

	}
	
	static void load(String[][] phoneBook) throws Exception {
		
		File file = new File("c:\\Temp\\phoneBook.txt");
		
		if(file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringTokenizer st;
			String str = "";
			
			while((str = br.readLine()) != null) {
				st = new StringTokenizer(str, "/");
				for(int i=0;i<5;i++) {
					phoneBook[cnt][i] = st.nextToken();
				}
				cnt++;
			}
		}
		
	}
	
	// CRUD - Create Read Update Delete
	// DAO - Data Access Object
	
	static void insert(String[][] phoneBook) throws IOException {
		
		System.out.println("추가할 정보를 입력하세요(이름/나이/전화번호/주소/메모)=>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "/");
		
		for(int i=0;i<5;i++) {
			phoneBook[cnt][i] = st.nextToken();
		}
		
		cnt++;
		
		System.out.println("추가가 완료되었습니다.");
		
	}
	
	static void delete(String[][] phoneBook) throws IOException {
		
		int idx = search(phoneBook);
		
		if(idx == -1) {
			System.out.println("해당 이름의 정보를 찾을 수 없습니다.");
			return;
		}
		
		for(int j=0;j<5;j++) {
			phoneBook[idx][j] = null;
		}
		System.out.println("삭제를 완료하였습니다.");
		
	
	}
	
	static void select(String[][] phoneBook) throws IOException {
		
		String[][] findMember = searchAll(phoneBook);
		
		if(findMember == null) {
			System.out.println("해당 이름의 정보를 찾을 수 없습니다.");
			return;
		}
		
		for(int j=0;j<5;j++) {
			System.out.println(Arrays.toString(findMember[j]));
		}
		
	}
	
	static void update(String[][] phoneBook) throws IOException {
		
		int idx = search(phoneBook);
		
		if(idx == -1) {
			System.out.println("해당 이름의 정보를 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("수정할 번호와 내용을 입력하세요(1.이름, 2.나이, 3.번호, 4.주소, 5.메모), 형식 : 번호/내용");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "/");
		
		int n = Integer.parseInt(st.nextToken());
		String newInfo = st.nextToken();
		phoneBook[idx][n-1] = newInfo;
		
		System.out.println("수정을 완료하였습니다.");
		
	}
	
	static int search(String[][] phoneBook) throws IOException {
		
		System.out.println("이름을 입력하세요=>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		for(int i=0;i<cnt;i++) {
			if(phoneBook[i][0].equals(name)) {
				return i;
			}
		}
		
		return -1;
	}
	
	// 동명이인 처리
	static String[][] searchAll(String[][] phoneBook) throws IOException {
		
		System.out.println("이름을 입력하세요=>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		int count = 0;
		for(int i=0;i<cnt;i++) {
			if(phoneBook[i][0] != null && phoneBook[i][0].equals(name)) { // null 체크 꼭 필요!! 또는 name.equals(phoneBook[i][0]) 이렇게 순서를 바꿔주는 게 더 좋다(NPE 방지위해)
				count++;
			}
		}
		
		if(count == 0) return null;
		
		String[][] resultArray = new String[count][5];
		int idx = 0;
		for(int i=0;i<cnt;i++) {
			if(phoneBook[i][0] != null && phoneBook[i][0].equals(name)) {
				resultArray[idx] = phoneBook[i];
				idx++;
			}
		}
		
		return resultArray;
	}
	
	
	static void print(String[][] phoneBook) {
		
		/*
		for(int i=0;i<cnt;i++) {
			boolean check = true;
			for(int j=0;j<5;j++) {
				if(phoneBook[i][j] == null) {
					check = false;
					break;
				}
				System.out.print(phoneBook[i][j] + " ");
			}
			if(check) System.out.println();
			
		}*/
		
		for (int i = 0; i < phoneBook.length; i++) {
			if(phoneBook[i][0] != null) {
				System.out.println(Arrays.toString(phoneBook[i]));
			}
			
		}
	}
	
	static void fileSave(String[][] phoneBook) throws IOException {
		
		// TODO : fileSave(String[][] phoneBook)
		
		File file = new File("c:\\Temp\\phoneBook.txt");
		
		if(file.exists()) {
			file.delete();
		}
		
		file.createNewFile();
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
		// 1. 데이터 정제 및 정리 후 파일에 쓸 데이터만 따로 배열에 저장하여 쓰는 방법
		
		// 2. 반복문 돌면서 데이터 체크하고 바로 파일에 쓰는 방법
		for(int i=0;i<cnt;i++) {
			boolean check = false;
			StringBuilder sb = new StringBuilder();
			
			for(int j=0;j<5;j++) {
				if(phoneBook[i] != null) {
					check = true;
					sb.append(phoneBook[i][j] + "/");
				}
				
			}
			if(check) pw.println(sb.toString());
			
		}
		
		pw.close();
		
		System.out.println("파일 저장을 완료했습니다.");
		
	}

}
