package manage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import cls.Batter;
import cls.Pitcher;
import cls.Player;
import file.PlayerFile;

public class Management {
	
	private List<Player> list;
	private PlayerFile file;
	//private File file;
	private int cnt;
	
	public void init() {
		list = new ArrayList<>();
		file = new PlayerFile(new File("C:\\Temp\\BaseballPlayer.txt"));
		cnt = 0;
	}
	
	public void load() throws IOException {
		list = file.read();
	}
	
	public void insert() throws Exception {
		
		System.out.println("추가 선수의 정보를 선택하세요 1) 선수, 2) 포수 3) 타자");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		if(n == 1) {
			System.out.println("선수의 기본 정보를 입력하세요 [이름/나이/키]");
			
			st = new StringTokenizer(br.readLine(), "/");
			
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			double height = Double.parseDouble(st.nextToken());
			
			list.add(new Player(++cnt, name, age, height));
			
		}else if( n == 2) {
			System.out.println("포수의 정보를 입력하세요 [이름/나이/키/승/패/방어율] >>");
			
			st = new StringTokenizer(br.readLine(), "/");
			
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			double height = Double.parseDouble(st.nextToken());
			int win = Integer.parseInt(st.nextToken());
			int lose = Integer.parseInt(st.nextToken());
			double rate = Double.parseDouble(st.nextToken());
			
			list.add(new Pitcher(++cnt, name, age, height, win, lose, rate));
			
		}else {
			System.out.println("타자의 정보를 입력하세요 [이름/나이/키/타수/안타수/타율] >>");
			
			st = new StringTokenizer(br.readLine(), "/");
			
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			double height = Double.parseDouble(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			int hitCount = Integer.parseInt(st.nextToken());
			double hitRate = Double.parseDouble(st.nextToken());
			
			list.add(new Batter(++cnt, name, age, height, count, hitCount, hitRate));
			
		}
		
		System.out.println("추가가 완료되었습니다.");
	}
	
	public void delete() throws IOException {
		
		System.out.println("삭제할 선수의 이름을 입력하세요>>");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		boolean check = false;
		for(Player p : list) {
			if(p.getName().equals(name)) {
				check = true;
				list.remove(p);
				break;
			}
		}
		
		if(check) System.out.println("삭제를 완료하였습니다.");
		else System.out.println("해당 이름을 찾을 수 없습니다.");
		
	}

	public void select() throws IOException {
		
		List<Player> resultList = new ArrayList<>();
		
		System.out.println("검색할 선수의 이름을 입력하세요>>");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		for(Player p : list) {
			if(p.getName().equals(name)) {
				resultList.add(p);
			}
		}
		
		for(Player p : resultList) {
			System.out.println(p.toString());
		}
	}
	
	public void update() throws IOException {
		
		System.out.println("정보를 수정할 선수의 이름을 입력하세요>>");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		
		int num = 0;
		String data = "";
		for(Player p : list) {
			if(p.getName().equals(name)) {
				if(p instanceof Player) {
					System.out.println("수정할 정보를 선택해주세요 1)이름 2)나이 3)키");
					
				}else if(p instanceof Pitcher) {
					System.out.println("수정할 정보를 선택해주세요 1)이름 2)나이 3)키 4)승 5)패 6)방어율");
					
				}else if(p instanceof Batter) {
					System.out.println("수정할 정보를 선택해주세요 1)이름 2)나이 3)키 4)타수 5)안타수 6)타율");
					
				}
				
				num = Integer.parseInt(br.readLine());
				
				System.out.println("새로운 정보를 입력해주세요>>");
				data = br.readLine();
				
				p.update(num, data);
				
				break;
			}
		}
		
		if(num == 0) System.out.println("찾을 수 없는 이름입니다.");
		else System.out.println("수정을 완료하였습니다.");	
		
	}
	
	public void print() {
		
		for(Player p : list) {
			System.out.println(p.toString());
		}
		
	}
	
	public void save() throws IOException {
		
		file.write(list);
		
		System.out.println("파일 저장을 완료했습니다.");
	}
	
	public void start() throws Exception {
		
		init();
		
		load();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("번호를 선택하세요 1) 추가, 2) 삭제, 3) 검색, 4) 수정, 5) 출력, 6) 저장, 7) 종료");
			
			int num = sc.nextInt();
			
			if(num == 7) break;
			
			switch(num) {
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
			}
		}
	}
	
}
