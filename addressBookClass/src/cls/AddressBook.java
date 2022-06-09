package cls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AddressBook {

	List<Human> infoList;
	File file;
	
	// init
	public void init() {
		infoList = new ArrayList<>();
		file = new File("c:\\Temp\\phoneBook.txt");
	}
	
	// load
	public void load() throws IOException {
		
		if(file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringTokenizer st;
			String str = "";
			
			while((str = br.readLine()) != null) {
				st = new StringTokenizer(str, "/");
				
				String name = st.nextToken();
				int age = Integer.parseInt(st.nextToken());
				String phone = st.nextToken();
				String address = st.nextToken();
				String memo = st.nextToken();
				
				infoList.add(new Human(name, age, phone, address, memo));
			}
		}
	}
	
	public void insert() throws IOException {
		
		System.out.println("추가할 정보를 입력하세요(이름/나이/전화번호/주소/메모)=>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "/");
		
		String name = st.nextToken();
		int age = Integer.parseInt(st.nextToken());
		String phone = st.nextToken();
		String address = st.nextToken();
		String memo = st.nextToken();
		
		infoList.add(new Human(name, age, phone, address, memo));
		
		
		System.out.println("추가가 완료되었습니다.");
		
	}
	
	public void delete() throws IOException {
		
		Human findHuman = search();
		
		if(findHuman == null) {
			System.out.println("해당 이름의 정보를 찾을 수 없습니다.");
			return;
		}
		
		infoList.remove(findHuman);
		
		System.out.println("삭제를 완료하였습니다.");
		
	
	}
	
	public void select() throws IOException {
		
		List<Human> resultList = searchAll();
		
		if(resultList.size() == 0) {
			System.out.println("해당 이름의 정보를 찾을 수 없습니다.");
			return;
		}
		
		for(Human h : resultList) {
			h.print();
		}
		
	}
	
	public void update() throws IOException {
		
		Human findHuman = search();
		
		if(findHuman == null) {
			System.out.println("해당 이름의 정보를 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("수정할 번호와 내용을 입력하세요(1.이름, 2.나이, 3.번호, 4.주소, 5.메모), 형식 : 번호/내용");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "/");
		
		int n = Integer.parseInt(st.nextToken());
		String data = st.nextToken();
		
		switch(n) {
			case 1 : {
				findHuman.setName(data);
				break;
			}
			case 2 : {
				findHuman.setAge(Integer.parseInt(data));
				break;
			}
			case 3 : {
				findHuman.setPhone(data);
				break;
			}
			case 4 : {
				findHuman.setAddress(data);
				break;
			}
			case 5 : {
				findHuman.setMemo(data);
				break;
			}
		}
		
		System.out.println("수정을 완료하였습니다.");
		
	}
	
	public Human search() throws IOException {
		
		System.out.println("이름을 입력하세요=>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		for(Human h : infoList) {
			if(h.getName().equals(name)) {
				return h;
			}
		}
		
		return null;
	}
	
	// 동명이인 처리
	public List<Human> searchAll() throws IOException {
		
		System.out.println("이름을 입력하세요=>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		List<Human> result = new ArrayList<>();
		for(Human h : infoList) {
			if(h.getName().equals(name)) {
				result.add(h);
			}
		}
		
		return result;
	}
	
	public void print() {
		
		for(Human h : infoList) {
			h.print();
		}
	}
	
	public void save() throws IOException {
		
		// TODO : fileSave(String[][] phoneBook)
		
		//File file = new File("c:\\Temp\\phoneBook.txt");
		
		if(file.exists()) {
			file.delete();
		}
		
		file.createNewFile();
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
		for(Human h : infoList) {
			pw.println(h.toString());
		}
		
		pw.close();
		
		System.out.println("파일 저장을 완료했습니다.");
		
	}
	
	public void start() throws Exception {
		init();
		
		load();
		
		while(true) {
			
			System.out.println("주소록 메뉴 : (1)추가, (2)삭제, (3)검색, (4)수정, (5)출력, (6)파일저장, (7)종료");
			
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			if(n == 7) break;
			
			switch(n) {
				case 1 : {
					insert();
					break;
				}
				case 2 : {
					delete();
					break;
				}
				case 3 : {
					select();
					break;
				}
				case 4 : {
					update();
					break;
				}
				case 5 : {
					print();
					break;
				}
				case 6 : {
					save();
					break;
				}
				default : {
					System.out.println("번호를 다시 입력하세요");
					break;
				}
			}
		}
	}
	
}
