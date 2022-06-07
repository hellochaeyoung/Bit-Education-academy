package work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
		
		getPhoneData(phoneBook);
		
		while(true) {
			
			System.out.println("주소록 메뉴 : (1)추가, (2)삭제, (3)검색, (4)수정, (5)출력, (6)파일저장, (7)종료");
			
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			if(n == 7) break;
			
			switch(n) {
				case 1 : {
					add(phoneBook);
					break;
				}
				case 2 : {
					delete(phoneBook);
					break;
				}
				case 3 : {
					find(phoneBook);
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
	
	static void getPhoneData(String[][] phoneBook) throws Exception {
		
		File file = new File("c:\\Temp\\phoneBook.txt");
		
		if(file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringTokenizer st;
			String str = "";
			
			while((str = br.readLine()) != null) {
				st = new StringTokenizer(str);
				for(int i=0;i<5;i++) {
					phoneBook[cnt][i] = st.nextToken();
				}
				cnt++;
			}
		}
		
	}
	
	static void add(String[][] phoneBook) throws IOException {
		
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
		
		System.out.println("삭제할 번호의 이름을 입력하세요=>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		boolean check = false;
		for(int i=0;i<cnt;i++) {
			if(phoneBook[i][0].equals(name)) {
				check = true;
				for(int j=0;j<5;j++) {
					phoneBook[i][j] = null;
				}
				break;
			}
		}
		
		if(check) System.out.println("삭제를 완료하였습니다.");
		else System.out.println("해당 이름을 찾을 수 없습니다.");
	
	}
	
	static void find(String[][] phoneBook) throws IOException {
		
		System.out.println("검색할 번호의 이름을 입력하세요=>");
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String name = br.readLine();
		 
		 boolean check = false;
			for(int i=0;i<cnt;i++) {
				if(phoneBook[i][0].equals(name)) {
					check = true;
					for(int j=0;j<5;j++) {
						System.out.print(phoneBook[i][j] + " ");
					}
					System.out.println();
					break;
				}
			}
		 
		if(check) System.out.println("조회를 완료하였습니다.");
		else System.out.println("해당 이름의 정보를 찾을 수 없습니다.");
	}
	
	static void update(String[][] phoneBook) throws IOException {
		
		System.out.println("수정할 정보의 이름을 입력하세요=>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		 
		boolean check = false;
		for(int i=0;i<cnt;i++) {
			if(phoneBook[i][0].equals(name)) {
				check = true;
				System.out.println("수정할 번호와 변경 내용을 입력하세요(1.이름, 2.나이, 3.전화번호, 4.주소, 5.메모), 형식은 [번호/내용]=>");
				
				StringTokenizer st = new StringTokenizer(br.readLine(), "/");
				
				int n = Integer.parseInt(st.nextToken());
				String newInfo = st.nextToken();
				phoneBook[i][n-1] = newInfo;
				
				break;
			}
		}
		
		if(check) System.out.println("수정을 완료하였습니다.");
		else System.out.println("해당 이름의 정보를 찾을 수 없습니다.");
	}
	
	
	static void print(String[][] phoneBook) {
		
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
			
		}
	}
	
	static void fileSave(String[][] phoneBook) throws IOException {
		
		File file = new File("c:\\Temp\\phoneBook.txt");
		
		if(file.exists()) {
			file.delete();
		}
		
		file.createNewFile();
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
		for(int i=0;i<cnt;i++) {
			boolean check = true;
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<5;j++) {
				if(phoneBook[i][j] == null) {
					check = false;
					break;
				}
				sb.append(phoneBook[i][j] + " ");
			}
			if(check) pw.println(sb.toString().trim());
			
		}
		
		pw.close();
		
		System.out.println("파일 저장을 완료했습니다.");
		
	}

}
